package Com.Wipro.APIFrameWork;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateBugAndAttachment {

	public static void main(String[] args) {
	
		RestAssured.baseURI="https://venkateshangara666.atlassian.net/";
		RestAssured.useRelaxedHTTPSValidation();
		String js=given().log().all().header("Content-Type", "application/json").header("Authorization","Basic dmVua2F0ZXNoYW5nYXJhNjY2QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjA5VjBDUThtSU9TcXVjdW83OGU2V2RWSkQ0aU8tUUpFbUJDRjlKMElqcVVnc1NHOTJuUkxUdHU4NUNhZVVfYVhvMkhSZnZ3VmZMY0w0YWwyV2hIa3hPNTdtM01vdU05TXFXYVI3dHFOOExOQTA2TFZUcmhYelFlcEdkX2YwODA0OFNfdUQwWjh0cHZjUkJGU29QdlNVdnpqRlFZazk2YnM5bnotbFBfajA2bHM9MUFCQzRENTE=")
		.body("{\n"
				+ "    \"fields\": {\n"
				+ "       \"project\":\n"
				+ "       {\n"
				+ "          \"key\": \"SCRUM\"\n"
				+ "       },\n"
				+ "       \"summary\": \"Dropdown is not working.\",\n"
				+ "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\n"
				+ "       \"issuetype\": {\n"
				+ "          \"name\": \"Bug\"\n"
				+ "       }\n"
				+ "   }\n"
				+ "}").when().post("rest/api/3/issue").then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js1=new JsonPath(js);
		String id=js1.getString("id");
		
		given().log().all().header("Authorization","Basic dmVua2F0ZXNoYW5nYXJhNjY2QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjA5VjBDUThtSU9TcXVjdW83OGU2V2RWSkQ0aU8tUUpFbUJDRjlKMElqcVVnc1NHOTJuUkxUdHU4NUNhZVVfYVhvMkhSZnZ3VmZMY0w0YWwyV2hIa3hPNTdtM01vdU05TXFXYVI3dHFOOExOQTA2TFZUcmhYelFlcEdkX2YwODA0OFNfdUQwWjh0cHZjUkJGU29QdlNVdnpqRlFZazk2YnM5bnotbFBfajA2bHM9MUFCQzRENTE=")
		.header("X-Atlassian-Token", "no-check").multiPart("file",new File(" /Users/VE20465573/eclipse/Pratice/APIFrameWork/JsonFile.json")).pathParam("key", id)
		.when().post("rest/api/3/issue/{key}/attachment").then().log().all().assertThat().statusCode(200).extract().response().asString();
		

	}

}
