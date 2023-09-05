package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class TeacherAccountPage extends SignInPage {
    public void open(String url2) {
        Selenide.open(url2);
    }

    //нажать на кнопку Add A Course
    public void clickButtonAddACourseTest() {
        SelenideElement addACourse = Selenide.$("div[style*=\"display: flex;\"] a.MuiButton-containedPrimary:nth-of-type(1)");
        addACourse.click();
    }

    //проверка наличия формы для добавления курса
    public boolean isFormVisible() {
        try {
            getPasswordRecoveryForm().shouldBe(Condition.visible);
            return true;
        } catch (Throwable throwable) {
            return false;
        }
    }
    private SelenideElement getPasswordRecoveryForm() {
        return Selenide.$("course-documents-form");
    }

    public SelenideElement getFailureMessage() {
        return Selenide.$("<h2>");
    }
}
