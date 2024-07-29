package Com.Wipro.APIFrameWork;

import org.testng.Assert;

import Files.LoadFile;
import io.restassured.path.json.JsonPath;

public class Task2ResponseData {
	public static void main(String[] args) {
		JsonPath js= new JsonPath(LoadFile.UpdatedData());
		int size=js.getInt("courses.size()");
		System.out.println(size);
		int amount=js.getInt("dashboard.purchaseAmount");
		System.out.println(amount);
		int sum=0;
		for(int i=0;i<size;i++) {
			//get method is automatically return the string value 
		String title=js.getString("courses["+i+"].title");
		if(title.equalsIgnoreCase("Rpa")) {
		System.out.println("**************************");
		System.out.println(js.get("courses["+i+"].copies").toString());
		System.out.println("**************************");
		}
		System.out.println(js.get("courses["+i+"].title").toString());
		int price=js.getInt("courses["+i+"].price");
		System.out.println(price);
		System.out.println(js.get("courses["+i+"].copies").toString());
		int copies=js.getInt("courses["+i+"].copies");
		sum+=price*copies;
		
		}
		System.out.println(sum);
		Assert.assertEquals(amount, sum);
		
	}
	

}
