package controller;


import java.io.BufferedReader;
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.RecordService;
import model.RecordVO;


@WebServlet("/calculate")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("insert".equals(action)) {
			
			Double rate = null;//匯率
			String currency =req.getParameter("currency");//幣別
			Double price=0.0;
			if(req.getParameter("price").trim()!=""){
			 price = new Double(req.getParameter("price"));
			}else{
			 price=0.0;
					 };//價錢
			Double discount = null;
			Double result = null;		
			//
		    final String URL = "https://tw.rter.info/capi.php";
			URL url1 = new URL(URL);
			HttpURLConnection con = (HttpURLConnection) url1.openConnection();
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
			
//			System.out.println(sb.toString());
	        
			br.close();
			isr.close();
			is.close();
			
			con.disconnect();
			
			Gson gson =new Gson();
			
			Map map=gson.fromJson(sb.toString(), Map.class);
			Double USDTWD=(Double)((Map)map.get("USDTWD")).get("Exrate");
			Double USDJPY=(Double)((Map)map.get("USDJPY")).get("Exrate");
			//
			if ("JPY".equals(currency)) {
				rate=USDTWD/USDJPY;	
				discount=0.0;
				Double result1= price*rate;
				result = Math.round(result1*100.0)/100.0;
			}
			else if("USD".equals(currency)) {
				rate=USDTWD;
				discount=0.0;
				Double result1= price*rate;
				result = Math.round(result1*100.0)/100.0;
			}else if("TWD".equals(currency)){
				rate=1.0;
				if(req.getParameter("discount").trim()!=null) {
					 discount=new Double(req.getParameter("discount").trim());
					}else {
						discount=0.0;
					}
				Double result1= price*rate-discount;
				result = Math.round(result1*100.0)/100.0;
			}
			
			 
			 
			
			RecordVO recordVO =new RecordVO();
			recordVO.setCurrency(currency);
			recordVO.setPrice(price);
			recordVO.setDiscount(discount);
			recordVO.setResult(result);
			
			RecordService svc = new RecordService();
			recordVO =svc.addRecord(rate, currency, price, discount, result);
			
			req.setAttribute("recordVO", recordVO);
			String url = "/calculate.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
			
		
		}
	}
	
	
}
