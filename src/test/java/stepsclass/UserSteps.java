package stepsclass;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserSteps {

    public final static String BASE_URL = "https://stellarburgers.nomoreparties.site/api/auth";

    @Step("Создать пользователя через API")
    public static void createUser(String email, String password, String name) {
        given()
                .contentType("application/json")
                .body("{\"email\":\"" + email + "\", \"password\":\"" + password + "\", \"name\":\"" + name + "\"}")
                .when()
                .post(BASE_URL + "/register")
                .then()
                .statusCode(200);
    }

    @Step("Авторизация пользователя по логину/паролю")
    public static String loginUser(String email, String password) {
        return given()
                .contentType("application/json")
                .body("{\"email\":\"" + email + "\", \"password\":\"" + password + "\"}")
                .when()
                .post(BASE_URL + "/login")
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }

    @Step("Удалить пользователя через API")
    public static Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", "" + accessToken)
                .when()
                .delete(BASE_URL + "/user")
                .then()
                .extract()
                .response();
    }
}