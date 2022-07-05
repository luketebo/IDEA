var createId = 0;
var list_as;
var list_cl;
var prt = true;
$.ajax({
    url: "http://" + window.location.host + "/InfoGet/me",
    success: (r) => {
        console.log(r);
        createId = r["id"];
    },
});

function create(id, title, content, classes, time, deadline) {
    his_snip = [
        '<div class="card mb-3" id="',
        'a" style="min-width:37vw"><div class="card-header">',
        '</div><div class="card-body container"><h5 class="card-title">',
        '</h5><p class="card-text"> 班级: ',
        '</p><div class="d-flex justify-content-between"><footer><cite title="Source Title">',
        "&nbsp-&nbsp",
        '</cite></footer><div class="d-flex"><a href="javascript:void(0);"\
        class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#InfoModal" data-bs-action="modify_',
        '">修改</a>&nbsp<a href="javascript:void(0);" id="',
        'd" class="btn btn-danger" data-bs-container="body" data-bs-toggle="popover" data-bs-placement="top" data-bs-title="确认删除吗？">删除</a>&nbsp<a href="javascript:void(0);" id="',
        'c" class="btn btn-success">批改</a></div></div></div></div>',
    ];
    return (
        his_snip[0] +
        id +
        his_snip[1] +
        title +
        his_snip[2] +
        content +
        his_snip[3] +
        classes +
        his_snip[4] +
        time +
        his_snip[5] +
        deadline +
        his_snip[6] +
        id +
        his_snip[7] +
        id +
        his_snip[8] +
        id +
        his_snip[9]
    );
}

function formatS(strVal) {
    const strLen = strVal.length;
    if (strLen < 2) {
        return "0" + strVal;
    } else {
        return strVal;
    }
}

function formatDate(time) {
    var dates = new Date(time);
    var date = new Date(dates.getTime() - 8 * 60 * 60 * 1000);
    var year = date.getFullYear(),
        month = date.getMonth() + 1, //月份是从0开始的
        day = date.getDate(),
        hour = date.getHours(),
        min = date.getMinutes(),
        sec = date.getSeconds();
    var newTime =
        year +
        "-" +
        month +
        "-" +
        day +
        " " +
        formatS(""+hour) +
        ":" +
        formatS(""+min) +
        ":" +
        formatS(""+sec);
    return newTime;
}

function createAs() {
    if (prt) console.log("布置作业");
    $("#main").load("createAs");
}

function checkAs() {
    if (prt) console.log("");
    $("#main").load("checkAs");
}

function readAs() {
    if (prt) console.log("批改作业");
    $("#main").load("readAs");
}

function createCl() {
    if (prt) console.log("创建班级");
    $("#main").load("createCl");
}

function check_as(id) {
    if (prt) console.log("批改作业 id: " + id);
}

$(() => {
    cas = document.getElementById("createAs");
    ces = document.getElementById("checkAs");
    ras = document.getElementById("readAs");
    ccl = document.getElementById("createCl");
    cas.addEventListener("click", createAs);
    ces.addEventListener("click", checkAs);
    ras.addEventListener("click", readAs);
    ccl.addEventListener("click", createCl);
});
