package Com.Wipro.APIFrameWork;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import PojoClass.Api;
import PojoClass.GetCourseDetails;
import PojoClass.WebAutomation;

public class Authorization {

	public static void main(String[] args) {
		String[] actualStrings= {"Selenium Webdriver Java","Cypress","Protractor"};
		RestAssured.baseURI="https://rahulshettyacademy.com";
		RestAssured.useRelaxedHTTPSValidation();
		
		String js=given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials").formParam("scope", "trust").post("/oauthapi/oauth2/resourceOwner/token")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath j= new JsonPath(js);
		String token= j.getString("access_token");
		System.out.println(token);
		ArrayList<String> a= new ArrayList<String>();
		GetCourseDetails gc=given().queryParam("access_token",token)
		.when().get("/oauthapi/getCourseDetails").as(GetCourseDetails.class);
		System.out.println(gc.getCourses().getApi().get(0).getCourseTitle());
		List<WebAutomation> webAutomationCourses=gc.getCourses().getWebAutomation();
		for(int i=0;i<webAutomationCourses.size();i++) {
			a.add(webAutomationCourses.get(i).getCourseTitle());	 
		
		}
		
		List<Api> apiCourses=gc.getCourses().getApi();
		for(int i=0;i<apiCourses.size();i++) {
			if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("soapUI WebServices Testing")) {
				System.out.println(apiCourses.get(i).getPrice()); 
				
			}
		}
		List<String> b=Arrays.asList(actualStrings);
		System.out.println(a.equals(b));

	}

}
