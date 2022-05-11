package practiceCRUDwithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	@Test
	public void createProjectTest()
	{
		Random random = new Random();
		int ran = random.nextInt(1000);
		//step1: Create the necessary data- Request Body
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Sagar");
		jobj.put("projectName", "Google_"+ran);
		jobj.put("status", "interviews not yet given");
		jobj.put("teamsize", 10);
		
		//step2: Send the request
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		
		Response resp = req.post("http://localhost:8084/addProject");
		
		//step3: Validate the response
		
		//System.out.println(resp.asPrettyString());//use it if only response body is needed
		//System.out.println(resp.prettyPrint());
		//System.out.println(resp.asString());
		//System.out.println(resp.prettyPeek());//use it when both header & body is needed
		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getContentType());
		System.out.println(resp.getSessionId());
		System.out.println(resp.getTime());
		
		ValidatableResponse validate = resp.then();
		validate.log().all();
		validate.assertThat().statusCode(201);
		
		System.out.println("created successfully");
		
	}
	
}
