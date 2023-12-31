package Tests.API.Student;

import Tests.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("My Epic")
@Feature("My Feature")

public class CreateUserTest extends BaseTest {

    @Test
    //Pre-conditions: This user must not be registered on the site!
    @Description("This is a create user student's api test." +
            "Expected result: status code is 201.")
    public void testCreateUser() {
        // Устанавливаем базовый URL для API
        RestAssured.baseURI = "https://jere237.softr.app";

        // Создаем тело запроса в формате JSON
        String requestBody = "{\n" +
                "  \"full_name\": \"Erika Schwarz\",\n" +
                "  \"email\": \"erika.schwarz@gmail.com\",\n" +
                "  \"password\": \"0987654321\",\n" +
                "  \"generate_magic_link\": false\n" +
                "}";

        // Отправляем POST-запрос с заданными заголовками и телом запроса
        Response response = RestAssured.given()
                .header("Softr-Domain", "jere237.softr.app")
                .header("Content-Type", "application/json")
                .header("Softr-Api-Key", "khIbAyJIU5CIuh1oDuBRx1s49")
                .body(requestBody)
                .when()
                .post("https://studio-api.softr.io/v1/api/users");

        // Проверяем статус-код ответа
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        // Проверяем, что запрос завершился успешно (с кодом 201 - Created)
        response.then().assertThat().statusCode(201);

        // Дополнительные проверки на основе содержимого ответа, если необходимо
        // Например, можно проверить поля JSON-ответа
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }
}

