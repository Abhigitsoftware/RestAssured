package ResponseTimeValidation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponseTimeValidationUsingHamcrest {
	@Test
	public void ResponseTimeValidation() 
{
		baseURI="http://localhost";
		port=8084;
		
		//step2: send request
		Response resp=when()
				.get("/projects");
		
		//validate response time
		resp.then().assertThat().time(Matchers.lessThan(1000L), TimeUnit.MILLISECONDS);
		resp.then().log().all();
		
}

}
