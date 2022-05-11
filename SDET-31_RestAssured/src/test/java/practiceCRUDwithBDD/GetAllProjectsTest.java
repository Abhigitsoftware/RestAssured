package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjectsTest {
	@Test
	public void getallprojects()
	{
		baseURI="http://localhost";
		port=8084;
		//step1: create data
		//step2: send request
		
		when()
			.get("/projects")
			
		.then()
			.assertThat().statusCode(200)
			.log().all();
		//step3: validate
		
	}
	
	

}
