package differentWaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

import pojoClass.ProjectLibrary;

public class CreateProjectUsingPOJOClass {
@Test
public void createProject() 
{
	baseURI="http://localhost";
	port=8084;
	
	Random ran = new Random();
	int Random = ran.nextInt(50);
	//step1: create data
	ProjectLibrary pLib = new ProjectLibrary("KiranS", "Alexa_"+Random, "Started", 4);
	
	//step2:send data
	given()
		.body(pLib)
		.contentType(ContentType.JSON)
	.when()
		.post("/addProject")
	.then()
		.and().log().all();
	
	
}
}
