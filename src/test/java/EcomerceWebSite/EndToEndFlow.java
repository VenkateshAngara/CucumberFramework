package EcomerceWebSite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EndToEndFlow {

	public static void main(String[] args) {
		//Login into the Application
		String path="/Users/VE20465573/eclipse/Pratice/APIFrameWork/Selenium_WebDriver_With_Java.jpg";
		LoginData d= new LoginData();
		d.setUserEmail("angara@gmail.com");
		d.setUserPassword("Angara123@");
		RequestSpecification req=new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		ResponseSpecification Res=new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		RequestSpecification req1=given().spec(req).body(d);
		LoginResponse lr=req1.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponse.class);
		String token=lr.getToken();
		String Id=lr.getUserId();
		System.out.println(lr.getMessage());
		//create Product 
		RequestSpecification req2=new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).build();
		RequestSpecification req3=given().spec(req2).param("productName", "Certificate").param("productAddedBy", Id).param("productCategory", "fashion")
		.param("productSubCategory", "shirts").param("productPrice", "11500").param("productDescription", "Addida Originals")
		.param("productFor", "women").param("productImage", path).multiPart("productImage",new File(path));
	    CreateResponse cr=req3.when().post("/api/ecom/product/add-product").then().assertThat().statusCode(201).extract().response().as(CreateResponse.class);
	    String proId=cr.getProductId();
	    System.out.println(proId);
	    System.out.println(cr.getMessage());
	    //create order to the product
	    RequestSpecification re=new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).setContentType(ContentType.JSON).build();
	    OrderDetails or= new OrderDetails();
	    or.setCountry("India");
	    or.setProductOrderedId(proId);
	    List<OrderDetails> ol=new ArrayList<OrderDetails>();
	    ol.add(or);
	    CreateOrderData cop= new CreateOrderData();
	    cop.setOrders(ol);
	    RequestSpecification reqcre=given().spec(re).body(cop);
	    String str=reqcre.when().post("/api/ecom/order/create-order").then().assertThat().statusCode(201).extract().response().asString();
	    JsonPath js =new JsonPath(str);
	    String orderDetails=js.getString("orders");
	    System.out.println(orderDetails);
	    System.out.println(js.getString("message"));
	    //Get the Detailds of the orderId
		RequestSpecification reqGetD=new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).setContentType(ContentType.JSON).build();
		RequestSpecification reqdete=given().spec(reqGetD).queryParam("id", proId);
		String str1=reqdete.when().get("/api/ecom/order/get-orders-details").then().assertThat().statusCode(200).extract().response().asString();
	    System.out.println(str1);
	    //delete the OrderId
	    RequestSpecification reqDel=new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).setContentType(ContentType.JSON).build();
		RequestSpecification reqdelete=given().spec(reqDel).pathParam("proId", proId);
		String del=reqdelete.when().delete("/api/ecom/product/delete-product/{proId}").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js1 =new JsonPath(del);
	    System.out.println(js1.getString("message"));
	    
	}

}
