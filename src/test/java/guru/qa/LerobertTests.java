package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("Класс с тестами словаря")
public class LerobertTests {

    @DisplayName("Тест на провеку слова")
    @Test
    void firstTest() {
        Selenide.open("https://dictionnaire.lerobert.com/definition/");
        $(".ws-s-i").click();
        $(".ws-s-i").sendKeys("manger");
        $(".ws-s-i").submit();
    }
}