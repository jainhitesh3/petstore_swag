package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.HelperUtility;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests extends BaseTest {

    User userPayload;

    @BeforeClass
    public void setupData(){
        // generate data and pass it to pojo
        userPayload = HelperUtility.createData();

    }

    @Test(priority = 1, description = "Post User")
    public void test01PostUser(){
        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2, description = "Get User")
    public void test02GetUser(){
        Response response = UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 3, description = "Update User")
    public void test03UpdateUser(){
        Response createResponse = UserEndPoints.createUser(userPayload);
        createResponse.then().log().all();
        Assert.assertEquals(createResponse.getStatusCode(), 200);

        userPayload.setEmail("update@mail.com");
        userPayload.setFirstName("FirstName");
        userPayload.setLastName("LastName");

        Response updateResponse = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
        updateResponse.then().log().all();
        Assert.assertEquals(updateResponse.getStatusCode(), 200);
    }

    @Test(priority = 4, description = "Delete User")
    public void test04DeleteUser(){
        Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 5, description = "Create User with List of Users")
    public void test05CreateUsersWithGivenList(){
        Response response = UserEndPoints.createUserWithList(HelperUtility.createUsersList(4));
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 6, description = "Create User with Array of Users")
    public void test06CreateUsersWithGivenUserArray(){
        Response response = UserEndPoints.createUserWithArray(HelperUtility.createUsersArray(4));
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 7, description = "Login New User")
    public void test07UserLogin(){
        Faker faker = new Faker();

        Response response = UserEndPoints.userLogin(faker.name().username(), faker.internet().password(5, 10));
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 8, description = "Logout User")
    public void test07UserLogout(){
        Response response = UserEndPoints.userLogout();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
