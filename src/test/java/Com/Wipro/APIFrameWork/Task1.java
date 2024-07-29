package Com.Wipro.APIFrameWork;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.LoadFile;
import Files.ReusableCode;



public class Task1 {

	public static void main(String[] args) {
		
	RestAssured.baseURI="https://rahulshettyacademy.com";
	RestAssured.useRelaxedHTTPSValidation();
	String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body(LoadFile.AddPlace()).when().post("maps/api/place/add/json")
	//.body("scope", equalTo("APP")) for body validation you can use 
	.then().log().all().assertThat().statusCode(200).header("Access-Control-Max-Age", "3600")
	.extract().response().asString();
	System.out.println(response);
	JsonPath js= ReusableCode.JsonMethod(response);
	String place=js.getString("place_id");
	System.out.println(place);
	
	String addnew="Summer Walk Africa";
	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("")
	.when().put("maps/api/update/json")
	.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address Successfully updated "));
	
	String js1=given().log().all().queryParam("key","qaclick123").queryParam("place_id", place)
	.when().get("maps/api/get/json")
	.then().log().all().assertThat().statusCode(200).body("address", equalTo(addnew)).extract().response().asString();
	JsonPath as=ReusableCode.JsonMethod(js1);;
	String place1=as.getString("address");
	System.out.println(place1);
	}

}
