package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameterTest {
@Test
public void queryParameterTest()
{
	baseURI="https://reqres.in";
	
	//step1: pre requisites
	given()
		.queryParam("page", 4)
		
	//step2: send request
		.when()
			.get("/api/users")
			
	//step3: validate the response
		.then().log().all();
			
}
}
