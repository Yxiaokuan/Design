

function getURL() {
  return 'http://47.52.157.51:8080/';
}

function getUploadURL() {
  return 'http://47.52.157.51:8080/upload/';
}


/**
 * 获取URL传值
 * @param {String} name url中的参数名
 */
function GetQueryString(name) {
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if(r != null) return unescape(r[2]);
  return null;
}

/**
 * 数组去重
 * @param {Array} arr
 */
function duplicateRemoval(arr) {
  var res = [];
  var json = {};
  for(var i = 0; i < arr.length; i++) {
    if(!json[arr[i]]) {
      res.push(arr[i]);
      json[arr[i]] = 1;
    }
  }
  return res;
}

/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * @param {String} fmt 指定格式。例：(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * @property {Date} Format
 * @author meizz
 * @desc 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 */
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

/**
 * localStorage操作模块
 * @module localStorage操作模块
 * @function set 设置localStorage
 * @function get 获取localStorage
 * @function clear 清除localStorage
 */
var localStorageOpMod = new Object({
  //var dataObjData=get('information',1000);//过期时间为1秒,正常情况下，你点击的时候已经过期
  //var dataObjData=get('information',1000*60);//过期时间为1分钟
  //var dataObjData=get('information',1000*60*60);//过期时间为1小时
  //var Obj=get('information',1000*60*60*24);//过期时间为24小时
  //var dataObjData=get('information',1000*60*60*24*7);//过期时间为1周
  set: function(key, obj, activeTime) {
    var obj = JSON.stringify(obj);
    var curTime = new Date().getTime();
    var activeTime = activeTime * 1000;
    localStorage.setItem(key, JSON.stringify({
      time: curTime,
      activeTime: activeTime,
      data: obj
    }));
  },
  get: function(key) {
    var dataObj = JSON.parse(localStorage.getItem(key));
    if(!dataObj) return false;
    if(new Date().getTime() - dataObj.time > dataObj.activeTime) {
      localStorage.removeItem(key);
    } else {
      var dataObjDatatoJson = JSON.parse(dataObj.data);
      return dataObjDatatoJson;
    }
  },
  clear: function(key) {
    localStorage.removeItem(key);
  }
});

/**
 * cookie操作模块
 * @module cookie操作模块
 * @function add 添加cookie
 * @function get 获取cookie
 * @function modify 修改cookie
 * @function clear 清除localStorage
 * @function isCookieJs 判断是否加载jquery.cookie.js
 */
var cookieOpMod = new Object({
  add: function(cookie, value) {
    this.isCookieJs();
    var expire = new Date();
    expire.setTime(expire.getTime() + (60 * 60 * 1000));
    $.cookie(cookie, value, {
      expires: expire,
      path: '/'
    });
  },
  get: function(cookie) {
    this.isCookieJs();
    return $.cookie(cookie);
  },
  modify: function(cookie, value) {
    this.isCookieJs();
    var c = $.cookie(cookie);
    $.cookie(cookie, value, {
      path: '/'
    });
    if(c != value) {
      jump();
    }
  },
  clear: function(cookie) {
    this.isCookieJs();
    var expires = new Date();
    expires.setTime(expires.getTime() - 1000);
    $.cookie(cookie, null, {
      expires: expires,
      path: '/'
    });
  },
  isCookieJs: function() {
    if(typeof($.cookie) === "undefined") throw new Error("Please load first [jquery.cookie.js]");
  }
});

/**
 * ajax请求失败弹窗
 * @param {String} err 
 */
function reqError(err) {
  if(typeof err === "string") {
    layer.msg(err);
  } else {
    layer.msg('服务器响应失败！')
  }
}