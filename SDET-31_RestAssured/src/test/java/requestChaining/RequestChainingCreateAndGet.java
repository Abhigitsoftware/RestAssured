package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class RequestChainingCreateAndGet {
@Test
public void createDataAndGet()
{
	//step1: create project using POST()
	
	baseURI="http://localhost";
	port=8084;
	
	Random r=new Random();
	int ran = r.nextInt(500);
	
	ProjectLibrary pLib=new ProjectLibrary("Abbbbbi", "Ensign_"+ran, "ongoing", 12);
	Response resp = given()
		.body(pLib)
		.contentType(ContentType.JSON)
	.when()
		.post("/addProject");
	
	//step2: capture the response using json Path()
	//step3: Store the data in variable
	String projectIDCaptured = resp.jsonPath().get("projectId");
	System.out.println("Posted project id= "+projectIDCaptured);
	
	/* Get the data */
	//step4: create another request and use the captured variables
	given()
		.pathParam("pid", projectIDCaptured)
		
	.when()
		.get("/projects/{pid}")
		
	//step5: validate
	.then().assertThat().statusCode(200).log().all();
	
	
}
}
