import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MtsByTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://mts.by");
    }

    @Test
    public void testOnlineReplenishment() {
        WebElement Title = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));
        assertTrue(Title.isDisplayed(), "Название блока не отображается.");
    }

    @Test
    public void testPaymentSystemLogos() {
        List<WebElement> paymentLogos = driver.findElements(By.xpath(
                "//img[contains(@alt, 'Visa') or contains(@alt, 'MasterCard') or " +
                        "contains(@alt, 'Белкарт') or contains(@alt, 'Verified By Visa') or " +
                        "contains(@alt, 'MasterCard Secure Code')]"));
        assertTrue(paymentLogos.size() == 7, "Логотипы платёжных систем не найдены");
    }

    @Test
    public void testLink() {
        try {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
            }
        } catch (Exception e) {
        }
        WebElement link = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));
        assertTrue(link.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается.");
        String currentUrl = driver.getCurrentUrl();
        link.click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        String newUrl = driver.getCurrentUrl();
        assertNotEquals(currentUrl, newUrl, "Переход по ссылке не выполнен.");
    }

    @Test
    public void testReplenishmentForm() {
        try {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
            }
        } catch (Exception e) {
        }
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        phoneNumberField.sendKeys("297777777");
        WebElement amountField = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        amountField.sendKeys("10");
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.bepaid-iframe")));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.gpay-card-info-placeholder-container")));
        assertTrue(visibleElement.isDisplayed(), "Элемент не отображается.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}