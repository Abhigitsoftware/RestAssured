package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
@Test
public void pathParameterTest()
{
	baseURI="http://localhost";
	port=8084;
	
	//step1: pre requisites
	given()
		.pathParam("pid", "TY_PROJ_623")
		
	//step2: send request
	.when()
		.get("/projects/{pid}")
		
	//step3: validate response
	.then()
		.assertThat().statusCode(200).log().all();
}
}
