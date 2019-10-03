/**
 * Created by shawn on 2017/6/6.
 */

console.log("trace","this is from otherjs");
var hostAndPort='http://103.235.228.90:8080';
var userinfor=JSON.parse(localStorage.getItem("userinfor"));

function number_format_common(number) {
    return number_format(number, 2, '.', ',');
}
/*
 * 小数点四舍五入 参数说明：
 * number：要格式化的数字
 * decimals：保留几位小数
 * dec_point：小数点符号
 * thousands_sep：千分位符号
 *
 * 例子 var num=number_format(1234567.089, 2, ".", ",");
 *     console.log(num);        //  1,234,567.09
 */
function number_format(number, decimals, dec_point, thousands_sep) {
    number = (number + '').replace(/[^0-9+-Ee.]/g, '');
    var n = !isFinite(+number) ? 0 : +number,
        prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
        sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
        dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
        s = '',
        toFixedFix = function (n, prec) {
            var k = Math.pow(10, prec);
            return '' + Math.ceil(n * k) / k;
        };

    s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
    var re = /(-?\d+)(\d{3})/;
    while (re.test(s[0])) {
        s[0] = s[0].replace(re, "$1" + sep + "$2");
    }

    if ((s[1] || '').length < prec) {
        s[1] = s[1] || '';
        s[1] += new Array(prec - s[1].length + 1).join('0');
    }
    return s.join(dec);
}

/**
 * 通过时间戳获取时间字符串（yyyy-mm-dd）
 */
function dateStringWithTimeInterval(interval) {
    if (typeof(interval) === 'string') {
        interval = parseInt(interval);
    }
    var date = new Date(interval);
    var year = date.getFullYear();
    var month = addZeroAtLeft(date.getMonth() + 1);
    var day = addZeroAtLeft(date.getDate());
    return year + "-" + month + "-" + day;
}

/**
 * 通过日期完整字符(yyyy-MM-dd HH:mm:ss)串获取日期字符串（yyyy-MM-dd）
 */
function dateStringWithDateAndTimeString(dateAndTimeString) {
    if (typeof(dateAndTimeString) === 'string' && dateAndTimeString.length >= 10) {
        return dateAndTimeString.substring(0, 10);
    }
    return dateAndTimeString;
}

function timeIntervalWithDateString(dateString) {
    if (dateString && dateString.length === 10) {
        dateString = dateString + ' 08:00:00';
        var date = new Date(Date.parse(dateString.replace(/-/g, "/")));
        return date.getTime();
    }
    return 0;
}

/**
 * 数字左侧补零（如果是小于10的数字）
 */
function addZeroAtLeft(value) {
    if (typeof(value) === 'string') {
        value = parseInt(value);
    }
    if (value < 10) {
        return '0' + value;
    }
    return value;
}

/**
 * 从数组中删除指定元素
 */
function popObjFromArray(arr, val) {
    if (arr && arr.length) {
        var index = arr.indexOf(val);
        if (index >= 0) {
            arr.splice(index, 1);
        }
    }
}

function ajax(ajaxContent) {
    var data = ajaxContent.data ? (typeof(ajaxContent.data) === 'string' ? JSON.parse(ajaxContent.data) : ajaxContent.data) : {};
    data.proSessionId = userinfor.proSessionId;
    $.ajax({
        url: hostAndPort + ajaxContent.url,
        type: ajaxContent.type,
        contentType: ajaxContent.contentType ? ajaxContent.contentType : 'application/json',
        dataType: ajaxContent.dataType ? ajaxContent.dataType : 'json',
        data: JSON.stringify(data),
        success: ajaxContent.success,
        statusCode: {
            403: function() {
                window.location.href="../login/html-main.html";
            }
        },
        error: ajaxContent.error
    })
}
//删除左右两端的空格
function trim(str){
    return str.replace(/(^\s*)|(\s*$)/g, "");
}

// window.otherjs.hostAndPort=otherjs.hostAndPort;
module.exports = {
    number_format: number_format,
    number_format_common: number_format_common,
    dateStringWithDateAndTimeString: dateStringWithDateAndTimeString,
    dateStringWithTimeInterval: dateStringWithTimeInterval,
    timeIntervalWithDateString: timeIntervalWithDateString,
    popObjFromArray: popObjFromArray,
    trim: trim,
    ajax: ajax,
    hostAndPort: hostAndPort
};