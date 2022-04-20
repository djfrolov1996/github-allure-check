package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    private static final String REPOSITORY = "djfrolov1996/lesson_3_dz";
    private static final int ISSUE_NUMBER = 1;

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("input[placeholder='Search GitHub']").click();
            $("input[placeholder='Search GitHub']").sendKeys(REPOSITORY);
            $("input[placeholder='Search GitHub']").submit();
        });

        step("Переходим по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Кликаем на Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем наличие Issues c номером " + ISSUE_NUMBER, () -> {
            $(withText("#1")).should(Condition.visible);
        });

    }

}
