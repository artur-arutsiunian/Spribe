import dto.get.listOfUsers.Players;
import dto.get.specificUser.UserById;
import dto.patch.UserUpdate;
import dto.post.UserCreation;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestService {

    private final static String BASE_URL = "http://3.68.165.45/";
    private final static String GET_LIST_OF_USER = "player/get/all";
    private final static String GET_USER = "player/get";
    private final static String CREATE_USER = "player/create/supervisor";
    private final static String EDIT_USER = "player/update/supervisor/1";
    private final static String DELETE_ASSET = "player/delete/supervisor";

    static {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public Players getUsers(){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + GET_LIST_OF_USER)
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .as(Players.class);
    }

    public UserById getUserById(int playerId){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .body(initUserIdBody(playerId))
                .post(BASE_URL + GET_USER)
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .as(UserById.class);
    }

    public UserCreation createUser(){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .queryParam("age", "22")
                .queryParam("gender", "female")
                .queryParam("login", "test126")
                .queryParam("password", "12345678")
                .queryParam("role", "user")
                .queryParam("screenName", "newFemale126")
                .get(BASE_URL + CREATE_USER)
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .as(UserCreation.class);
    }

    public int createUserWithWrongAge(){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .queryParam("age", "60")
                .queryParam("gender", "female")
                .queryParam("login", "test4500")
                .queryParam("password", "12345678")
                .queryParam("role", "user")
                .queryParam("screenName", "newFemale4500")
                .get(BASE_URL + CREATE_USER)
                .then()
                .assertThat()
                .statusCode(400)
                .extract()
                .statusCode();
    }

    public UserUpdate editUser(String gender){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .body(initEditUserBody(gender))
                .patch(BASE_URL + EDIT_USER)
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .as(UserUpdate.class);
    }

    public int deleteUser(int playerId){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .body(initDeleteUser(playerId))
                .delete(BASE_URL + DELETE_ASSET)
                .then()
                .assertThat()
                .statusCode(204)
                .extract()
                .statusCode();
    }

    private Map<String, Object> initUserIdBody(int playerId) {
        Map<String, Object> body = new HashMap<>();

        body.put("playerId", playerId);
        return body;
    }

    private Map<String, Object> initEditUserBody(String gender) {
        Map<String, Object> body = new HashMap<>();

        body.put("gender", gender);
        return body;
    }

    private Map<String, Object> initDeleteUser(int playerId) {
        Map<String, Object> body = new HashMap<>();

        body.put("playerId", playerId);
        return body;
    }

}
