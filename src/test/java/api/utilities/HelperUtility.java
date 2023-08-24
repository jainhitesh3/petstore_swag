package api.utilities;

import api.payload.Category;
import api.payload.PetDetail;
import api.payload.PlaceOrder;
import api.payload.User;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class HelperUtility {
    public static List<User> createUsersList(int count){
        List<User> usersList = new ArrayList<User>();
        for (int i = 0; i< count; i++){
            usersList.add(createData());
        }
        return usersList;
    }

    public static User[] createUsersArray(int count){
        User userArray[] = new User[count];
        for (int i = 0; i< count; i++){
            userArray[i] = createData();
        }
        return  userArray;
    }

    public static User createData(){
        Faker faker = new Faker();
        User data = new User();
        data.setId(faker.idNumber().hashCode());
        data.setEmail(faker.internet().safeEmailAddress());
        data.setFirstName(faker.name().firstName());
        data.setLastName(faker.name().lastName());
        data.setUsername(faker.name().username());
        data.setPassword(faker.internet().password(5, 10));
        data.setPhone(faker.phoneNumber().cellPhone());
        return data;
    }

    public static PetDetail createPetData() {
        Faker faker = new Faker();
        PetDetail data = new PetDetail();
        Category category = new Category();


        category.setId(faker.idNumber().hashCode());
        category.setName(faker.name().firstName());

        data.setId(faker.idNumber().hashCode());
        data.setName(faker.name().firstName());
        data.setStatus("available");
        data.setCategory(category);
        return data;
    }

    public static PlaceOrder createOrderData(){
        Faker faker = new Faker();
        PlaceOrder data = new PlaceOrder();
        data.setId(faker.idNumber().hashCode());
        data.setPetId(faker.idNumber().hashCode());
        data.setShipDate(faker.date().birthday());
        data.setStatus("placed");
        data.setQuantity(2);
        data.setComplete(true);
        return data;
    }

}
