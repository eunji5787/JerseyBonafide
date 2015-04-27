package com.hanyang.univ;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StoreMeasurementdata {
	private String dirname = "BonafideMeasurement_result";
	private File fileStorage;
	JSONObject jsonfilewrite = new JSONObject();
	
	public void localstore(String name, JSONArray measurementdata) throws IOException{

		File dir = new File(dirname);
		if (!dir.exists()) {
			
			dir.mkdir();
			System.out.println("Making directory : "+dir.getAbsolutePath());
			
		}
		
		fileStorage = dir;
			
		try {
			
			File file = new File(fileStorage, name);
			FileWriter writer = new FileWriter(file);
			for(int i=0;i < measurementdata.length();i++) {     
				JSONObject e = measurementdata.getJSONObject(i);
			    writer.write(e.toString(4));
			    writer.flush();
				}
			writer.close();
			System.out.println("The directory path : "+dir.getAbsolutePath());
			
			}
		
		catch (JSONException e) {
				
		        System.out.println("JSONException : "+e);
			}
		
		catch (IOException ioex) {
			
			System.out.println("IOException : "+ioex);
			
			}
	}
		
		public void jsonstore(String stname,
				String stnum, String usertoken,
				String provider,String dataplan,String network,
				JSONObject jsonObj) throws IOException{


			File dir = new File(dirname);
			if (!dir.exists()) {
				
				dir.mkdir();
				System.out.println("Making directory : "+dir.getAbsolutePath());
				
			}
			
			fileStorage = dir;
				
			try {
				
				String name = stname +"_"+stnum+"_"+usertoken+".json";
				
				jsonObj.put("Student Name", stname);
				jsonObj.put("Student Number", stnum);
				jsonObj.put("Provider", provider);
				jsonObj.put("Dataplan", dataplan);
				jsonObj.put("Network", network);
				
				File file = new File(fileStorage, name);
				FileWriter writer = new FileWriter(file);
				writer.write(jsonObj.toString(4));
				writer.flush();
				writer.close();
				System.out.println("The directory path : "+dir.getAbsolutePath());
				
				}
			
			catch (JSONException e) {
					
			        System.out.println("JSONException : "+e);
				}
			
			catch (IOException ioex) {
				
				System.out.println("IOException : "+ioex);
				
				}
	}
}
