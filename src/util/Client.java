package util;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class Client {

	public static String sendSMS(String token) {
		try {
	        HttpClient client = new HttpClient();  
	        GetMethod get = new GetMethod("https://api.github.com/user?access_token=" + token);
	        // PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");  
	        client.executeMethod(get);  
	        Header[] headers = get.getResponseHeaders();  
	        int statusCode = get.getStatusCode();  
	        String result = new String(get.getResponseBodyAsString().getBytes("gbk"));  
	        return result;
		}
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
	public static String sendSMSS(String code) {
		String x = "";
		try {
	        HttpClient client = new HttpClient();  
	        PostMethod post = new PostMethod("https://github.com/login/oauth/access_token");  
	        // PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");  
	        post.addRequestHeader("Content-Type",  
	                "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码  
	        NameValuePair[] data = { new NameValuePair("client_id", "6cdfa6b91383b5732650"),// 注册的用户名  
	                new NameValuePair("client_secret", "5738f5589c870d046cd8273bb7b2678a37f8889d"),// 注册成功后，登录网站后得到的密钥  
	                new NameValuePair("redirect_uri", "http://localhost:8080/YourMap/www/result.html"),
	                new NameValuePair("code", code)};// 手机号码  
	       
	        post.setRequestBody(data);  
	  
	        client.executeMethod(post);  
	        Header[] headers = post.getResponseHeaders();  
	        int statusCode = post.getStatusCode(); 
	        String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
	        x = result.substring(13, 53);
	        
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return x;	
	}
	
	
	
}
