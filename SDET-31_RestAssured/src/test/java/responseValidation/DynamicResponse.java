package responseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponse {
@Test
public void dynamicResponse()
{
	String expData="TY_PROJ_1205";
	
	baseURI="http://localhost";
	port=8084;
	
	//step2: send request
	Response resp = when().get("/projects");
	
	//step3:capture all the project ids
	boolean flag=false;
	List<String>list = resp.jsonPath().get("projectId");
	for(String actData:list)
	{
		if(actData.equalsIgnoreCase(expData))
		{
			flag=true;
			break;
		}
	}
	if(flag)
	{
		System.out.println("data verified");
	}
	else {
		System.out.println("data not verified");
	}
	
}
}
