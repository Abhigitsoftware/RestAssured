package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class DynamicResponseWithPost {
	@Test
	public void dynamicResponsePost()
	{
	String expdata="Successfully Added";
	
	baseURI="http://localhost";
	port=8084;
	
	Random ran = new Random();
	int random = ran.nextInt(100);
	
	//step1:create data
	ProjectLibrary pLib = new ProjectLibrary("AbhiMS","abc_"+random,"started",5);
	
	//step2: send data
	Response resp = given()
		.body(pLib)
		.contentType(ContentType.JSON)
	.when()
		.post("/addProject");
	
	//step3: provide validation
	String actdata=resp.jsonPath().getString("msg");
	Assert.assertEquals(expdata, actdata);
	}

}
