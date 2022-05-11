package practiceCRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectTest {
	@Test
	public void createProject()
	{
		//step1: create data
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Abhishek");
		jobj.put("projectName", "Amazon1211");
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 5);
		
		//step2: send request
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
			
		.when()
			.post("http://localhost:8084/addProject")
			
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}

}
