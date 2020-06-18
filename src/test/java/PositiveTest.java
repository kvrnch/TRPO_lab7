import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
public class PositiveTest {
    @DataProvider(name = "newUserData")
    public Object[] newUserData() {
        User[] res = new User[1];
        res[0] = new User(
                "Kristina",
                "Verenich",
                "k.verenitch@mail.ru",
                "101010",
                7,
                "December",
                1999,
                "Pr. Universitetsky 100",
                "Volgograd",
                21,
                "Texas",
                40002,
                "89377750022"
        );
        return res;
    }
    //@Severity(value = SeverityLevel.CRITICAL)
    //@DisplayName("Регистрация")
    //@Description("Тестирование позитивного сценария регистрации пользователя")
    @Test(dataProvider = "newUserData")
    public void mainTest(User user) {
        WebElement signInLink, input, nameLabel;
        System.setProperty("webdriver.chrome.driver",
                "C:/users/kvere/AppData/Local/Google/Chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Открываем сайт
        driver.get("http://automationpractice.com/");
        // Переходим на страницу регистрации
        signInLink = (new WebDriverWait(driver,
                10)).until(presenceOfElementLocated(By.className("login")));
        signInLink.click();
        // Вводим email
        (new WebDriverWait(driver,
                10)).until(presenceOfElementLocated(By.id("email_create"))).sendKeys(user.email);
        // Жмём "create an account"
        (new WebDriverWait(driver, 10)).until(presenceOfElementLocated(By.id("createaccount_form"))).submit();
        // Personal data
        // Имя
        input = (new WebDriverWait(driver,
                10)).until(presenceOfElementLocated(By.id("customer_firstname")));
        input.sendKeys(user.firstName);
        // Фамилия
        input = driver.findElement(By.id("customer_lastname"));
        input.sendKeys(user.lastName);
        // Пароль
        input = driver.findElement(By.id("passwd"));
        input.sendKeys(user.password);
        // День рождения
        input = driver.findElement(By.id("days"));
        input.sendKeys(Integer.toString(user.dayOfBirth));
        // Месяц рождения
        input = driver.findElement(By.id("months"));
        input.sendKeys(user.monthOfBirth);
        // Год рождения
        input = driver.findElement(By.id("years"));
        input.sendKeys(Integer.toString(user.yearOfBirth));
        // Address
        // Имя
        input = driver.findElement(By.id("firstname"));
        input.sendKeys(user.firstName);
        // Фамилия
        input = driver.findElement(By.id("lastname"));
        input.sendKeys(user.lastName);
        // Адрес
        input = driver.findElement(By.id("address1"));
        input.sendKeys(user.address);
        // Город
        input = driver.findElement(By.id("city"));
        input.sendKeys(user.city);
        // Страна
        input = driver.findElement(By.id("id_country"));
        input.sendKeys(Integer.toString(user.country));
        // Штат
        input = (new WebDriverWait(driver,
                10)).until(presenceOfElementLocated(By.id("id_state")));
        input.sendKeys(user.state);
        // Почтовый индекс
        input = driver.findElement(By.id("postcode"));
        input.sendKeys(Integer.toString(user.postalCode));
        // Номер телефона
        input = driver.findElement(By.id("phone_mobile"));
        input.sendKeys(user.phoneNumber);
        // Регистрируемся
        driver.findElement(By.id("submitAccount")).click();
        // Дожидаемся, пока страница загрузится, и смотрим на содержимое ссылки в аккаунт.
        //Оно должно быть равно firstname + " " + lastname
        nameLabel = (new WebDriverWait(driver,
                10)).until(presenceOfElementLocated(By.cssSelector("a.account > span")));
        assertThat(nameLabel.getText(), equalTo(user.firstName + " " + user.lastName));
        driver.quit();
    }
}