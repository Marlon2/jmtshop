charset="UTF-8";
function manage(img1,basepath){
	var $img1 = $(img1);
	var $managediv = $img1.next().first();
	var divid = $managediv.attr("id");
	var disp = $managediv.css("display")=="none"?"block":"none";
	$managediv.css({display:disp});
	if(disp=="none"){
		img1.src = basepath+"images/"+divid+"1.png";
	}else{
		img1.src = basepath+"images/"+divid+"2.png";
	}
}
function gettime(){
	var now=new Date();
	document.getElementById("timeId").innerHTML=now.toLocaleString();
	window.setTimeout("gettime()",1000);
}
window.onload=gettime;
function showTime(){
	var $timeId=$("#timeId");
	var x=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
	var e=new Date();
	var day=e.getDay();
	$timeId.html("日期:"+e.getFullYear()+"年"+(e.getMonth()+1)+"月"+e.getDate()+"日  "+x[day]);
}
function tishi() {
	window.history.go(-1);
	alert("shouye");
}

