package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAprojectTest {
	@Test
	public void getAProject() {
		
		 baseURI = "http://localhost";
		 port=8084;
		//step1: create data
		//step2: send request
		 
		 when()
		 	.get("/projects/TY_PROJ_1602")
		 	
		 .then()
		 	.assertThat().statusCode(200)
		 	.log().all();
		
	}
}
