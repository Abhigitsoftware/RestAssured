package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
@Test
public void updateproject()
{
	//step1: Create the necessary data- Request Body
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Abhi");
	jobj.put("projectName", "Google_java.util.Random@3e27aa33");
	jobj.put("status", "completed");
	jobj.put("teamsize", 15);
	
	//step2: send request
	RequestSpecification req = RestAssured.given();
	req.body(jobj);
	req.contentType(ContentType.JSON);
	
	Response resp = req.put("http://localhost:8084/projects/TY_PROJ_1205");
	//step3:validate response
	resp.then().log().all();
	resp.then().assertThat().statusCode(200);
	
	
}
}
