function PageList(options) {
    for (let i in options) {
        this[i] = options[i];
    }
    let obj = this;
    this.first.onclick = function () {
        obj.page = 1;
        obj.onChange();
    };
    this.prev.onclick = function () {
        obj.page = (obj.page > 1) ? (obj.page - 1) : 1;
        obj.onChange();
    };
    this.next.onclick = function () {
        obj.page = (obj.page >= obj.maxPage) ? obj.maxPage : (obj.page + 1);
        obj.onChange();
    };
    this.last.onclick = function () {
        obj.page = obj.maxPage;
        obj.onChange();
    };
}

//更新页码
PageList.prototype.updateStatus = function () {
    this.first.disabled = (this.page <= 1);
    this.prev.disabled = (this.page <= 1);
    this.next.disabled = (this.page >= this.maxPage);
    this.last.disabled = (this.page >= this.maxPage);
    this.pageNum.innerHTML = this.page;
    this.totalNum.innerHTML = this.maxPage;
};

function Comment(obj) {
}

//ajax请求
Comment.prototype.ajax = function (url, start, complete) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        let obj = '';
        if (xhr.readyState === 4) {
            if (xhr.status < 200 || xhr.status >= 300 && xhr.status !== 304) {
                alert('服务器异常');
                return;
            }
            try {
                obj = JSON.parse(xhr.responseText);
                //console.log(xhr.responseText);
            } catch (e) {
                alert('解析服务器返回信息失败');
                return;
            }
            complete(obj);
        }
    };
    xhr.open('GET', url);
    xhr.send();
    start();
};

//拼接html
Comment.prototype.create = function (result) {
    let teachers = result;
    let html = "<table class=\"table table-bordered\"><thead><tr><th>id</th><th>name</th><th>number</th></tr></thead><tbody>";
    for (let teacher of teachers) {
        html += "<tr><td>" + teacher.id + "</td><td>" + teacher.name + "</td><td>" + teacher.number + "</td></tr>";
    }
    html += "</tbody></table>";
    $('.teacher').html(html);
}

function ProgressBar(container) {
    this.container = container;
    this.div = document.createElement('div');
    this.container.appendChild(this.div);
}

//进度条初始化
ProgressBar.prototype.show = function () {
    this.div.style.width = '0%';
};
//进度条更新
ProgressBar.prototype.complete = function () {
    let div = this.div;
    let container = this.container;
    div.style.width = '100%';
    setTimeout(function () {
        div.style.opacity = '0';
        setTimeout(function () {
            container.removeChild(div);
        }, 300);
    }, 500);
};

//URL参数获取 表示page的页数
let QueryString = {
    get: function () {
        return location.search.substring(1);
    },
    set: function (str) {
        history.pushState(null, null, '?' + str);
    },
    find: function (name) {
        let reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
        let r = this.get().match(reg);
        return r ? decodeURI(r[2]) : null;
    },
    getPage: function () {
        let page = parseInt(this.find('page'));
        return (isNaN(page) || (page < 1)) ? 1 : page;
    }
};

let pageList = new PageList({
    page: QueryString.getPage(),
    maxPage: 1,
    first: document.getElementById('page_first'),
    prev: document.getElementById('page_prev'),
    next: document.getElementById('page_next'),
    last: document.getElementById('page_last'),
    pageNum: document.getElementById('page_num'),
    totalNum: document.getElementById('total_num'),
    onChange: function () {
        let teacher = new Comment(document.getElementById('teacher'));
        let progressContainer = document.getElementById('progress');
        let progressBar;
        teacher.ajax("http://localhost:80/getTeacher?page=" + this.page, function () {
            progressBar = new ProgressBar(progressContainer);
            progressBar.show();
        }, function (obj) {
            console.log(obj.records);
            pageList.maxPage = obj.pages;
            pageList.updateStatus();
            teacher.create(obj.records);
            QueryString.set('page=' + pageList.page);
            progressBar.complete();
        });
    }
});
pageList.onChange();


