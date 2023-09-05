package Tests.Bugs;

import Pages.SignInPage;
import Pages.StudentDirectoryPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("My Epic")
@Feature("My Feature")

public class StudentSearchTest extends BaseTest {
    @Test
    @Description("The search field students." +
            "Expected result: when entering data in the student search field, a search is performed among students and teachers.")
    public void testStudentSearch() {

        SignInPage signInPage = new SignInPage();
        signInPage.open(url2);

        // Fill in the authorization form
        signInPage.enterEmailStudent(studentEmail);
        signInPage.enterPasswordStudent(studentPassword);

        // Click the "Sign In" button
        signInPage.clickSignInButton();

        StudentDirectoryPage studentDirectoryPage = new StudentDirectoryPage();
        studentDirectoryPage.clickStudentDirectoryButton();

        // Находим поле поиска студентов и вводим данные
        studentDirectoryPage.enterNameStudent(studentSearch);

        // Ожидаем, что значение в поле ввода изменится на ожидаемое
        $("input.MuiInputBase-input").shouldHave(value(studentSearch));

        // Проверяем, что результаты поиска не содержат элемент с текстом "teacher"
        assertTrue(studentDirectoryPage.areSearchResultsContainOnlyStudents("teacher"));

        // Проверяем, что результаты поиска не содержат элемент с текстом "teacher"
        if (!studentDirectoryPage.areSearchResultsContainOnlyStudents("teacher")) {
            System.out.println("Found profiles only students.");
        }
    }
}