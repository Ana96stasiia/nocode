package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SignInPage extends BasePage{
    public void open(String url2) {
        Selenide.open(url2);
    }

    // Метод для ввода электронной почты teacher
    public void enterEmailTeacher (String teacherEmail) {
        SelenideElement emailInput = Selenide.$(".col-12 input[type=\"email\"]#sw-form-capture-email-input ");
        emailInput.setValue(teacherEmail);
    }

    // Метод для ввода пароля teacher
    public void enterPasswordTeacher (String teacherPassword) {
        SelenideElement passwordInput = Selenide.$("#sw-form-password-input[type=\"password\"]");
        passwordInput.setValue(teacherPassword);
    }

    // Метод для клика на кнопку "Sign In"
    public void clickSignInButton() {
        SelenideElement signInButton = Selenide.$("a[data-element=\"button\"]#sw-sign-in-submit-btn");
        signInButton.click();
    }

    // Метод для получения сообщения об успешной авторизации студента
    public SelenideElement getAuthorizationSuccessStudentMessage() {
        return Selenide.$("#hero-students.hero1-7b55e8e7-ae9f-47f2-8d0c-336a9780a5f7");
    }

    // Метод для получения сообщения об успешной авторизации учителя
    public SelenideElement getAuthorizationSuccessTeacherMessage() {
        return Selenide.$("#hero-teachers.hero1-1514f321-5298-41cd-b4c0-d0dae009d1f6");
    }

    // Метод для ввода электронной почты student
    public void enterEmailStudent(String studentEmail) {
        SelenideElement emailInput = Selenide.$(".col-12 input[type=\"email\"]#sw-form-capture-email-input ");
        emailInput.setValue(studentEmail);
    }

    // Метод для ввода пароля student
    public void enterPasswordStudent(String studentPassword) {
        SelenideElement passwordInput = Selenide.$("#sw-form-password-input[type=\"password\"]");
        passwordInput.setValue(studentPassword);
    }

    //Не успешная авторизация student
    public SelenideElement getAuthorizationFailureMessage() {
        return Selenide.$("div.error-message.login-error.d-block");
    }

    //PasswordVisibilityTest
    public SelenideElement getPasswordTextInput() {
        return Selenide.$("input#sw-form-password-input[type=\"text\"][name=\"password\"][required=\"true\"][placeholder=\"Password\"]");
    }

    //click on the "Show password" icon
    public void clickShowPasswordIcon() {
        SelenideElement showPasswordIcon = Selenide.$("i.fa.show-password.fa-eye-slash");
        showPasswordIcon.click();
    }

    //скрыть пароль
    public void clickHidePasswordIcon() {
        SelenideElement hidePasswordIcon = Selenide.$("i.fa.show-password.active.fa-eye");
        hidePasswordIcon.click();
    }

    public SelenideElement getPasswordInput() {
        return Selenide.$("input#sw-form-password-input[type=\"password\"][name=\"password\"][required=\"true\"][placeholder=\"Password\"]\n");
    }

    public void clickForgotPasswordLink() {
        SelenideElement ForgotPasswordLink = Selenide.$("a[href=\"/forgot-password\"]");
        ForgotPasswordLink.click();
    }

    //проверка наличия формы для восстановления пароля
    public boolean isPasswordRecoveryFormVisible() {
        try {
            getPasswordRecoveryForm().shouldBe(Condition.visible);
            return true;
        } catch (Throwable throwable) {
            return false;
        }
    }
    private SelenideElement getPasswordRecoveryForm() {
        return Selenide.$("forgot_password_form");
    }
}