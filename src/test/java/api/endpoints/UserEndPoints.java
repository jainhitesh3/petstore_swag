package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.User;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.List;

public class UserEndPoints {

    public static Response createUser(User payload){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);
        return response;
    }

    public static Response readUser(String userName){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .pathParam("username", userName)
                .when()
                .get(Routes.get_url);
        return response;
    }

    public static Response updateUser(String userName, User payload){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(Routes.update_url);
        return response;
    }

    public static Response deleteUser(String userName){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .pathParam("username", userName)
                .when()
                .delete(Routes.delete_url);
        return response;
    }

    public static Response createUserWithList(List<User> payload){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.create_with_list);
        return response;
    }

    public static Response createUserWithArray(User[] payload){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.create_with_array);
        return response;
    }

    public static Response userLogin(String userName, String password){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .accept(ContentType.JSON)
                .queryParam("username", userName)
                .queryParam("password", password)
                .when()
                .get(Routes.user_login);
        return response;
    }

    public static Response userLogout(){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .accept(ContentType.JSON)
                .when()
                .get(Routes.user_logout);
        return response;
    }
}
