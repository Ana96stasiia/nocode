package Tests.Step2;

import Pages.TeacherAccountPage;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("My Epic")
@Feature("My Feature")

public class ButtonAddACourseTest extends BaseTest {

    @Test
    @Description("The button add a course." +
            "Expected result: redirected to the page with the form for adding a new course.")
    public void testButtonAddACourse() {
        TeacherAccountPage teacherAccountPage = new TeacherAccountPage();
        teacherAccountPage.open(url5);

        //SignIn teacher
        teacherAccountPage.enterEmailTeacher(teacherEmail);
        teacherAccountPage.enterPasswordTeacher(teacherPassword);

        // Click the "Sign In" button
        teacherAccountPage.clickSignInButton();

        // Verify the successful registration message
        teacherAccountPage.getAuthorizationSuccessTeacherMessage2().shouldHave(text("Welcome to NoCode University's Student Portal"));

        teacherAccountPage.clickButtonAddACourseTest();

        boolean isFormVisible = teacherAccountPage.isFormVisible();
        assertTrue(isFormVisible, "Form is not visible");
    }
}