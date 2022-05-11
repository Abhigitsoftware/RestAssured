package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest {
	@Test
	public void getAllProjects()
	{
		//step1: create necessary data
		
		//step2: send request
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//step3: validate response
		resp.then().log().all();
		
		
	}

}
