package responseValidation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticResponse {
	@Test
	public void staticResponse() 
	{
		baseURI="http://localhost";
		port=8084;
		//step1: create necessary data
		
		//step2:send request-get all projects
			Response resp = when()
				.get("/projects");
			
		//step3:provide validation
			String expData="TY_PROJ_1205";
			String actData=resp.jsonPath().get("[4].projectId");
			
			Assert.assertEquals(expData, actData);
			//resp.then().log().all();
			System.out.println("data verification successful");
		
		
	}

}
