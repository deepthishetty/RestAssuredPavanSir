package NONBDDApproach;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Datadriventest_addnewemployees {
	
	@Test(dataProvider="empdatarprovider")
	public void addnewemployees(String empname,String empsal,String empage)
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("name",empname);
		jsonobject.put("salary",empsal);
		jsonobject.put("age",empage);
		
		httprequest.header("Content-Type", "application/json");
		
		httprequest.body(jsonobject.toJSONString());
		Response response = httprequest.request(Method.POST, "/create");
		
		String responsebody=response.getBody().asString();
		System.out.println("response body is"+responsebody);
		
		
		Assert.assertEquals(responsebody.contains(empname), true);
		Assert.assertEquals(responsebody.contains(empsal), true);
		Assert.assertEquals(responsebody.contains(empage), true);
	Assert.assertEquals(response.getStatusCode(), 200);

}
	
	@DataProvider(name="empdatarprovider")
	String[][] empdata() throws IOException
	{
		System.out.println(System.getProperty("user.dir"));
		
		
		String filepath=System.getProperty("user.dir")+"\\src\\test\\java\\NONBDDApproach\\empdata.xlsx";
		
		int rowcount=XLUtils.getRowCount(filepath, "Sheet1");
		int columncount=XLUtils.getcolumncount(filepath, "Sheet1", 1);
		String[][] empdata=new String[rowcount][columncount];
		for(int rownum=1;rownum<=rowcount;rownum++)
		{
			for(int columnnum=0;columnnum<columncount;columnnum++)
			{
				empdata[rownum-1][columnnum]=XLUtils.getcelldata(filepath, "Sheet1", rownum, columnnum);
			}
		}
		
		//String[][] empdata=new String[][] {{"abd","1234","43"},{"abf","1234","43"},{"dfr","1234","43"}};
		return empdata;
	}
}