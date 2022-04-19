package guru.qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@DisplayName("Класс с тестами словаря")
public class DudenTests {

    @DisplayName("Тест на провеку слова")
    @Test
    void firstTest() {
        Selenide.open("https://www.duden.de/");
        sleep(5000);
        $("button[title='AKZEPTIEREN']").click();
        //$(byText("AKZEPTIEREN")).click();
        // $(byTitle("AKZEPTIEREN")).click();
    }
}

//@Disabled("ABC-123")