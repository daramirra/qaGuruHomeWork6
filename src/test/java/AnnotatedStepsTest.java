import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NAME = "Listeners NamedBy";

    private WebSteps webSteps = new WebSteps();

    @Test
    public void shouldSeeIssueInRepository(){
        webSteps
                .openMainPage()
                .searchForRepository(REPOSITORY)
                .goToRepository(REPOSITORY)
                .openIssuesTab()
                .checkIssueName(ISSUE_NAME);
    }
}
