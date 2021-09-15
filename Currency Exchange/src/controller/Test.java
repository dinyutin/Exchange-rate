package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;
import org.json.JSONException;

public class Test {
	 
	private static final String URL = "https://tw.rter.info/capi.php";
	

	public static void main(String[] args) throws IOException {
//		Gson gson = new Gson();
		URL url = new URL(URL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		con.setRequestMethod("GET");
		
		InputStream is = con.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
    
		String data;
		String prettyJsonString=null;
		while ((data = br.readLine()) != null) {
			 prettyJsonString = gsonPretty.toJson(data);
			 System.out.println(data);
//			 System.out.println(data.indexOf("\"USDTWD\""));
			 System.out.println(prettyJsonString);

		}
		
		
		
		
		
//		String str= prettyJsonString.toString();
		
//		JSONObject j = new JSONObject(prettyJsonString);
//		Object jsonOb = j.getJSONObject("USDTWD").get("Name");
//		System.out.println(jsonOb);
		
//		JsonParser parse=new JsonParser();  //建立JSON解析器
//		        
//		JsonObject json=(JsonObject) parse.parse(str);//將String轉成json
//		
//		 System.out.println("USDFKP:"+json.get("USDFKP").getAsString());
//		Gson gson = new Gson(); 
//		String json = prettyJsonString.toString();
//		Map<String,Object> map = new HashMap<String,Object>();
//		map = (Map<String,Object>) gson.fromJson(json, map.getClass());

        
		br.close();
		isr.close();
		is.close();
		
		con.disconnect();
		

		
		
	}
}