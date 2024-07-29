package Com.Wipro.APIFrameWork;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import Maps.Fields;
import Maps.Location;
public class Task4AddPlace {

	public static void main(String[] args) {
		List<String> l=new ArrayList<String>();
		l.add("shoe park");
		l.add("shop");
		Fields f= new Fields();
		Location loc=new Location();
		loc.setLat(-3.54545);
		loc.setLon(3.676767);
		f.setAccuracy(50);
		f.setAddress("8-5-29/30,Ramachandrapuram");
		f.setLanguage("English/Telugu");
		f.setName("Angara Venkatesh");
		f.setPhonenumber("919542322769");
		f.setWebsite("https://www.venkateshangara.com");
		f.setTypes(l);
		f.setLocation(loc);
		 
		
		RequestSpecification req=new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri("https://rahulshettyacademy.com").log(LogDetail.ALL).addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		ResponseSpecification res1=new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		RequestSpecification r=given().spec(req).body(f);
	    Response reponse=r.when().post("/maps/api/place/add/json").then().spec(res1).extract().response();
		String str=reponse.asString();
		System.out.println(str);
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		//RestAssured.useRelaxedHTTPSValidation();
//		Response res1=given().log().all().queryParam("key", "qaclick123").body(f).when()
//		.post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract()
//		.response();
//		String r1=res1.asString();
//		System.out.println(r1);

	}

}
