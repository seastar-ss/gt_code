var _=require("./base.js");
var conf={
    //输入模板的基礎位置
    parentFolder:"",
    //第一次模板输出html文件的基础位置
    baseFolder:"dist/html",
    //输出的资源文件基础路径
    baseResourceFolder:"dist/front_end/",
    //页面内引用基础文件使用的服务器前缀
    baseHost:"",
    //页面内引用基础文件使用的路径前缀
    basePath:"./",
    baseHtmlOutputFolder:"dist/html",
    assetReferPath:"../../asset"
};
_.prepare(conf);


var tmpl =  "views/templates/layouts/defaultLayout.html";
var base = {
    _httpHeader:  "views/templates/parts/defaultHttpHeader.html",
    title: "测试项目",
    svg_img_logo:"../../asset"+"/_img_logo.svg",
    img_band_logo:"../../asset/"+"imgs/logo.png",
    hostAndPort:"127.0.0.1:8080",
    currentVersion:"v1.0.0",
    _header:  "views/templates/parts/defaultHeader.html",
    _menu:  "views/templates/parts/defaultMenu.html",
    _topNav:  "views/templates/parts/defaultTopNav.html",
    _footer: "views/templates/parts/defaultFooter.html",
    _jsBottom:  "views/templates/parts/defaultScript.html",
    commonEntry:[
        "views/templates/common/animate.css"
        //"views/asset/static/css/bootstrap.css",
        //"views/asset/static/font-awesome/css/font-awesome.css",
        //"views/asset/static/LESS/style.less",
        //"views/asset/static/js/plugins/metisMenu/jquery.metisMenu.js"
    ],
    asset:conf.assetReferPath
};
//,"views/pages/public/otherjs.js"
var templates = {
    /*
     qws
     */
    // 列表
    //"mallPage": _.commonSetting(base,"views/pages/mallPages/mallList.html","shouye"),
    //// 安全设置
    //"revisePwd": _.commonSetting(base,"views/pages/revisePwd/revisePwd.html","修改密码"),
    //// 忘记密码
    //"forgetPwd": _.commonSetting(base,"views/pages/forgetPwd/forgetPwd.html","忘记密码"),
    //// 404页面
    //"notFound404": _.commonSetting(base,"views/pages/notFound404/notFound404.html","404"),

    "config": _.commonSetting(base,"views/pages/data_source_config_page/config.html","首页"),
    //"config":_.commonSetting(base,"")
};

var tmplLogin =   "views/templates/layouts/defaultLayoutLogin.html";
var templateLogin = {
    //登录
    "login": _.commonSetting({
        _httpHeader:  "views/templates/parts/defaultHttpHeader.html",
        _jsBottom:  "views/templates/parts/defaultScript.html",
    },"views/pages/login/login.html","登录"),
};

//_.buildAll(tmplLogin, templateLogin, baseFolder);
//_.buildAll(tmplLogin,templateLogin);

//_.buildAll(tmpl, templates);
//for(var x in templateLogin){
//    templates[x]=templateLogin[x];
//}
module.exports={
    templates:[
        {"tmpl":tmpl,"pages":templates},
        //{"tmpl":tmplLogin,"pages":templateLogin}
    ],
    conf:conf,
    preBuild:_.buildAll
};