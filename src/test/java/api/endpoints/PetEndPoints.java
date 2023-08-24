package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.PetDetail;
import io.restassured.response.Response;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;

import java.io.File;

public class PetEndPoints {

    public static Response findPetByStatus(String status){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .accept(ContentType.JSON)
                .queryParam("status", status)
                .when()
                .get(Routes.find_pet_by_status);
        return response;
    }

    public static Response findPetById(int id){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .accept(ContentType.JSON)
                .pathParam("petId", id)
                .when()
                .get(Routes.find_pet_by_id);
        return response;
    }

    public static Response uploadPetImage(int petId){
        System.out.println(System.getProperty("user.dir"));
        Response response = given()
                .accept(ContentType.JSON)
                .contentType("multipart/form-data")
                .multiPart("additionalMetadata", "some additional data")
                .multiPart("file", new File("C:\\Users\\Hp\\Desktop\\Automation\\PetStore\\src\\test\\resources\\sample image.jpg"))
                .pathParam("petId", petId)
                .when()
                .post(Routes.upload_pet_image);
        return response;
    }

    public static Response addNewPet(PetDetail pet){
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(Routes.add_new_pet);
        return response;
    }

    public static Response updatePetDetailsWithFormData(int petId){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .accept(ContentType.JSON)
                .contentType(ContentType.URLENC)
                .pathParam("petId", petId)
                .queryParam("name", "abcd")
                .queryParam("status", "sold")
                .when()
                .post(Routes.update_petDetails_form_Data);
        return response;
    }

    public static Response deletePet(int petId){
        Response response = given()
                .filters(new RequestLoggingFilter())
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .when()
                .delete(Routes.delete_pet);
        return  response;
    }

    public static Response updateExistingPet(PetDetail pet){
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(Routes.update_existing_pet);
        return  response;
    }

}
