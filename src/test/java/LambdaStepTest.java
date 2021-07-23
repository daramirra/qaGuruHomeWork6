import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NAME = "Listeners NamedBy";


    @Test
    public void testRepositoryIssue() {
        step("Открыть главную страницу GitHub", () -> open("https://github.com/"));

        step("В поле Search GitHub ввести критерий поиска " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY).submit();
        });

        step("Перейти в репозиторий " + REPOSITORY, () -> $(linkText(REPOSITORY)).click());

        step("Перейти в раздел Issues", () -> $(partialLinkText("Issues")).click());

        step("Проверить наличие Issue с названием " + ISSUE_NAME, () ->
                $(withText(ISSUE_NAME)).should(Condition.visible));
    }
}
