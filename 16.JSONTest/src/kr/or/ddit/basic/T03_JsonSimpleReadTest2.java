package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * OPEN API 의 json 데이터를 가져오는 예제
 * @author macween
 *
 */
public class T03_JsonSimpleReadTest2 {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		String reqKey = "Grid_20150827000000000227_1"; 
		// http://211.237.50.150:7080/openapi/sample/json/Grid_20150827000000000227_1/1/5"
		URL url = new URL("http://211.237.50.150:7080/openapi/sample/json/"+ reqKey + "/1/5");
		URLConnection urlConnection = url.openConnection();
		
		new InputStreamReader(urlConnection.getInputStream());
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new InputStreamReader(urlConnection.getInputStream()));
		JSONObject jsonfile = (JSONObject)obj;
		
		JSONObject rootObj = (JSONObject) jsonfile.get(reqKey);
		JSONObject result = (JSONObject)rootObj.get("result");
		String code = (String)result.get("code");
		
		if(code.equals("INFO-000")) { // 정상 상태일 때

			JSONArray list = (JSONArray)rootObj.get("row");
			
//			for(Object tempObj : list) {
//				
//				JSONObject tempJson = (JSONObject) tempObj;
//				
//				System.out.println("순번 : " + tempJson.get("IRDNT_SN"));
//				System.out.println("재료명 : " + tempJson.get("IRDNT_NM"));
//				System.out.println("용량 : " + tempJson.get("IRDNT_CPCTY"));
//				System.out.println("재료구분 : " + tempJson.get("IRDNT_TY_NM"));
//				
//				System.out.println("-------------------------");
//			}
			
			
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> it = list.iterator();
			
			while(it.hasNext()){
				
				JSONObject tempJson = it.next();
				
				System.out.println("순번 : " + tempJson.get("IRDNT_SN"));
				System.out.println("재료명 : " + tempJson.get("IRDNT_NM"));
				System.out.println("용량 : " + tempJson.get("IRDNT_CPCTY"));
				System.out.println("재료구분 : " + tempJson.get("IRDNT_TY_NM"));
				
				System.out.println("-------------------------");
			}
		}
	}
}
