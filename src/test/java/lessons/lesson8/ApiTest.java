package lessons.lesson8;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    public static final String BASE_URL = "https://reqres.in/";
//    @Test
    public void getTest(){
//        Response response = RestAssured.get(BASE_URL + "api/users?page=2");

//        int statusCode = response.statusCode();

//        Assert.assertEquals(statusCode, 200);

        given()
                .get(BASE_URL + "api/users?page=2")
                .then()
                .statusCode(200).log().body()
                .body("data.id[2]", equalTo(9));

        Response response = given()
                .accept(ContentType.JSON)
                .get(BASE_URL + "api/users?page=2")
                .then()
                .statusCode(200)
                .body("total", equalTo(12)).extract().response();

        Assert.assertEquals(response.jsonPath().getInt("data.id[1]"), 8);
        Assert.assertEquals(response.jsonPath().getString("data.email[1]"), "lindsay.ferguson@reqres.in");
    }

//    @Test
    public void postTest(){

        Map<String, String> user = new HashMap<>();

        user.put("name", "Marian");
        user.put("job", "aqa");

        given()
                .accept(ContentType.JSON)
                .body(user)
                .when()
                .post(BASE_URL + "api/users")
                .then()
                .statusCode(201).log().body();
    }
//    @Test
    public void putTest(){
        Map<String, String> user = new HashMap<>();

        user.put("name", "Marian");
        user.put("job", "aqa");

        given()
                .accept(ContentType.JSON)
                .body(user)
                .when()
                .put(BASE_URL + "api/users/377")
                .then()
                .statusCode(200).log().body();
    }

    @Test
    public void deleteTest(){
        given()
                .delete(BASE_URL + "api/users/377")
                .then()
                .statusCode(204).log().all();
    }
}
