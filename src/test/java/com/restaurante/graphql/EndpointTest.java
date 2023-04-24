/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.graphql;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;

/**
 *
 * @author DELL
 */
@QuarkusTest
public class EndpointTest {
    @Test
    public void testHelloEndpoint() {
        String h = given()                
          .when().contentType("application/graphql+json; charset=UTF-8")                         
                .body("query characters { characters { name }}")
                .post("/graphql")     
          .then()
             .statusCode(200)
                .and().extract().body().asPrettyString();
        
        System.out.println(h);
    }
}
