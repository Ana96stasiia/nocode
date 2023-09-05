package Tests.API.Student;

import Tests.BaseTest;
import com.codeborne.selenide.Condition;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("My Epic")
@Feature("My Feature")

public class DeleteUserTest extends BaseTest {

    @Test
    //Pre-conditions: This user must be registered on the site!
    @Description("This is a delete user student's api test." +
            "Expected result: a code status is 200.")
    public void testDeleteUser() {
        // Установите базовый URL для API
        RestAssured.baseURI = "https://studio-api.softr.io/v1/api";

        // Отправьте API-запрос на удаление пользователя
        Response response = RestAssured.given()
                .header("Softr-Api-Key", "khIbAyJIU5CIuh1oDuBRx1s49")
                .header("Softr-Domain", "jere237.softr.app")
                .when()
                .delete("/users/erika.schwarz@gmail.com");

        // Проверьте, что запрос завершился успешно с кодом 200
        assertEquals(200, response.getStatusCode());

        // Теперь можно попробовать выполнить вход с данными удаленного пользователя и проверить, что это невозможно
        open(url2);
        $("erika.schwarz@gmail.com");
        $("0987654321");
        $("a[data-element=\"button\"]#sw-sign-in-submit-btn").click();

        // Проверить, что на странице входа есть сообщение об ошибке
        $(".error-message").shouldHave(Condition.text("Invalid email or password"));
    }
}