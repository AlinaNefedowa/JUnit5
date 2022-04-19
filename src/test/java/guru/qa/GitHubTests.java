package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Класс с тестами на GitHub")
public class GitHubTests {

    @ValueSource(strings = {
            "Alina",
            "Maria",
            "Anton"
    })

    @ParameterizedTest (name = "Тесты поиск в GitHub по слову {0}")
    void gitHubSearchTests(String testData) {

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(testData);
        $(".header-search-input").submit();
        $(withText(testData)).should(Condition.exist);
    }

    @CsvSource(value = {
            "wow, Reveal CSS animation as you scroll down a page",
            "now, Build a Jekyll blog in minutes"
    })

    @ParameterizedTest(name = "Тесты поиск в GitHub по слову {0}, ожидаем {1}")
    void gitHubComplexSearchTests(String testData, String expectedResult) {

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(testData);
        $(".header-search-input").submit();
        $$(".codesearch-results")
                .find(Condition.text(expectedResult))
                        .shouldBe(visible);
    }

    static Stream<Arguments> methodSourceExampleTest() {
        return Stream.of(
                Arguments.of("Alina`s birthday", List.of(13, 5)),
                Arguments.of("Anna`s birthday", List.of(4, 8))
        );
    }

    @MethodSource("methodSourceExampleTest")

    @ParameterizedTest(name = "Тесты с MethodSourceSearchTests")
    void MethodSourceSearchTests(String first, List<Integer> second) {
        System.out.println(first + " is " + second);
    }
}
