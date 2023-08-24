package api.test;

import api.endpoints.StoreEndPoints;
import api.payload.PlaceOrder;
import api.utilities.HelperUtility;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreTests extends BaseTest{
    PlaceOrder payload;

    @BeforeClass
    public void setupData(){
        // generate data and pass it to pojo
    }

    @Test(description = "Place an order")
    public void test001PlaceOrder(){
        payload = HelperUtility.createOrderData();
        Response response = StoreEndPoints.placeOrder(payload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(description = "Find purchase order by order id")
    public void test002FindOrder(){
        Response response = StoreEndPoints.findOrder(4);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Find inventory status")
    public void test003InventorySearch(){
        Response response = StoreEndPoints.inventoryStatus();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Delete Order")
    public void test004DeleteOrder(){
        Response response = StoreEndPoints.deleteOrder(25);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
