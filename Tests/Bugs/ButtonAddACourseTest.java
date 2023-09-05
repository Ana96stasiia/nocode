package Tests.Bugs;

import Pages.TeacherAccountPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("My Epic")
@Feature("My Feature")

public class ButtonAddACourseTest extends BaseTest {

    @Test
    @Description("The button add a course." +
            "Expected result: redirected to the page with the form for adding a new course.")
    public void testButtonAddACourse() {
        TeacherAccountPage teacherAccountPage = new TeacherAccountPage();
        teacherAccountPage.open(url2);

        //SignIn teacher
        teacherAccountPage.enterEmailTeacher(teacherEmail);
        teacherAccountPage.enterPasswordTeacher(teacherPassword);

        // Click the "Sign In" button
        teacherAccountPage.clickSignInButton();

        // Verify the successful registration message
        teacherAccountPage.getAuthorizationSuccessTeacherMessage().shouldHave(text("Welcome to NoCode University's Student Portal"));

        teacherAccountPage.clickButtonAddACourseTest();

        boolean isFormVisible = teacherAccountPage.isFormVisible();
        assertTrue(isFormVisible, "Password recovery form is not visible");

        // Проверка что на странице есть текст с ошибкой
        teacherAccountPage.getFailureMessage().shouldHave(text("404 - Page not found"));
        // Отправляем HTTP-запрос на страницу
        HttpURLConnection connection;
        int statusCode;
        try {
            URL url = new URL(url4);
            connection = (HttpURLConnection) url.openConnection();
            statusCode = connection.getResponseCode();
            connection.disconnect();
        } catch (Exception e) {
            throw new RuntimeException("Failed to send HTTP request", e);
        }
        // Проверяем статусный код
        assertEquals(404, statusCode);
    }
}