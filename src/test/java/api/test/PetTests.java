package api.test;

import api.endpoints.PetEndPoints;
import api.endpoints.StoreEndPoints;
import api.utilities.HelperUtility;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PetTests extends BaseTest {

    @BeforeClass
    public void setupData() {
        // generate data and pass it to pojo
    }

    @Test(priority = 0, description = "Find pet by status : 200")
    public void test01FindPetByStatus200() {
        Response response = PetEndPoints.findPetByStatus("available");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    // This test will always fail since it is giving 200 for all string values in status field
    @Test(priority = 0, description = "Find pet by status : 400")
    public void test02FindPetByStatus400() {
        Response response = PetEndPoints.findPetByStatus("Not available");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test(priority = 1, description = "Find pet by ID : 200")
    public void test03FindPetByID200() {
        Response response = PetEndPoints.findPetById(25555556);
        response.then().log().all();
        JsonPath jsonResponse = response.jsonPath();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonResponse.get("name"), "kyra");
    }

    @Test(priority = 1, description = "Find pet by ID : 404")
    public void test04FindPetByID404() {
        Response response = PetEndPoints.findPetById(0);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test(priority = 2, description = "Upload pet image")
    public void test05UploadPetImage() {
        Response response = PetEndPoints.uploadPetImage(111);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    // In-Complete
    @Test(priority = 3, description = "Add new pet to the store")
    public void test006AddNewPet() {
//        Response response = PetEndPoints.addNewPet();
    }

    @Test(priority = 4, description = "Update Pet details by form data")
    public void test007UpdatePetDetailsByFormData() {
        Response response = PetEndPoints.updatePetDetailsWithFormData(200);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 5, description = "Delete a pet by petId")
    public void test008DeletePet() {
        Response response = PetEndPoints.deletePet(112);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 6, description = "Place Order For Pupo pet with pajaro category")
    public void test01PlaceOrderForPupoPet() {
        Response response = PetEndPoints.findPetById(124);
        response.then().log().all();
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(response.getStatusCode(), 200);
        if (jsonPath.getString("name").equalsIgnoreCase("pupo")
                && jsonPath.getString("category.name").equalsIgnoreCase("pajaro")
                && jsonPath.getString("status").equalsIgnoreCase("available")) {
            Response placeOrderResponse = StoreEndPoints.placeOrder(HelperUtility.createOrderData());
            placeOrderResponse.then().log().all();
            Assert.assertEquals(placeOrderResponse.getStatusCode(), 200);
        }
        else{
            Assert.assertFalse(false);
        }
    }
}
