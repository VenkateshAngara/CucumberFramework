package Com.Wipro.APIFrameWork;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.LoadFile;
import Files.ReusableCode;

public class FakeAPITesting {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.useRelaxedHTTPSValidation();
		String js=given().log().all().header("Content-Type", "application/json").body(LoadFile.CreateAccount())
		.when().post("api/users")
		.then().log().all().assertThat().body("name", equalTo("Angara Venkatesh")).statusCode(201).extract().response().asString();
		JsonPath jsi=ReusableCode.JsonMethod(js);
		System.out.println(jsi.getString("place_id"));
		
		String s=given().log().all().header("Content-Type", "application/json").body(LoadFile.updateData())
		.when().put("api/users/2")
		.then().log().all().assertThat().statusCode(200).body("job",equalTo("QA Tester")).extract().response().asString();
		JsonPath jd=ReusableCode.JsonMethod(s);
		String date=jd.getString("updatedAt");
		System.out.println(date);
		
		
	}

}
