/* -- 全局常量 -- */
var URL = "http://47.52.157.51:8080/";
// var DOCURL = "http://www.vzone.cn/VzoneDocument/";

/* -- 全局操作function -- */
/**
 * 获取URL传值
 */
function GetQueryString(name) {
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r != null)
    return unescape(r[2]);
  return null;
}

/* cookie操作模块 */
var cookieOpMod = {
  set: function(cookie, value) {
    var expire = new Date();
    expire.setTime(expire.getTime() + (60 * 60 * 1000));
    $.cookie(cookie, value, {
      // expires: expire,
      path: '/'
    });
  },
  clear: function(cookie) {
    var expires = new Date();
    expires.setTime(expires.getTime() - 1000);
    $.cookie(cookie, null, {
      expires: expires,
      path: '/'
    });
  }
};

Date.prototype.Format = function(fmt) {
  var o = {
    "M+": this.getMonth() + 1, //月份
    "d+": this.getDate(), //日
    "h+": this.getHours(), //小时
    "m+": this.getMinutes(), //分
    "s+": this.getSeconds(), //秒
    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
    "S": this.getMilliseconds() //毫秒
  };
  if(/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  for(var k in o)
    if(new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
  return fmt;
}