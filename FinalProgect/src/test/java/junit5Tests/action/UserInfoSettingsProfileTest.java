package junit5Tests.action;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import junit5Tests.BaseTest;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.userProfile.ProfilePage;

@ExtendWith(ScreenShooterExtension.class)
public class UserInfoSettingsProfileTest extends BaseTest {

    private MainPage mainPage = new MainPage();

    @Test
    public void changeUserInfoProfile() {
        ProfilePage profilePage = mainPage.changeUserProfile();
        Assertions.assertEquals("Interested in becoming an automator", profilePage.setUserDescription("Interested in becoming an automator"));
        profilePage.returnToMain();
    }
}

