import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage extends MainPage {

    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение')]")
    private WebElement onlineReplenishmentTitle;

    @FindBy(xpath = "//img[contains(@alt, 'Visa') or contains(@alt, 'MasterCard') or contains(@alt, 'Белкарт') or contains(@alt, 'Verified By Visa') or contains(@alt, 'MasterCard Secure Code')]")
    private List<WebElement> paymentLogos;

    @FindBy(xpath = "//img[contains(@src, 'assets/images/payment-icons/card-types/visa-system.svg')]")
    private WebElement visaIcon;

    @FindBy(xpath = "//img[contains(@src, 'assets/images/payment-icons/card-types/mastercard-system.svg')]")
    private WebElement masterCardIcon;

    @FindBy(xpath = "//img[contains(@src, 'assets/images/payment-icons/card-types/belkart-system.svg')]")
    private WebElement belcardIcon;

    @FindBy(xpath = "//img[contains(@src, 'assets/images/payment-icons/card-types/maestro-system.svg')]")
    private WebElement maestroIcon;

    @FindBy(xpath = "//img[contains(@src, 'assets/images/payment-icons/card-types/mir-system-ru.svg')]")
    private WebElement mirIcon;

    @FindBy(xpath = "//button[contains(text(), 'Принять')]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//a[contains(text(), 'Подробнее о сервисе')]")
    private WebElement moreAboutServiceLink;

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amountField;

    @FindBy(xpath = "//input[@placeholder='E-mail для отправки чека']")
    private WebElement emailToSend;

    @FindBy(xpath = "//input[@placeholder='Номер счета на 44']")
    private WebElement accountNumberInstallment;

    @FindBy(xpath = "//input[@placeholder='Номер счета на 2073']")
    private WebElement accountNumberDebt;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='select']//button")
    private WebElement buttonInsideSelectDiv;

    @FindBy(xpath = "//p[@class='select__option' and text()='Домашний интернет']")
    private WebElement buttonHomeInternet;

    @FindBy(xpath = "//input[@placeholder='Номер абонента']")
    private WebElement phoneNumberSub;

    @FindBy(xpath = "//p[@class='select__option' and text()='Рассрочка']")
    private WebElement buttonInstallments;

    @FindBy(xpath = "//p[@class='select__option' and text()='Задолженность']")
    private WebElement buttonDebt;

    @FindBy(css = "iframe.bepaid-iframe")
    private WebElement bepaidIframe;

    @FindBy(css = "div.gpay-card-info-placeholder-container")
    private WebElement gpayCardInfo;

    @FindBy(xpath = "//span[contains(text(), '10.00 BYN')]")
    private WebElement amountSpan;

    @FindBy(xpath = "//button[contains(text(), ' Оплатить  10.00 BYN ')]")
    private WebElement payButton;

    @FindBy(xpath = "//span[contains(text(),'Номер:375297777777')]")
    private WebElement paymentInfoSpan;

    @FindBy(xpath = "//label[contains(text(),'Номер карты')]")
    private WebElement cardNumber;

    @FindBy(xpath = "//label[contains(text(),'Срок действия')]")
    private WebElement validityPeriod;

    @FindBy(xpath = "//label[contains(text(),'CVC')]")
    private WebElement cvc;

    @FindBy(xpath = "//label[contains(text(),'Имя держателя (как на карте)')]")
    private WebElement nameHolder;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        driver.get("https://mts.by");
    }

    public boolean isOnlineReplenishmentTitleDisplayed() {
        return isElementDisplayed(onlineReplenishmentTitle);
    }

    public boolean placeholderDisplayed() {
        return  isElementDisplayed(amountField) && isElementDisplayed(emailToSend);
    }

    public boolean placeholderPhoneDisplayed(){
        return placeholderDisplayed() && isElementDisplayed(phoneNumberField);
    }

    public boolean placeholderInternetDisplayed(){
        return placeholderDisplayed() && isElementDisplayed(phoneNumberSub);
    }

    public boolean placeholderInstallmentsDisplayed(){
        return placeholderDisplayed() && isElementDisplayed(accountNumberInstallment);
    }

    public boolean placeholderDebt(){
        return placeholderDisplayed() && isElementDisplayed(accountNumberDebt);
    }

    public int getPaymentLogosCount() {
        return paymentLogos.size();
    }

    public void acceptCookies() {
        try {
            if (isElementDisplayed(acceptCookiesButton)) {
                click(acceptCookiesButton);
            }
        } catch (Exception e) {
        }
    }

    public boolean isMoreAboutServiceLinkDisplayed() {
        return isElementDisplayed(moreAboutServiceLink);
    }

    public void clickMoreAboutServiceLink() {
        click(moreAboutServiceLink);
    }

    public void clickSelectHeader(){
        click(buttonInsideSelectDiv);
    }

    public void clickSelectInternet(){
        click(buttonHomeInternet);
    }

    public void clickSelectInstallments(){
        click(buttonInstallments);
    }

    public void clickSelectDebt(){
        click(buttonDebt);
    }

    public void fillReplenishmentForm(String phoneNumber, String amount) {
        sendKeys(phoneNumberField, phoneNumber);
        sendKeys(amountField, amount);
        click(continueButton);
    }

    public boolean isGpayCardInfoDisplayed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(bepaidIframe));
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(gpayCardInfo));
            return gpayCardInfo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean iframeHolder() {
        return  isElementDisplayed(amountSpan) && isElementDisplayed(payButton) &&
        isElementDisplayed(paymentInfoSpan) && isElementDisplayed(cardNumber) &&
        isElementDisplayed(validityPeriod) && isElementDisplayed(cvc) &&
        isElementDisplayed(nameHolder);
    }
    public boolean iframeLogos() {
        return  isElementDisplayed(visaIcon) && isElementDisplayed(masterCardIcon) &&
                isElementDisplayed(belcardIcon) && isElementDisplayed(maestroIcon) &&
                isElementDisplayed(mirIcon);
    }
}

