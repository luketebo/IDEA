$(function ()  {
    // $("#gaiNan").click(function () {
    //     $('.common_gaiNan').show()
    //     $('.all').hide()
    //     $('.student').hide()
    //
    // })
    $("#chaKan").click(function () {
        $('.common_gaiNan').hide()
        $('.all').show()
        $('.student').hide()
    })
})

$("#send").click(function () {
    var stu = {
        id: parseInt($("#id").val()),
        name : $("#name").val(),
        classId: parseInt($("#classId").val()),
        cScore: parseInt($("#cScore").val()),
        webScore: parseInt($("#webScore").val()),
        javaScore: parseInt($("#javaScore").val()),
    }
    console.log(stu)
    $.ajax({
        url: "http://localhost:8081/addstu",
        // cache: false,
        type: "post",
        async: true,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(stu),
        success: function(result) {
            console.log(result);
        }
    })
})

function update_stu(id) {
    $.ajax({
        url: "/update",
        type: "POST",

    })
}

function del_stu(id) {
    $.ajax({
        url: "/delstu",
        type: "GET",

    })
}
function gaiNan() {
    console.log("概览");
    $("#main").load("gaiNan");
}
// function chaKan() {
//     console.log("查看")
//     $("#main").load("chaKan")
// }

$(() => {
    gai = document.getElementById("gaiNan");
    cha = document.getElementById("chaKan");
    gai.addEventListener("click", gaiNan);
    // cha.addEventListener("click", chaKan);
})

