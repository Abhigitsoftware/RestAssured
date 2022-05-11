package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class RequestChainingCreateAndUpdateReq {
@Test
public void createDataAndUpdate()
{
	//step1: create project using POST()
	
	baseURI="http://localhost";
	port=8084;
	
	Random r=new Random();
	int ran = r.nextInt(500);
	
	ProjectLibrary pLib=new ProjectLibrary("Alpha", "Ensign_"+ran, "ongoing", 12);
	System.out.println("initial random num="+ran);
	int x=ran;
	
	Response resp = given()
		.body(pLib)
		.contentType(ContentType.JSON)
	.when()
		.post("/addProject");
	
	//step2: capture the response using json Path()
	//step3: Store the data in variable
	String projectIDCaptured = resp.jsonPath().get("projectId");
	System.out.println("Posted project id= "+projectIDCaptured);
	
	/* update the data */
	//step4: create another request and use the captured variables
	ProjectLibrary pLib1=new ProjectLibrary("Beta", "Ensign_"+x, "completed", 12);
	System.out.println("final random num"+x);

	given()
		.body(pLib1)
		.contentType(ContentType.JSON)
		.pathParam("pid", projectIDCaptured)
		
	.when()
		.put("/projects/{pid}")
		
	//step5: validate
	.then().assertThat().statusCode(200).log().all();
	
}
}
