package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class Test2 {
	 
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
		
    
		StringBuilder sb = new StringBuilder();
		String data;
		while ((data = br.readLine()) != null) {
			 sb.append(data);
		}	
		
//		System.out.println(sb.toString());
        
		br.close();
		isr.close();
		is.close();
		
		con.disconnect();
		
		Gson gson =new Gson();
		
		Map map=gson.fromJson(sb.toString(), Map.class);
		Double USDTWD=(Double)((Map)map.get("USDTWD")).get("Exrate");
		Double USDJPY=(Double)((Map)map.get("USDJPY")).get("Exrate");
		System.out.println("USDTWD ="+USDTWD);
		System.out.println("USDJPY ="+USDJPY);
	}


	
	
	public static Map<String, Object> toMap(JSONObject object) throws JSONException {
	    Map<String, Object> map = new HashMap<String, Object>();

	    Iterator<String> keysItr = object.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        Object value = object.get(key);
	        
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }
	        
	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        map.put(key, value);
	    }
	    return map;
	}
	public static List<Object> toList(JSONArray array) throws JSONException {
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < array.length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        list.add(value);
	    }
	    return list;
	}
    
    
}