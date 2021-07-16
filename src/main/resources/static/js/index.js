$(function () {
    var yearChar = $("#nowDate").val().split("");
    for (var i = 0; i < yearChar.length; i++) {
        $(".year")[i].innerText = yearChar[i];
    }
    var width = $(".year").css("width").split("px")[0];
    var height = width / 0.76;
    var fontSize = height * 0.8;
    var fontSize1 = fontSize * 0.6;
    $(".year").css("height", height + "px");
    $(".year").css("line-height", height + "px");
    $(".year").css("font-size", fontSize + "px");
    $(".year1").css("line-height", height + "px");
    $(".year1").css("font-size", fontSize1 + "px");
    var widthTime = $("#morning_up").width();
    var heightTime = $("#morning_up").height();
    $(".type").css("line-height", heightTime + "px");
    $(".time").css("line-height", heightTime + "px");
    var fontSizeTime = widthTime * 0.12;
    $(".type").css("font-size", fontSizeTime + "px");
    $(".time").css("font-size", fontSizeTime + "px");
    getAttendanceInfo();
})

function getAttendanceInfo() {
    var baseurl = "http://localhost:8881/attendance/getAttendance";
    $.ajax({
        url: baseurl,
        type: 'get',
        data: {"jobNumber": $("#jobNumber").val()},
        dataType: 'json',
        success: function (result) {
            $.each(result, function (index, item) {
                switch (item.status) {
                    case 1:
                        if (item.type === "迟到" || item.type === "早退") {
                            $("#morning_up").css("background-color", "red");
                        } else if (item.type === "上班" || item.type === "下班") {
                            $("#morning_up").css("background-color", "#2f71b9");
                        }
                        $("#morning_up_time").text(item.attendanceTime);
                        $("#morning_up_value").text(item.type);
                        break;
                    case 2:
                        if (item.type === "迟到" || item.type === "早退") {
                            $("#morning_down").css("background-color", "red");
                        } else if (item.type === "上班" || item.type === "下班") {
                            $("#morning_down").css("background-color", "#2f71b9");
                        }
                        $("#morning_down_time").text(item.attendanceTime);
                        $("#morning_down_value").text(item.type);
                        break;
                    case 3:
                        if (item.type === "迟到" || item.type === "早退") {
                            $("#afternoon_up").css("background-color", "red");
                        } else if (item.type === "上班" || item.type === "下班") {
                            $("#afternoon_up").css("background-color", "#2f71b9");
                        }
                        $("#afternoon_up_time").text(item.attendanceTime);
                        $("#afternoon_up_value").text(item.type);
                        break;
                    case 4:
                        if (item.type === "迟到" || item.type === "早退") {
                            $("#afternoon_down").css("background-color", "red");
                        } else if (item.type === "上班" || item.type === "下班") {
                            $("#afternoon_down").css("background-color", "#2f71b9");
                        }
                        $("#afternoon_down_time").text(item.attendanceTime);
                        $("#afternoon_down_value").text(item.type);
                        break;
                }
            })
        }
    })
}