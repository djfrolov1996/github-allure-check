package qa.guru.allure;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");

        $("input[placeholder='Search GitHub']").click();
        $("input[placeholder='Search GitHub']").sendKeys("djfrolov1996/lesson_3_dz");
        $("input[placeholder='Search GitHub']").submit();

        $(By.linkText("djfrolov1996/lesson_3_dz")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("#1")).click();
    }
}
