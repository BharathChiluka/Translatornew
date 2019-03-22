package Oyoprod;

import java.io.*;
import java.net.*;

import org.springframework.stereotype.Service;

@Service
public class Translation {
	
	
	  private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
	  private static final String CLIENT_SECRET = "PUBLIC_SECRET";
	  private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";


	public String translate(String fromLang, String toLang, String text) throws Exception {
	    // TODO: Should have used a 3rd party library to make a JSON string from an object
	    String jsonPayload = new StringBuilder()
	      .append("{")
	      .append("\"fromLang\":\"")
	      .append(fromLang)
	      .append("\",")
	      .append("\"toLang\":\"")
	      .append(toLang)
	      .append("\",")
	      .append("\"text\":\"")
	      .append(text)
	      .append("\"")
	      .append("}")
	      .toString();

	    URL url = new URL(ENDPOINT);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setDoOutput(true);
	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
	    conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
	    conn.setRequestProperty("Content-Type", "application/json");

	    OutputStream os = conn.getOutputStream();
	    os.write(jsonPayload.getBytes());
	    os.flush();
	    os.close();

	    int statusCode = conn.getResponseCode();
	    System.out.println("Status Code: " + statusCode);
	    BufferedReader br = new BufferedReader(new InputStreamReader(
	        (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()
	      ));
	    String output;
	    while ((output = br.readLine()) != null) {
	    	
	        System.out.println(text+"----->"+output);
	        System.out.println(jsonPayload);
	        return output;
	    }
	    
		return output;
	  }
	public static String translatee(String fromLang,String toLang)
	{
		System.out.println(fromLang+"--"+toLang);
		return toLang;
	}
}
