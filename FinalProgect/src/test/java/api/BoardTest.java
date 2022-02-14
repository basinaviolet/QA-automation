package api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.ConfProperties;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.rootPath;

public class BoardTest {

    private static String getBoardNamesRequest = "boards?fields=name,url";

    @Test
    public void checkUserInfo(){
         String userInfo = given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + ApiVelue.TOKEN)
                .header("Content-type", "application/json")
                 .contentType(ContentType.JSON)
                 .get()
                 .asString();

        System.out.println("userInfo:" + userInfo);
    }

    @Test
    public void checkBoardList() {
        List<String> boardNameList = getBoardNameList();

        boardNameList.forEach(i -> System.out.println(i.toString()));
        int startBoardsCount = boardNameList.size();
        Assert.assertTrue(startBoardsCount > 0);

//        List<BoardData> boardList = given()
//                .when()
//                .contentType(ContentType.JSON)
//                .get(URL + request + token)
//                .then().statusCode(200)
//                .extract().jsonPath().getList(".", BoardData.class);

        boardNameList = getBoardNameList();
        boardNameList.forEach(i -> System.out.println(i.toString()));
        int endBoardsCount = boardNameList.size();
        Assert.assertEquals(1, endBoardsCount - startBoardsCount);



        Assert.assertEquals(8, boardNameList.size());
    }

    public List<String> getBoardNameList() {
           return given()
                    .when()
                    .contentType(ContentType.JSON)
                    .get(ApiVelue.URL + getBoardNamesRequest + ApiVelue.TOKEN)
                    .then().statusCode(200)
                    .extract().jsonPath().getList("name");
    }

    public List<String> addNewBoard() {
        return given()
                .when()
                .contentType(ContentType.JSON)
                .get(ApiVelue.URL + getBoardNamesRequest + ApiVelue.TOKEN)
                .then().statusCode(200)
                .extract().jsonPath().getList("name");
    }
}
