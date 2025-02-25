import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsByTests {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, java.util.concurrent.TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        homePage.navigateToHomePage();
    }

    @Test
    public void testOnlineReplenishment() {
        assertTrue(homePage.isOnlineReplenishmentTitleDisplayed(), "Название блока не отображается.");
    }

    @Test
    public void testPlesholderPhone() {
        homePage.acceptCookies();
        assertTrue(homePage.placeholderPhoneDisplayed(),"Ошибка плейсхолдера услуги связи");
    }

    @Test
    public void testPlesholderInternet() {
        homePage.acceptCookies();
        homePage.clickSelectHeader();
        homePage.clickSelectInternet();
        assertTrue(homePage.placeholderInternetDisplayed(), "Ошибка интернета");
    }

    @Test
    public void testPlesholderInstallments() {
        homePage.acceptCookies();
        homePage.clickSelectHeader();
        homePage.clickSelectInstallments();
        assertTrue(homePage.placeholderInstallmentsDisplayed(), "Ошибка рассрочки");
    }

    @Test
    public void testPlesholderDebt() {
        homePage.acceptCookies();
        homePage.clickSelectHeader();
        homePage.clickSelectDebt();
        assertTrue(homePage.placeholderDebt(), "Ошибка задолженности");
    }

    @Test
    public void testPaymentSystemLogos() {
        assertEquals(7, homePage.getPaymentLogosCount(), "Логотипы платёжных систем не найдены");
    }

    @Test
    public void testLink() {
        homePage.acceptCookies();
        assertTrue(homePage.isMoreAboutServiceLinkDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается.");
        String currentUrl = driver.getCurrentUrl();
        homePage.clickMoreAboutServiceLink();
        String newUrl = driver.getCurrentUrl();
        assertNotEquals(currentUrl, newUrl, "Переход по ссылке не выполнен.");
    }

    @Test
    public void testReplenishmentForm() {
        homePage.acceptCookies();
        homePage.fillReplenishmentForm("297777777", "10");
        assertTrue(homePage.isGpayCardInfoDisplayed(), "Элемент не отображается.");
        assertTrue(homePage.iframeHolder(),"Номер телефона, сумма и плейсхолдеры не отобразились");
        assertTrue(homePage.iframeLogos(), "Иконки платёжных систем не отобразились");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

