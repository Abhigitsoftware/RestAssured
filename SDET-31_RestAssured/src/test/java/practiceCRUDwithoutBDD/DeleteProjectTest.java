package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {
	@Test
	public void deleteaProject()
	{
		//step1: create data
		
		//step2: send request
		Response resp =RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1204");
		
		//step3: validate response
		resp.then().log().all();
		resp.then().assertThat().statusCode(204);
		
	}

}
