package Com.Wipro.APIFrameWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.LoadFile;
import Files.ReusableCode;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task3LibraryAPI {
	//@Test(dataProvider="BookData")
	public void addBook(String isbn,String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		RestAssured.useRelaxedHTTPSValidation();
		String res=given().log().all().header("Content-Type","application/json").body(LoadFile.AddBook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= ReusableCode.JsonMethod(res);
		String id=js.getString("id");
		System.out.println(id);
		
	}
	@DataProvider(name="BookData")
	public Object[][] getData() {
		return new Object[][] {{"dafsfjsh","232624"},{"avhfs","5245234"},{"agfash","322642"},{"shajhgx","e264"},{"jsfsah","46445"}};
	}
	@Test
	public void AddJsonFileTest() throws IOException {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		RestAssured.useRelaxedHTTPSValidation();
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("/Users/VE20465573/eclipse/Pratice/APIFrameWork/JsonFile.json")))).when().post("maps/api/place/add/json")
		//.body("scope", equalTo("APP")) for body validation you can use 
		.then().log().all().assertThat().statusCode(200).header("Access-Control-Max-Age", "3600")
		.extract().response().asString();
		System.out.println(response);
		
	}

}
