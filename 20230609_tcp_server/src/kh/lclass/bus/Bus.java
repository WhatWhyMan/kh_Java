package kh.lclass.bus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Bus {
	 public static void main(String[] args) throws IOException {
	        StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/buspos/getBusPosByRouteSt"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=aWAbcz0ZPb4TlCJSDJLTWVk9ENcyhCElbIEdKNK/rWSvwL1zDLb48IqBScpwx9mqPyxgsSq+N6YlaEmskpuRPA==\r\n"
	        		+ ""); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*노선ID*/
	        urlBuilder.append("&" + URLEncoder.encode("startOrd","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*시작 정류소 순번*/
	        urlBuilder.append("&" + URLEncoder.encode("endOrd","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*종료 정류소 순번*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	    }
	}
