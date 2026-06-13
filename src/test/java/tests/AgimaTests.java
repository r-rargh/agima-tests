package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class AgimaTests extends BaseTest {

    @Test
    void openMainPageTest() {
        new MainPage()
                .openPage()
                .checkLogoVisible();
    }

    @Test
    void openContactsPageTest() {
        new MainPage()
                .openPage()
                .goToContactsPage()
                .pageTitleShouldBeVisible();
    }

    @Test
    void openProjectsPageTest() {
        new MainPage()
                .openPage()
                .goToProjectsPage()
                .projectsShouldBeDisplayed();
    }

    @Test
    void footerShouldBeVisibleTest() {
        new MainPage()
                .openPage()
                .checkFooterVisible();
    }
}