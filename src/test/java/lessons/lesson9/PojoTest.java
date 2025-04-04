package lessons.lesson9;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.base.pojos.createUser.CreateUserRequest;
import org.base.pojos.createUser.CreateUserResponse;
import org.base.pojos.getPets.Pet;
import org.base.pojos.getUser.UserData;
import org.base.pojos.updateUser.UpdateUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.base.helpers.Specifications.*;

public class PojoTest {
    //    @Test
    public void getUser() {
        getSpecifications(requestSpecification("api/users?page=2"), responseSpecification(200));
        List<UserData> userData = given()
                .when()
                .get()
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList("data", UserData.class);

        Assert.assertNotNull(userData);

        for (int i = 0; i < userData.size(); i++) {
            Assert.assertTrue(userData.get(i).getEmail().contains("@reqres.in"));
            Assert.assertTrue(userData.get(i).getAvatar().contains(userData.get(i).getId().toString()));
        }
    }

//    @Test
    public void createUser() {
        getSpecifications(requestSpecification("api/users"), responseSpecification(201));

        CreateUserRequest createUserRequest = new CreateUserRequest();

        createUserRequest.setName("Marian");
        createUserRequest.setJob("aqa");

        CreateUserResponse createUserResponse = given()
                .body(createUserRequest)
                .when()
                .post()
                .then()
                .extract()
                .as(CreateUserResponse.class);

        Assert.assertNotNull(createUserResponse);

        Assert.assertEquals(createUserRequest.getName(), createUserResponse.getName());
        Assert.assertEquals(createUserRequest.getJob(), createUserResponse.getJob());
    }

//    @Test
    public void updateUserTest(){
        getSpecifications(requestSpecification("api/users/2"), responseSpecification(200));

        CreateUserRequest updateUserRequest = new CreateUserRequest("Marian", "aqa");

        UpdateUserResponse updateUserResponse = given()
                .body(updateUserRequest)
                .when()
                .put()
                .then()
                .extract()
                .as(UpdateUserResponse.class);

        Assert.assertEquals(updateUserRequest.getName(), updateUserResponse.getName());
        Assert.assertEquals(updateUserRequest.getJob(), updateUserResponse.getJob());
    }

    @Test
    public void getPetsTest(){
        Pet[] pet = given()
                .accept(ContentType.JSON)
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract().as(Pet[].class);

        List<Pet> list = Arrays.asList(pet);

        for (Pet pet1 : list) {
            Assert.assertEquals(pet1.getStatus(), "available");
        }
    }
}
