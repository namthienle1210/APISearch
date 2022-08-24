
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class API extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 
	 public API() {
	        super();
	 }
	 
	 protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null; 
		String query = request.getParameter("keyword"); 

		String[] qArray = query.split(" ");
		String qStr = "";
		for (int j = 0; j < qArray.length - 1; j++){
			qStr = qStr.concat(qArray[j]);
			qStr = qStr.concat("+");
		}
		qStr = qStr.concat(qArray[qArray.length - 1]);
			
		String str1 = "https://www.data.go.kr/en/data/15102459/fileData.do#/API%20%EB%AA%A9%EB%A1%9D/getuddi%3Ae135c06b-b9f1-4fc5-95da-f000da38638b";
		String str2 = "\";"; 
			
		String url = str1.concat(qStr);
		String urlString = url.concat(str2);
		String r = httpGet(urlString); 
		
		String str3 = "http://apis.data.go.kr/B552584/EvCharger/getChargerStatus";
		url = "";
		urlString = "";
		url = str3.concat(qStr);
		urlString = url.concat(str3);
		String r2 = httpGet(urlString); 
		
		JSONObject obj1 = null, obj2 = null;
		JSONArray result = new JSONArray();
		String resultStr = "";
		try {
			obj1 = new JSONObject(r);
			JSONArray array1 = obj1.getJSONArray("본부");
			
			obj2 = new JSONObject(r2);
			JSONArray array2 = obj2.getJSONArray("본부");
			
			for (int i = 0; i < array1.length(); i++) {
		        result.put(array1.get(i));
		    }
		    for (int i = 0; i < array2.length(); i++) {
		        result.put(array2.get(i));
		    }
		    
		    obj1.put("본부", result);
		    resultStr = obj1.toString();
		    
		} catch (JSONException e1) {
						e1.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("searchResults", resultStr);
		
		request.setAttribute("todo", resultStr);
		
		rd = request.getRequestDispatcher("/SearchResults.jsp");
		rd.forward(request, response);
	 }
	 
	 public String httpGet(String urlStr) throws IOException {
		 
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			if (conn.getResponseCode() != 200) {
			    throw new IOException(conn.getResponseMessage());
			}

						BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			return sb.toString();
		}

}
