package tests;

import guru.qa.asiakasimova.BaseSteps;
import org.junit.jupiter.api.Test;

public class CheckIssueNameWithSteps {

    public BaseSteps steps = new BaseSteps();
    private static final String REPOSITORY = "asyakasimova/hw5";
    private static final String ISSUE_NUMBER = "#1";

    @Test
    public void testIssueSearch() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.openRepositoryIssues();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
