package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CardPage {
    public SelenideElement cardCheckCartPage() {
        return $("[id='cart_title']").as("проверить элемент на странице корзины");
    }

    public SelenideElement cardCheckItemCart() {
        return $("[class='label label-success']").as("проверить наличие товара в корзине");
    }

    public SelenideElement cardCheckItemSkuCart() {
        return $(byText("SKU : demo_1")).as("проверить ску товара в корзине");
    }
}
