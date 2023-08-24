package api.endpoints;

public class Routes {
    public static String base_url = "https://petstore.swagger.io/v2";

    // User API Module
    public static String post_url = base_url+"/user";
    public static String get_url = base_url+"/user/{username}";
    public static String update_url = base_url+"/user/{username}";
    public static String delete_url = base_url+"/user/{username}";
    public static String create_with_list = base_url+"/user/createWithList";
    public static String create_with_array = base_url+"/user/createWithArray";
    public static String user_login = base_url+"/user/login";
    public static String user_logout = base_url+"/user/logout";

    // Pet API Module
    public static String find_pet_by_status = base_url+"/pet/findByStatus";
    public static String find_pet_by_id = base_url+"/pet/{petId}";
    public static String upload_pet_image = base_url+"/pet/{petId}/uploadImage";
    public static String add_new_pet = base_url+"/pet";
    public static String update_petDetails_form_Data = base_url+"/pet/{petId}";
    public static String delete_pet = base_url+"/pet/{petId}";
    public static String update_existing_pet = base_url+"/pet";

    // Store API Module
    public static String find_order = base_url+"/store/order/{orderId}";
    public static String inventory_by_status = base_url+"/store/inventory";
    public static String place_order = base_url+"/store/order";
    public static String delete_order = base_url+"/store/order/{orderId}";

}
