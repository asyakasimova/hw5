package tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;


public class CheckIssueNameClass {
    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "asyakasimova/hw5";
    private static final String ISSUES = "Issues";
    private static final String ISSUE_NUMBER = "#1";


    @Test
    void checkIssueName(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(BASE_URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText(ISSUES)).click();
        $(withText(ISSUE_NUMBER)).should(Condition.exist);
    }

    @Test
    @Link(name = "Base URL", value = BASE_URL)
    @Owner("asiakasimova")
    @Feature("Issues")
    @Story("Поиск Issue по номеру в существующем репозитории")
    @Tags({@Tag("web"), @Tag("Critical")})
    @DisplayName("Поиск Issue по номеру в репозитории")
    void checkIssueNameWithSteps(){
        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NUMBER);

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open(BASE_URL);
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Кликаем на репозиторий "+ REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });

        step("Переходим в раздел" + ISSUES, () -> {
            $(withText(ISSUES)).click();
        });

        step("Проверяем, что в разделе есть ISSUE " + ISSUE_NUMBER, () -> {
            $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });
    }


}
