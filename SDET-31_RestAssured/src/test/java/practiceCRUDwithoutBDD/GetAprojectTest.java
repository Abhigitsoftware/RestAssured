package practiceCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAprojectTest {
	@Test
	public void getAsingleProject()
	{
		int expStatus=200;
		//step1:create necessary data
		
		//step2: send request
		Response resp = RestAssured.when().get("http://localhost:8084/projects/TY_PROJ_1205");
		//step3: validate
		int actStatus = resp.getStatusCode();
		
		Assert.assertEquals(expStatus, actStatus);
		
		resp.then().log().all();
		
	}

}
