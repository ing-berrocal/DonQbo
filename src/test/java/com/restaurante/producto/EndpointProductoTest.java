/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import io.quarkus.test.Mock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import io.restassured.config.RestAssuredConfig;
import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

/**
 *
 * @author DELL
 */
@QuarkusTest
@TestHTTPEndpoint(ProductoResource.class)
@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class EndpointProductoTest {

    @Test
    public void getListProductoEndpoint() {
        var config = RestAssuredConfig.config().getJsonConfig();
        //String h = 
          given()      
          .when().contentType("application/json;charset=UTF-8")                         
                .body("query characters { characters { name }}")
                .get()     
          .then()
             .statusCode(200)
                .body("[0].id", equalTo(1));
                //.extract().body().asPrettyString();
        //System.out.println(h);
    }
    
    @Test
    public void addProductoEndpoint() {
        var config = RestAssuredConfig.config().getJsonConfig();
        //String h = 
          given()      
          .when().contentType("application/json;charset=UTF-8")                         
                .body("query characters { characters { name }}")
                .post()
          .then()
             .statusCode(200)
                .body("[0].id", equalTo(1));
                //.extract().body().asPrettyString();
        //System.out.println(h);
    }
    
    @Mock
    @ApplicationScoped
    //@Priority(1)
    public static class MockPersistence implements ProductoRepositorio{

        @Override
        public Producto agregarProducto(Producto any) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public List<Producto> getAllProducts() {
            return List.of(Producto.newInstance(1L, "100", 
                    "","","","", BigDecimal.ZERO));
        }
        
    }
}
