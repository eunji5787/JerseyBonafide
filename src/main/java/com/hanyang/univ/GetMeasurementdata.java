package com.hanyang.univ;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("/rest")
public class GetMeasurementdata {
	private String responseString;
	private String centralserverurl = "https://bonafide.pw/rest/";
	
	@POST
	@Path("/getdata")
	public Response getMsg(
			@FormParam("usertoken") String usertoken,
			@FormParam("stname") String stname,
			@FormParam("stnum") String stnum,
			@FormParam("Provider") String provider,
			@FormParam("dataplan") String dataplan,
			@FormParam("Network") String network
			) throws Exception {
		
		Client client = new Client();
		WebResource webResource = client.resource(centralserverurl).path("measurement-results").path("list").path(usertoken);
		webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
		ClientResponse response = webResource.get(ClientResponse.class);
		System.out.println("network : " +network);
		
		if (response.getStatus() == 200) {
			String postdata = response.getEntity(String.class);
			JSONObject jsonObj = new JSONObject(postdata);
			JSONArray measurementresult = jsonObj.getJSONArray("measurement_results");
			
				if (measurementresult.length()!=0) {
			
			
					StoreMeasurementdata storedata = new StoreMeasurementdata();
					//storedata.localstore(name, measurementresult);
					storedata.jsonstore(stname, stnum, usertoken, provider, dataplan, network, jsonObj);
				
					MysqlConnector conn = new MysqlConnector();
				
					responseString = conn.Insertdata(stnum, stname, usertoken, provider, dataplan, network);
				}
				else {	
					responseString = "Check Your UserToken Again";
				}
			}

		else {
			responseString = "Central Server does not response....Please try again";
		}
		
		return Response.status(200).entity(responseString).build();
		}
	

}