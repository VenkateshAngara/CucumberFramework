package Com.Wipro.APIFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.LoadFile;
import io.restassured.path.json.JsonPath;

public class SumUsingTestNG {
	@Test
	public void sum() {
		JsonPath js= new JsonPath(LoadFile.UpdatedData());
		int size=js.getInt("courses.size()");
		int amount=js.getInt("dashboard.purchaseAmount");
		int sum=0;
		for(int i=0;i<size;i++) {
		int price=js.getInt("courses["+i+"].price");
		int copies=js.getInt("courses["+i+"].copies");
		sum+=price*copies;
		
		}
		System.out.println(sum);
		Assert.assertEquals(amount, sum);
	}
}
