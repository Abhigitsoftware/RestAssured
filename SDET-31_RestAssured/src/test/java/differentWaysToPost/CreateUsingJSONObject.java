package differentWaysToPost;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUsingJSONObject {
@Test
public void postusingJSONobject() {
	//step1: create data
	
	Random ran = new Random();
	int random = ran.nextInt(100);
	
	baseURI="http://localhost";
	port=8084;
	
			JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "Abhishek");
			jobj.put("projectName", "Amazon121_"+random);
			jobj.put("status", "ongoing");
			jobj.put("teamsize", 5);
			
			//step2:send request
			given()
				.body(jobj)
				.contentType(ContentType.JSON)
			.when()
			 	.post("/addProject")
			 .then()
			 	.assertThat().statusCode(201)
			 	.log().all();
				
}
}
