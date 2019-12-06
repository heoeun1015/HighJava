package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class T01_JsonSimpleWriterTest {
	public static void main(String[] args) throws IOException {
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("name", "홍길동");
		jsonObj.put("job", "학생");
		jsonObj.put("age", "30");
		jsonObj.put("addr", "대전시 중구 대흥동 대덕인재개발원");
		
		JSONArray singerList = new JSONArray();
		
		singerList.add("김영호");
		singerList.add("김명성");
		singerList.add("조윤호");
		
		jsonObj.put("singerList", singerList);
		
		FileWriter fw = new FileWriter("d:/myJsonFile.txt");
		fw.write(jsonObj.toString());
		fw.flush();
		fw.close();
		
		System.out.println("▷ JSON 객체 내용 출력: " + jsonObj);
		
	}
}
