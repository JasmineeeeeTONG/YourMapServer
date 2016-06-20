
var module = document.getElementById("module");
var lastTime = document.getElementById("time");
var file = document.getElementById("file");

document.getElementById("submit").addEventListener("click", function() {
	x(1);
	var uploadHTTP;
	if(window.ActiveXObject) {
		uploadHTTP=new ActiveXObject("Microsoft.XMLHTTP"); 
	}
	else if(window.XMLHttpRequest) {
		uploadHTTP=new XMLHttpRequest;
	}
	//var url="http://123.56.239.143:8080/server/user/login";
	//var url = "http://msg.umeng.com/api/send?sign=";
	var url = "http://localhost:8080/Adweb/sightListGetBySightType"
	uploadHTTP.open("POST",url,false);
	var str2 = '{"sightType":{"1"}}';
	
	//var str2 = '{ "phoneNum": "123", "password":"1233456", "deviceTokens":"12是3", "hhh":"hhhhh"}';
	//var str2 = '{ "phoneNum": "12", "token": "12", "relationshipPhoneNum":"13","relationType":"1","userProperty":"erzi", "relationshipUserProperty":"baba" }';
	//var str2 = '{ "phoneNum": "15968688993", "token":"0.19415795728093033", "location":'+'{"phoneNum":"15968688993","latitude":"0.1","longitude":"0.2","location":"111"}'+'}';
	//var str2 = '{ "phoneNum": "15968688992", "token":"1", "relationshipPhoneNum":"155", "relationType": "-1"}';
	
	uploadHTTP.setRequestHeader("Content-type","application/json");
//	uploadHTTP.send(str2);
	uploadHTTP.onreadystatechange=function(){
		if(uploadHTTP.readyState==4 && uploadHTTP.status==200){
			console.log(uploadHTTP.responseText);
			alert("!23");
		}
	}


})

function x(a) {
	alert(a);
	return a;
}