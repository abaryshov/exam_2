import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("abaryshov")
public class AuthTest {

    @BeforeEach
    public void setup(){
        open("http://automationpractice.com/index.php");
    }

    @Test
    @Story("Добавление товара")
    @DisplayName("Добавление товара в корзину через быструю корзину")
    public void shouldAddingQuickCartTest() {
        step("Добавить товар в корзину", () -> {
            TestPages.mainPage.mainHoverProduct()
                    .hover();
            TestPages.mainPage.mainClickAddCart()
                    .click();
        });

        step("Перейти в корзину", () -> {
            TestPages.mainPage.mainClickGoCart()
                    .click();
            TestPages.mainPage.mainCheckCartPage()
                    .shouldBe(visible);
        });

        step("Проверить наличие товара в корзине", () -> {
            TestPages.mainPage.mainCheckItemCart()
                    .shouldBe(visible);
        });
    }

    @MethodSource("invalidMail")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Проверка ввода e-mail:")
    public void shouldInvalidMail(String email){
        step("Заполнить поле инпута e-mail и отправить заполненную форму", () -> {
            TestPages.mainPage.mainEnterValueMail()
                    .sendKeys(email);
            TestPages.mainPage.mainClickSubmitForm()
                    .click();
        });

        step("Проверить, что появилось уведомление об ошибке", () -> {
            TestPages.mainPage.mainCheckErrorNotification()
                    .shouldBe(visible);
        });
    }

    static Stream<Arguments> invalidMail() {
        return Stream.of(
                arguments(
                        "1"
                ),
                arguments(
                        "!"
                ),
                arguments(
                        "mail"
                        ),
                arguments(
                        "mail@"
                        )
        );
    }
}