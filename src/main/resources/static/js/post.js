function index(userName, password) {
    var temp = document.createElement("form"); //创建form表单
    temp.action = url;
    temp.method = "post";
    temp.style.display = "none";//表单样式为隐藏
    var opt1 = document.createElement("input");  //添加input标签
    var opt2 = document.createElement("input");  //添加input标签
    opt1.value = userName;
    opt1.name = userName;
    opt2.value = password;
    opt2.name=password;

    temp.appendChild(opt1);
    temp.appendChild(opt2);
    document.body.appendChild(temp);
    temp.submit();
    return temp
}