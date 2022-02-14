package hooks;

//import com.codeborne.selenide.Selenide;
//import eyes.Eyes;
//import io.cucumber.core.backend.TestCaseState;
//import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.logination.StartPage;
//import io.cucumber.plugin.event.Result;
//import io.cucumber.plugin.event.Status;
//import io.qameta.allure.Allure;
//import utils.Logger;

import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;

public class Hooks {
    private static final String BASE_URL = "https://trello.com";

    @Before
    public static void openBrowser(Scenario scenario){
//        Logger.info("==============");
//        Logger.info(String.format("Start scenario '%s'", scenario.getName()));
//        Logger.info("==============");
//
//        Logger.info(String.format("Open: %s", BASE_URL));
        //      open(BASE_URL);
        StartPage startPage = open(BASE_URL, StartPage.class);
//        Eyes.getInstance().open(scenario.getName());
    }
//
//
//    @After
//    public void afterScenario(Scenario scenario) throws NoSuchFieldException, IllegalAccessException, FileNotFoundException {
//        if(scenario.isFailed()){
//            Field delegateField = scenario.getClass().getDeclaredField("delegate");
//            delegateField.setAccessible(true);
//            TestCaseState testCaseState = (TestCaseState) delegateField.get(scenario);
//
//            Field  stepResultsField = testCaseState.getClass().getDeclaredField("stepResults");
//            stepResultsField.setAccessible(true);
//            ArrayList<Result> stepResults = (ArrayList<Result>) stepResultsField.get(testCaseState);
//
//            for(Result result : stepResults){
//                if(result.getStatus().is(Status.FAILED)){
//                    Logger.error("Scenario failed: " + result.getError().getMessage());
//                }
//            }
//            final String name = String.format("Screenshot_%s_%s", scenario.getName(), LocalDateTime.now().toString());
//
//            String screenshotFilePath = Selenide.screenshot(name);
//
//            File screenshotFile = new File(screenshotFilePath);
//            InputStream fileInputStream = new DataInputStream(new FileInputStream(screenshotFile));
//
//            //Eyes.getInstance().closeAsync();
//
//            Allure.addAttachment(name, fileInputStream);
//
//        }
//    }
//
//    @After
//    public void afterEach() {
//        Eyes.getInstance().closeAsync();
//    }

}
