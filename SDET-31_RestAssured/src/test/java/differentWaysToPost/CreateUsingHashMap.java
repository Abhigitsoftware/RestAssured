package differentWaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

public class CreateUsingHashMap {
@Test
public void postUsingHashMap() {
	
	Random ran = new Random();
	int random = ran.nextInt(100);
	
	baseURI="http://localhost";
	port=8084;
	
	//step1:create necessary data
	HashMap map = new HashMap();
	map.put("createdBy", "Abhishek");
	map.put("projectName", "Amazon121_"+random);
	map.put("status", "ongoing");
	map.put("teamsize", 5);
	
	//step2:send request
	given()
		.body(map)
		.contentType(ContentType.JSON)
	.when()
	 	.post("/addProject")
	 .then()
	 	.assertThat().statusCode(201)
	 	.log().all();
		
}
}
