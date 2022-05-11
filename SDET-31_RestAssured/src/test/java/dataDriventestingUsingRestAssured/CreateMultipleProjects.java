package dataDriventestingUsingRestAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojoClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateMultipleProjects {
@Test(dataProvider="getData")
public void createMultipleProjects(String createdBy, String projectName, String status, int teamSize)
{
	baseURI="http://localhost";
	port=8084;
	
	Random r=new Random();
	int ran = r.nextInt(100);
	//step2:read data from data provider
	ProjectLibrary pLib=new ProjectLibrary(createdBy, projectName+ran, status, teamSize);

	//step3: send request
	Response resp=given()
					.body(pLib)
					.contentType(ContentType.JSON)
				  .when()
				  .post("/addProject");
	//step4: validate the response
				  String actData = resp.jsonPath().get("msg");
				 Assert.assertEquals("Checking for created data", "Successfully Added", actData);
				 resp.then().log().all();
}
@DataProvider(name="getData")	
public Object[][] getData()
{
	Object[][] data=new Object[3][4];
	
	data[0][0]="Rama";
	data[0][1]="Amazon";
	data[0][2]="created";
	data[0][3]=10;
	
	data[1][0]="lakshmana";
	data[1][1]="myntra";
	data[1][2]="on going";
	data[1][3]=15;
	
	data[2][0]="bheema";
	data[2][1]="Flipkart";
	data[2][2]="complected";
	data[2][3]=20;
	return data;

}
}

