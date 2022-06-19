package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement mainHoverProduct() {
        return $("[title='Faded Short Sleeve T-shirts']").as("навести курсор на товар");
    }

    public SelenideElement mainClickAddCart() {
        return $("[title='Add to cart']").as("кликнуть на товар для добавления в корзину");
    }

    public SelenideElement mainClickGoCart() {
        return $("[title='Proceed to checkout']").as("кликнуть для перехода в корзину");
    }

    public SelenideElement mainEnterValueMail() {
        return $("[class='inputNew form-control grey newsletter-input']").as("ввести значение в инпут e-mail");
    }

    public SelenideElement mainClickSubmitForm() {
        return $("[name='submitNewsletter']").as("кликнуть для отправки формы");
    }

    public SelenideElement mainCheckErrorNotification() {
        return $("[class='alert alert-danger']").as("проверить, что появилось уведомление об ошибке");
    }
}
