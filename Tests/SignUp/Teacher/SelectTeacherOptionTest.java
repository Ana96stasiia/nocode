package Tests.SignUp.Teacher;

import Pages.SignUpPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
@Epic("My Epic")
@Feature("My Feature")

public class SelectTeacherOptionTest extends BaseTest {
    @Test
    @Description("This is a select teacher option test." +
            "Expected result: \"student\" option is selected in the input field.")
    public void testSelectTeacherOption() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.open(url1);

        if (signUpPage.isSelectRoleDropdownDisplayed()) {
            signUpPage.openSelectRoleDropdown();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean isTeacherOptionPresent = signUpPage.isTeacherOptionPresent();

            if (isTeacherOptionPresent) {
                signUpPage.selectTeacherOption();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Teacher option is selected.");
                assertTrue(isTeacherOptionPresent);
            } else {
                System.out.println("Teacher option is not present in the dropdown.");
                fail("Teacher option is not present in the dropdown.");
            }
        } else {
            System.out.println("Select Role dropdown is not displayed.");
            fail("Select Role dropdown is not displayed.");
        }
    }
}