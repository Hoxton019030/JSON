package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class readTxt {
	public static void main(String[] args) {
		FileReader file;
		try {
			String filecontent;
			file = new FileReader("C:\\Json\\2022-04-13.txt");
			BufferedReader br = new BufferedReader(file);
			StringBuffer sr = new StringBuffer();

			while ((filecontent = br.readLine()) != null) {
				sr.append(filecontent);
			}
//			System.out.println(sr.toString());
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = sr.toString();
//			JSONArray jArray = new JSONArray(data);
			JsonNode node = mapper.readTree(jsonString);
			String data=node.get("data").toString();
			
			JSONArray jArray = new JSONArray(data);
			for (int i = 0; i < jArray.length(); i++) {
				String name = node.get("data").get(i).get("name").asText();
				String symbol = node.get("data").get(i).get("symbol").asText();
				String USD = node.get("data").get(i).get("quote").get("USD").get("price").asText();
				System.out.println(i + "." + "NAME:"+name+"  SYSBOL:"+symbol+"  USD:"+USD);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
