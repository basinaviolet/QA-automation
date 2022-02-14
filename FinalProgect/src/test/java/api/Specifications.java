package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ConfProperties;

public class Specifications {
    private static String URL = "https://api.trello.com/1/members/me/";
    private static String TOKEN = "&key=" + ConfProperties.getProperty("apikey")
            + "&token=" + ConfProperties.getProperty("token");

    public static RequestSpecification requestSpec(String request){
        return new RequestSpecBuilder()
                .setBaseUri(URL + request + TOKEN)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecOk200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static void initialSpec(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
