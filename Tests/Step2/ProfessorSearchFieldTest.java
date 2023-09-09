package Tests.Step2;

import Pages.ProfessorsPage;
import Pages.SignInPage;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("My Epic")
@Feature("My Feature")

public class ProfessorSearchFieldTest extends BaseTest {
    @Test
    @Description("The search field teachers." +
            "Expected result: when performing a search in the professors search field, it searches among professors.")
    public void testProfessorSearch () {

        SignInPage signInPage = new SignInPage();
        signInPage.open(url5);

        // Fill in the authorization form
        signInPage.enterEmailStudent(studentEmail);
        signInPage.enterPasswordStudent(studentPassword);

        // Click the "Sign In" button
        signInPage.clickSignInButton();

        ProfessorsPage professorsPage = new ProfessorsPage();
        professorsPage.clickProfessorsButton();

        // Находим поле поиска учителей и вводим данные
        professorsPage.enterNameProfessor(professorSearch);

        // Ожидаем, что значение в поле ввода изменится на ожидаемое
        $("input.MuiInputBase-input.MuiOutlinedInput-input.MuiInputBase-inputAdornedStart.MuiInputBase-inputAdornedEnd[aria-invalid=\"false\"][placeholder=\"Search by course name or professor\"]").shouldHave(value(professorSearch));

        // Проверяем, что результаты поиска не содержат элемент с текстом "student"
        assertTrue(professorsPage.areSearchResultsContainOnlyProfessors2("student"));

        // Проверяем, что результаты поиска не содержат элемент с текстом "student"
        if (!professorsPage.areSearchResultsContainOnlyProfessors2("student")) {
            System.out.println("Found profiles only teacher.");
        }
    }
}