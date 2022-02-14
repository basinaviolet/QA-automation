package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ConfProperties;

public class ApiVelue {
    public static String URL = "https://api.trello.com/1/members/me/";
    public static String TOKEN = "&key=" + ConfProperties.getProperty("apikey")
            + "&token=" + ConfProperties.getProperty("token");
}
