package differentWaysToPost;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUsingJSONfile {
@Test
public void postusingJSONobject() {
	//step1: create data
	
	
	
	baseURI="http://localhost";
	port=8084;
	
			File file = new File(".\\Data.json");
			
			//step2:send request
			given()
				.body(file)
				.contentType(ContentType.JSON)
			.when()
			 	.post("/addProject")
			 .then()
			 	.assertThat().statusCode(201)
			 	.log().all();
				
}
}
