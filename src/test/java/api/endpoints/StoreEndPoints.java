package api.endpoints;

import api.payload.PlaceOrder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreEndPoints {

    public static Response placeOrder(PlaceOrder payload){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.place_order);
        return  response;
    }

    public static Response findOrder(int orderId){
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("orderId", orderId)
                .when()
                .get(Routes.find_order);
        return response;
    }

    public static Response inventoryStatus(){
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get(Routes.inventory_by_status);
        return response;
    }

    public static Response deleteOrder(int orderId){
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("orderId", orderId)
                .when()
                .delete(Routes.delete_order);
        return  response;
    }
}
