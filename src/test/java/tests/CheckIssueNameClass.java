package tests;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckIssueNameClass {

    @Test
    void checkIssueName(){
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("asyakasimova/hw5");
        $(".header-search-input").submit();
        $(By.linkText("asyakasimova/hw5")).click();
        $(withText("Issues")).click();
        $(withText("CheckIssueClassName")).should(Condition.exist);
    }
}
