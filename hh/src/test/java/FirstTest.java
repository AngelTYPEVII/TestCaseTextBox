import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FirstTest {
    private String baseUrl = "https://demoqa.com/text-box";
    private SelenideElement FullName = Selenide.$(By.xpath("//input[@placeholder='Full Name']"));
    private SelenideElement Email = Selenide.$(By.xpath("//input[@placeholder='name@example.com']"));
    private SelenideElement CurrentAddress = Selenide.$(By.xpath("//textarea[@placeholder='Current Address']"));
    private SelenideElement PermanentAddress = Selenide.$(By.xpath("//textarea[@id='permanentAddress']"));
    private SelenideElement Submit = Selenide.$(By.xpath("//button[@id='submit']"));

    public FirstTest() {
    }

    @BeforeAll
    static void beforeConfig() {
        Configuration.timeout = 3000L;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void before() {
        Selenide.open(this.baseUrl);
    }

    @Test
    public void test() {
        this.step1();
        this.step2();
        this.step3();
        this.step4();
        this.step5();
    }

    @Step("1")
    private void step1() {
        this.FullName.should(new Condition[]{Condition.visible}).val("Тимур");
    }

    @Step("2")
    private void step2() {
        this.Email.should(new Condition[]{Condition.visible}).val("timurka2609@yandex.ru");
    }

    @Step("3")
    private void step3() {
        this.CurrentAddress.should(new Condition[]{Condition.visible}).val("Кострома");
    }

    @Step("4")
    private void step4() {
        this.PermanentAddress.should(new Condition[]{Condition.visible}).val("Кострома");
    }

    @Step("5")
    private void step5() {
        this.Submit.should(new Condition[]{Condition.visible}).click();
    }

    @AfterEach
    public void after() {
    }
}
