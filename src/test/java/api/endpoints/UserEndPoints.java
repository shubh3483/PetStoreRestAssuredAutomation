package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

public class UserEndPoints {

    static ResourceBundle getURL(){
        ResourceBundle bundle = ResourceBundle.getBundle("routes");
        return bundle;
    }
    public static Response createUser(User user){

        String post_url = getURL().getString("post_url");
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(user)
        .when()
            .post(post_url);

        return response;
    }

    public static Response readUser(String userName){

        String get_url = getURL().getString("get_url");
        Response response = given()
                .pathParam("username", userName)
        .when()
            .get(get_url);

        return response;
    }

    public static Response updateUser(String userName, User user){

        String put_url = getURL().getString("update_url");
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(user)
                .pathParam("username", userName)
        .when()
            .put(put_url);

        return response;
    }

    public static Response deleteUser(String userName){

        String delete_url = getURL().getString("delete_url");
        Response response = given()
                .pathParam("username", userName)
        .when()
            .delete(delete_url);

        return response;
    }
}
