package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureLogger;
import com.example.jetbrainstest.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

//url = https://www.jetbrains.com/all/
public class AllProductsPage {
    WebDriver driver;
    Actions action = new Actions(BaseTest.getDriver());
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(AllProductsPage.class));
    @FindBy(css = "a[data-test='button' ][href ='/idea/buy/']")
    private WebElement downloadButton;
    @FindBy(css = "#js-menu-second-desktop > a")
    private WebElement buyButton;
    @FindBy(css = "a[href='/']")
    private WebElement logo;
    @FindBy(css = "span[class='menu-second-title-box__title wt-h3']")
    private WebElement secondTitleName;
    @FindBy(xpath = "//a[contains(text(),'I Want It All')]")
    private WebElement wantAllButton;
    @FindBy(css = "a[href='https://www.jetbrains.com/webstorm']")
    private WebElement webStormButton;
    @FindBy(css = "div[class='wt-col-3 wt-col-lg-4 wt-col-sm-12 products-logos__item products-logos__item_shade']")//
    private WebElement darkIdeaImage;
    @FindBy(css = "a[aria-label='Code with me page']")
    private WebElement codeWithMeButton;
    @FindBy(css = "p[class='wt-text-2 wt-text-2_theme_light']>svg[viewBox='0 0 16 16']>path")
    private WebElement iconI;
    @FindBy(css = "div[class='wt-tooltip__content']")
    private WebElement toolTip;
    @FindBy(css = "a[href='https://www.jetbrains.com/dotcover']")
    private WebElement dotCoverButton;
    @FindBy(css = "a[class='wt-link wt-link_theme_dark']")
    private WebElement learnMoreButton;
    @FindBy(css = "div[class='wt-container']>h2[class='wt-h2']")
    private WebElement blockFAQ;
    @FindBy(xpath = "//*[contains(text(),'Stay updated')]")
    private WebElement blockStayUpdated;
    @FindBy(css = "input[placeholder='Email']")
    private WebElement inputEmail;
    @FindBy(css = "div[class='wt-input__error-message wt-text-3']")
    private WebElement validationError;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;
    @FindBy(css = "p[class='rs-text-2 rs-text-2_hardness_hard rs-text-2_theme_light wt-offset-top-24']")
    private WebElement thanksText;
    @FindBy(css = "h3[class='rs-h3 rs-h3_theme_light wt-offset-top-sm-48']")
    private WebElement blockFollowUs;
    @FindBy(css = "a[class='rs-link rs-link_mode_clear rs-link_theme_dark']")
    private WebElement urlIdea;
    @FindBy(css = ".jb-footer-catalog>li:nth-child(1)")
    private WebElement blockProducts;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean checkIfDownloadButtonIsClickable() {
        LOG.infoWithScreenshot("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public Boolean checkIfBuyButtonEnabled() {
        LOG.infoWithScreenshot("Проверка наличия кнопки Buy");
        return buyButton.isEnabled();
    }

    public void buyButtonClick() {
        LOG.infoWithScreenshot("Нажатие на кнопку Buy");
        buyButton.click();
    }

    public void switchToStoreTab(int num) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(num - 1));
        LOG.infoWithScreenshot("Перешли на вкладку №" + (num));
    }

    public void logoButtonClick() {
        logo.click();
        LOG.info("Нажали на логотип");
    }

    public String getSecondTitleText() {
        LOG.infoWithScreenshot("Нашли second title");
        return secondTitleName.getText();
    }

    public boolean checkIfWantButtonEnabled() {
        LOG.infoWithScreenshot("Нашли кнопку \"I want it all\"");
        return wantAllButton.isEnabled();
    }

    public void wantAllButtonClick() {
        LOG.infoWithScreenshot("Нашли кнопку \"I want it all\"");
        wantAllButton.click();
        LOG.info("Нажали на кнопку \"I want it all\"");
    }

    public void moveToWebStormButton() {
        scrollTo(webStormButton, 0, 500);
        action.moveToElement(webStormButton);
        action.perform();
        LOG.infoWithScreenshot("Перевели курсор на WebStorm");
    }

    private void scrollTo(WebElement scrollElement, int x, int y) {
        WheelInput.ScrollOrigin scroll = WheelInput.ScrollOrigin.fromElement(scrollElement);
        new Actions(driver).scrollFromOrigin(scroll, x, y).perform();
        LOG.infoWithScreenshot("Скролл до " + scrollElement.getText());
    }

    public boolean checkIfIdeaImageDark() {
        LOG.infoWithScreenshot("Ищем потемневшую кнопку Idea");
        return darkIdeaImage.isEnabled();
    }

    public void webStormButtonClick() {
        webStormButton.click();
        LOG.info("Нажали на кнопку WebStorm");
    }

    public void codeWithMeButtonClick() {
        codeWithMeButton.click();
        LOG.info("Нажали на кнопку Code With Me");
    }

    public void moveToIconI() {
        scrollTo(iconI, 0, 400);
        action.moveToElement(iconI);
        action.perform();
        LOG.info("Перевели курсор на \"i\"");
    }

    public boolean toolTipCheck() {
        return toolTip.isEnabled();
    }

    public void dotCoverButtonClick() {
        scrollTo(dotCoverButton, 0, 500);
        dotCoverButton.click();
        LOG.info("Нажали на кнопку dotCover");
    }

    public void moveToDotCoverButton() {
        scrollTo(dotCoverButton, 0, 500);
        action.moveToElement(dotCoverButton);
        action.perform();
        LOG.infoWithScreenshot("Перевели курсор на dotCover");
    }

    public boolean checkIfDotCoverIconDark() {
        LOG.infoWithScreenshot("Ищем потемневшую кнопку dotMemory");
        return dotCoverButton.isEnabled();
    }

    public void learnMoreButtonClick() {
        scrollTo(learnMoreButton, 0, 500);
        learnMoreButton.click();
        LOG.info("Нажали на кнопку Learn more");
    }

    public boolean blockFAQEnabled() {
        scrollTo(blockFAQ, 0, 300);
        return blockFAQ.isEnabled();
    }

    public boolean blockStayUpdatedEnabled() {
        scrollTo(blockStayUpdated, 0, 300);
        return blockStayUpdated.isEnabled();
    }

    public void inputEmailText(String inputText) {
        scrollTo(inputEmail, 0, 300);
        inputEmail.sendKeys(inputText);
        LOG.info("Ввели текст: \"" + inputText + "\"");
    }

    public void submitButtonClick() {
        submitButton.click();
        LOG.info("Нажали \"Submit\"");
    }

    public boolean checkIfValidationErrorEnabled() {
        return validationError.isEnabled();
    }

    public boolean checkIfThanksTextEnabled() {
        return thanksText.isEnabled();
    }

    public boolean blockFollowUsEnabled() {
        scrollTo(blockFollowUs, 0, 300);
        return blockFollowUs.isEnabled();
    }

    public boolean checkIfUrlIdeaIsEnabled() {
        scrollTo(urlIdea, 0, 100);
        return urlIdea.isEnabled();
    }

    public boolean checkIfBlockProductsIsEnabled() {
        scrollTo(blockProducts, 0, 100);
        return blockProducts.isEnabled();
    }
}
