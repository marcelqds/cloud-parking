package com.mqds.cloudpark;

import com.mqds.cloudpark.controller.dto.ParkingCreateDTO;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerTest extends AbstractContainerBase {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        System.out.println(randomPort);
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResultEqualNull(){
        RestAssured.given()
                .when().get("/parking")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("license[0]", Matchers.equalTo(null));
                //.extract().response().body().prettyPrint();
    }

    @Test
    void whenCreateThenCheckedCreate(){
        ParkingCreateDTO createDTO = new ParkingCreateDTO();
        createDTO.setColor("Cinza");
        createDTO.setLicense("DTZ-3704");
        createDTO.setModel("Xtz250");
        createDTO.setState("SP");


        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("DTZ-3704"))
                .body("id",Matchers.notNullValue());
    }

    @Test
    void whenFindAllThenCheckOneResult(){
        RestAssured
            .when().get("/parking")
            .then()
            .statusCode(HttpStatus.OK.value())
            .body("license[0]",Matchers.equalTo("DTZ-3704"));
    }

}
