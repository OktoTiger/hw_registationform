package task4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckWikiAndSoftAssertionsInSelenidePageTest {
          private final String JUNIT5_TEST_CODE = """
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                @Test
                void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");
                $("#first").should(visible).click();
                 $("#second").should(visible).click();
                 }
               }
               """;


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void checkWikiAndSoftAssertions(){
        open("/selenide/selenide");
        $("ul.UnderlineNav-body").$("li",5).click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $ ("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(text(JUNIT5_TEST_CODE));

    }
}
