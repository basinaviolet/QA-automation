package junit5Tests.action;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import junit5Tests.BaseTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;
import pages.userProfile.SettingsPage;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(ScreenShooterExtension.class)
public class UserInfoSettingsChangeTest extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final SettingsPage settingsPage = mainPage.changeUserSettings();

    @RepeatedTest(2)
    public void changeUserInfoNotification() {
        Assertions.assertAll("User profile",
                () -> Assertions.assertTrue(settingsPage.changeMarketingNotification()),
                () -> Assertions.assertTrue(settingsPage.changeRecommendation())
        );
    }

    @ParameterizedTest
    @CsvSource({"Никогда"})
    public void changeEmailNotificationType(String emailNotificationInput) {
        Map<String, String> emailNotificationType = new HashMap<>();
        {
            emailNotificationType.put("Никогда", "-1");
            emailNotificationType.put("Периодически", "60");
            emailNotificationType.put("Мгновенно", "1");
        }

        Assertions.assertEquals(emailNotificationType.get(emailNotificationInput),
                settingsPage.changeEmailNotificationType(emailNotificationType.get(emailNotificationInput)));
    }
}

