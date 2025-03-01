import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.Description;


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
    @Description("Проверка блока онлайн пополнения")
    public void testOnlineReplenishment() {
        assertTrue(homePage.isOnlineReplenishmentTitleDisplayed(), "Название блока не отображается.");
    }

    @Test
    @Description("Проверка плейсхолдера телефона")
    public void testPlesholderPhone() {
        homePage.acceptCookies();
        assertTrue(homePage.placeholderPhoneDisplayed(),"Ошибка плейсхолдера услуги связи");
    }

    @Test
    @Description("Проверка плейсхолдера интернета")
    public void testPlesholderInternet() {
        homePage.acceptCookies();
        homePage.clickSelectHeader();
        homePage.clickSelectInternet();
        assertTrue(homePage.placeholderInternetDisplayed(), "Ошибка интернета");
    }

    @Test
    @Description("Проверка плейсхолдера рассрочки")
    public void testPlesholderInstallments() {
        homePage.acceptCookies();
        homePage.clickSelectHeader();
        homePage.clickSelectInstallments();
        assertTrue(homePage.placeholderInstallmentsDisplayed(), "Ошибка рассрочки");
    }

    @Test
    @Description("Проверка плейсхолдера задолженности")
    public void testPlesholderDebt() {
        homePage.acceptCookies();
        homePage.clickSelectHeader();
        homePage.clickSelectDebt();
        assertTrue(homePage.placeholderDebt(), "Ошибка задолженности");
    }

    @Test
    @Description("Проверка логотипов платёжных систем")
    public void testPaymentSystemLogos() {
        assertEquals(7, homePage.getPaymentLogosCount(), "Логотипы платёжных систем не найдены");
    }

    @Test
    @Description("Проверка ссылки 'Подробнее о сервисе'")
    public void testLink() {
        homePage.acceptCookies();
        assertTrue(homePage.isMoreAboutServiceLinkDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается.");
        String currentUrl = driver.getCurrentUrl();
        homePage.clickMoreAboutServiceLink();
        String newUrl = driver.getCurrentUrl();
        assertNotEquals(currentUrl, newUrl, "Переход по ссылке не выполнен.");
    }

    @Test
    @Description("Проверка формы пополнения")
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

