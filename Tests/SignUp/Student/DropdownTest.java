package Tests.SignUp.Student;

import com.codeborne.selenide.Selenide;
import Pages.SignUpPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import static org.junit.jupiter.api.Assertions.fail;
import static org.testng.AssertJUnit.assertTrue;
@Epic("My Epic")
@Feature("My Feature")

public class DropdownTest extends BaseTest {
    @Test
    @Description("This is a dropdown test." +
            "Expected result: drop down list with \"student\" option.")
    public void testDropdownContainsOptionStudent() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.open(url1);

        boolean isStudentOptionPresent;
        if (signUpPage.isSelectRoleDropdownDisplayed()) {
            signUpPage.openSelectRoleDropdown();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isStudentOptionPresent = signUpPage.isStudentOptionPresent();

            if (isStudentOptionPresent) {
                System.out.println("Student option is present in the dropdown.");
            } else {
                System.out.println("Student option is not present in the dropdown.");
            }
            // Проверка наличия опции "Teacher" в выпадающем списке
            assertTrue("Student option is not present in the dropdown.", isStudentOptionPresent);
        } else {
            System.out.println("Select Role dropdown is not displayed.");
            fail("Select Role dropdown is not displayed.");
        }
        Selenide.sleep(3000);
    }
}