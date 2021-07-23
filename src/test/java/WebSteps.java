import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открыть главную страницу GitHub")
    public WebSteps openMainPage(){
        open("https://github.com/");
        return this;
    }

    @Step("В поле Search GitHub ввести критерий поиска {repository}")
    public WebSteps searchForRepository(String repository){
        $(".header-search-input").setValue(repository).submit();
        return this;
    }

    @Step("Перейти в репозиторий {repository}")
    public WebSteps goToRepository(String repository){
        $(linkText(repository)).click();
        return this;
    }

    @Step("Перейти в раздел Issues")
    public WebSteps openIssuesTab(){
        $(partialLinkText("Issues")).click();
        return this;
    }

    @Step("Проверить наличие Issue с названием {name}")
    public WebSteps checkIssueName(String name){
        $(withText(name)).should(Condition.visible);
        return this;
    }

}
