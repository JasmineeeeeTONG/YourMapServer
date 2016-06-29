/**
 * Created by Dingyi on 2016/6/29.
 */
function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

window.onload = function() {
  alert("code: "+GetQueryString("code"));
    alert("state: "+GetQueryString("state"));
  alert("token: "+GetQueryString("access_token"));
    var code = GetQueryString("code");
    if(code!=null || code!="") {
        //window.location.href="https://github.com/login/oauth/access_token?client_id=6cdfa6b91383b5732650&client_secret=5738f5589c870d046cd8273bb7b2678a37f8889d&code="+code+"&redirect_uri=http://127.0.0.1:8080/githublogin/test.html";
        //alert("token: "+GetQueryString("access_token"));
        $.ajax("https://github.com/login/oauth/access_token?client_id=6cdfa6b91383b5732650&client_secret=5738f5589c870d046cd8273bb7b2678a37f8889d&code="+code+"&redirect_uri=http://127.0.0.1:8080/githublogin/test.html",
            {
                type:'GET',
                success:function(data){
                    alert(data);
                    console.log(data);
                }
            }
        );

    }
};