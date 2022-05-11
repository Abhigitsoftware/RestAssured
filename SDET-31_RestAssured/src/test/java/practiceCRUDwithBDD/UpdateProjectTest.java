package practiceCRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
	@Test
	public void updateAProject() {
		//step1: create/update a project
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Abhishek1");
		jobj.put("projectName", "Amazon121");
		jobj.put("status", "completed");
		jobj.put("teamSize", 100);
		
		//step2:send the request
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
			
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1602")
			
		.then()
			.log().all();
		
	}
}
