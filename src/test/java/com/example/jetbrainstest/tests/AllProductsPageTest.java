package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.AllureAttachmentsManager;
import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.AllProductsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class AllProductsPageTest extends BaseTest {
    private AllProductsPage AllProductsPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/all/");
        AllProductsPage = new AllProductsPage(getDriver());
    }

    @Test
    @DisplayName("Наличие кнопки Buy")
    public void buyButtonCheck() {
        assertTrue(AllProductsPage.checkIfBuyButtonEnabled(), "Кнопка Buy не доступна");
        AllureAttachmentsManager.screenshot();
    }

    @Test
    @DisplayName("Открытие страницы покупки при нажатии на Buy")
    public void urlBuyButtonCheck() {
        AllProductsPage.buyButtonClick();
        AllProductsPage.switchToStoreTab(1);
        assertEquals("https://www.jetbrains.com/store/#commercial", getDriver().getCurrentUrl(), "Открылась неверная ссылка");
        AllureAttachmentsManager.screenshot();
    }

    @Test
    @DisplayName("Открывается главная страница при клике на логотип")
    public void logoPageTest() {
        AllProductsPage.logoButtonClick();
        assertEquals("https://www.jetbrains.com/", getDriver().getCurrentUrl(), "Открылась неверная ссылка");
    }

    @Test
    @DisplayName("Проверка second_title = All Products Pack")
    public void secondTitleNameCheck() {
        assertEquals("All Products Pack", AllProductsPage.getSecondTitleText(), "Не корректный second title");
    }

    @Test
    @DisplayName("Наличие кнопки \"I want it all\" ")
    public void wantButtonCheck() {
        assertTrue(AllProductsPage.checkIfWantButtonEnabled(), "Кнопка \"I want it all\" не доступна");
    }

    @Test
    @DisplayName("Открывается страница покупки при клике на \"I want it all\"")
    public void urlWantAllButtonCheck() {
        AllProductsPage.wantAllButtonClick();
        AllProductsPage.switchToStoreTab(1);
        assertEquals("https://www.jetbrains.com/store/#commercial", getDriver().getCurrentUrl(), "Открылась неверная ссылка");
    }

    @Test
    @DisplayName("Темнеет иконка Idea при наведении на WebStorm")
    public void ideaIconGetDarkColorCheck() {
        AllProductsPage.moveToWebStormButton();
        assertTrue(AllProductsPage.checkIfIdeaImageDark(), "Иконка Idea не потемнела");
        AllureAttachmentsManager.screenshot();
    }

    @Test
    @DisplayName("Проверка редиректа кнопки \"WebStorm\"")
    public void webStormButtonUrlTest() {
        AllProductsPage.webStormButtonClick();
        AllProductsPage.switchToStoreTab(2);
        assertEquals("https://www.jetbrains.com/webstorm/", getDriver().getCurrentUrl(), "Открылась неверная ссылка");
    }

    @Test
    @DisplayName("Проверка редиректа кнопки \"Code With Me\"")
    public void codeWithMeUrlTest() {
        AllProductsPage.codeWithMeButtonClick();
        assertEquals("https://www.jetbrains.com/code-with-me/", getDriver().getCurrentUrl(), "Открылась неверная ссылка");
    }

    @Test
    @DisplayName("При наведении на \"I\" появляется всплывашка")
    public void popUpVisibleTest() {
        AllProductsPage.moveToIconI();
        assertTrue(AllProductsPage.toolTipCheck(), "нет");
        AllureAttachmentsManager.screenshot();
    }

    @Test
    @DisplayName("Проверка редиректа кнопки \"dotCover\"")
    public void dotCoverButtonUrlTest() {
        AllProductsPage.dotCoverButtonClick();
        AllProductsPage.switchToStoreTab(2);
        assertEquals("https://www.jetbrains.com/dotcover/", getDriver().getCurrentUrl(), "Открылась неверная ссылка");
    }

    @Test
    @DisplayName("Темнеет иконка dotMemory при наведении на dotCover")
    public void ideaDotMemoryGetDarkColorCheck() {
        AllProductsPage.moveToDotCoverButton();
        assertTrue(AllProductsPage.checkIfDotCoverIconDark(), "Иконка Idea не потемнела");
        AllureAttachmentsManager.screenshot();
    }

    @Test
    @DisplayName("Проверка редиректа кнопки \"Learn more\"")
    public void learnMoreButtonUrlTest() {
        AllProductsPage.learnMoreButtonClick();
        assertEquals("https://www.jetbrains.com/toolbox-app/", getDriver().getCurrentUrl(), "Открылась неверная ссылка");
    }

    @Test
    @DisplayName("Проверка наличия блока \"FAQ\"")
    public void blockFAQCheck() {
        assertTrue(AllProductsPage.blockFAQEnabled(), "Блок \"FAQ\" не появился");
        AllureAttachmentsManager.screenshot();
    }

    @Test
    @DisplayName("Проверка наличия блока \"Stay Updated\"")
    public void blockStayUpdatedCheck() {
        assertTrue(AllProductsPage.blockStayUpdatedEnabled(), "Блок \"Stay Updated\" не появился");
        AllureAttachmentsManager.screenshot();
    }

    @Test
    @DisplayName("Проверка появления \"Validation Error\" при вводе некорректного значения в поле \"Email\"")
    public void validationErrorInInputEmailTest() {
        AllProductsPage.inputEmailText("test");
        AllProductsPage.submitButtonClick();
        assertTrue(AllProductsPage.checkIfValidationErrorEnabled(), "\"Validation Error\" не появился");
        AllureAttachmentsManager.screenshot();
    }

    @Test
    @DisplayName("Проверка ввода валидного email")
    public void validEmailInInputTest() {
        AllProductsPage.inputEmailText("test@mail.ru");
        AllProductsPage.submitButtonClick();
        assertTrue(AllProductsPage.checkIfThanksTextEnabled(), "Текст \"Thanks for your request!\" не появился");
    }

    @Test
    @DisplayName("Проверка наличия раздела м\"Follow us\"")
    public void blockFollowUsCheck() {
        assertTrue(AllProductsPage.blockFollowUsEnabled(), "Раздел \"Follow us\" отсутствует");
    }

    @Test
    @DisplayName("В footer есть ссылка \"IntelliJ IDEA\"")
    public void footerIdeaUrlCheck() {
        assertTrue(AllProductsPage.checkIfUrlIdeaIsEnabled(), "Ссылка на Idea отсутствует");
    }

    @Test
    @DisplayName("В footer есть раздел \"Products\"")
    public void blockProductsEnabled() {
        assertTrue(AllProductsPage.checkIfBlockProductsIsEnabled(), "Раздел \"Products\" отсутствует");
    }
}
