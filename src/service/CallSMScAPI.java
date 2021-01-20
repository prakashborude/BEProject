package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class CallSMScAPI {
public static String retval="";
public static String SMSSender(String user,String password,String msisdn,String msg,String sid,String fl)
{
	String rsp="";
//	System.out.println(message);
//	System.out.println(number);
	try
	{
	
	String apiKey="rvvLHX7sSK9bc9qLQMMv9ApYG1cNlupfoXKJDDPwpojIMS2SFnw9mSXpBMvE";
	String sendId="FSTSMS";
	//important step...
	sid=URLEncoder.encode(sid, "UTF-8");
	String language="english";
	
	String route="p";
	
	
	String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sendId+"&message="+sid+"&language="+language+"&route="+route+"&numbers="+msisdn;
	
	//sending get request using java..
	
	URL url=new URL(myUrl);
	
	HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
	
	
	con.setRequestMethod("GET");
	
	//con.setRequestProperty("User-Agent", "Mozilla/5.0");
	//con.setRequestProperty("cache-control", "no-cache");
	System.out.println("Wait..............");
	
	int code=con.getResponseCode();
	
	System.out.println("Response code : "+code);
	
	StringBuffer response=new StringBuffer();
	
	BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
	
	while(true)
	{
		String line=br.readLine();
		if(line==null)
		{
			break;
		}
		retval+=response.append(line);
	}
	  System.out.println(retval);
      rsp = retval;
	System.out.println(response);
	
	
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return rsp;
	
}	public static void main(String[] args) {
	// TODO Auto-generated method stub

	//api-key= u6o49gULTGPhWrtNjV8lyIqxBJZQianz3sfRAdeX51EkwF7HYvStcpQswEaTArl5H8zKko0jbDV3B2Oe 
	
System.out.println("Program started.....");
	
String response = SMSSender("prakash", "sms@123", "7972778111", "message", "WebSMS", "0");
System.out.println(response);

}

}
