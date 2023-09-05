package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SignUpPage extends BasePage {
    public void open(String url1) {
        Selenide.open(url1);
    }
    //AgreeCheckBoxTest
    private final SelenideElement agreeCheckbox = Selenide.$(".checkmark.position-relative.sw-checkbox");

    public void checkAgreeCheckbox() {
        clickElement(agreeCheckbox);
    }
    public boolean isAgreeCheckboxDisplayed() {
        return isElementDisplayed(agreeCheckbox);
    }
    public SelenideElement getAgreeCheckbox() {
        return agreeCheckbox;
    }
    //DropDownTest
    // Проверка видимости выпадающего списка ролей
    //поле выбрать роль
    private final SelenideElement selectRoleDropdown = Selenide.$("#signup > div.row.align-items-center > div.col-12.sw-js-signup-fields > div.text-center.sw-dropdown > div > button > div > div");

    //открытие выпадающего списка
    private final SelenideElement openSelectRoleDropdown = Selenide.$x("//button[contains(@class, 'dropdown-toggle')]");

    //наличие варианта учитель
    private final SelenideElement isTeacherOptionPresent = Selenide.$x("//ul[contains(@class, 'dropdown-menu inner show')]//span[text()='teacher']");

    //is displayed student
    private final SelenideElement isStudentOptionPresent = Selenide.$x("//ul[contains(@class, 'dropdown-menu inner show')]//span[text()='student']");

    //выбор варианта учитель
    private final SelenideElement teacherOption = Selenide.$("select#sw-form-capture-Role option[value='teacher']");

    //выбор варианта student
    private final SelenideElement studentOption = Selenide.$("select#sw-form-capture-Role option[value='student']");
    public boolean isSelectRoleDropdownDisplayed() {
        return isElementDisplayed(selectRoleDropdown);
    }

    // Открытие выпадающего списка ролей
    public void openSelectRoleDropdown() {
        clickElement(openSelectRoleDropdown);
    }

    // наличие варианта учитель
    public boolean isTeacherOptionPresent () {
        return isElementDisplayed(isTeacherOptionPresent);
    }
    // наличие варианта student
    public boolean isStudentOptionPresent () {
        return isElementDisplayed(isStudentOptionPresent);
    }
    //SelectTeacherRoleTest
    public void selectTeacherOption() {
        openSelectRoleDropdown();
        clickElement(teacherOption);
    }
    //SelectStudentRoleTest
    public void selectStudentOption() {
        openSelectRoleDropdown();
        clickElement(studentOption);
    }

    //ValidDataTeacher
    // Метод для ввода полного имени
    public void enterFullName(String teacherFullName) {
        SelenideElement fullNameInput = Selenide.$("div.text-center input#sw-form-capture-full_name-input");
        fullNameInput.setValue(teacherFullName);
    }

    // Метод для ввода электронной почты
    public void enterEmail(String teacherEmail) {
        SelenideElement emailInput = Selenide.$("div.text-center input#sw-form-capture-email-input");
        emailInput.setValue(teacherEmail);
    }

    // Метод для ввода пароля
    public void enterPassword(String teacherPassword) {
        SelenideElement passwordInput = Selenide.$("input#sw-form-password-input");
        passwordInput.setValue(teacherPassword);
    }

    // Метод для клика на кнопку "Sign Up"
    public void clickSignUpButton() {
        SelenideElement signUpButton = Selenide.$("a#sw-sign-up-submit-btn");
        signUpButton.click();
    }

    // Метод для получения сообщения об успешной регистрации teacher
    public SelenideElement getRegistrationSuccessTeacherMessage() {
        return Selenide.$("header[data-block-id=\"1514f321-5298-41cd-b4c0-d0dae009d1f6\"]");
    }

    // Метод для получения сообщения об успешной регистрации student
    public SelenideElement getRegistrationSuccessStudentMessage() {
        return Selenide.$("header[data-block-id=\"7b55e8e7-ae9f-47f2-8d0c-336a9780a5f7\"]");
    }

    // Метод для получения сообщениея о не успешной регистрации
    public SelenideElement getRegistrationFailureMessage() {
        return Selenide.$("div.error-message.required-errors");
    }

    //ValidDataStudent
    // Метод для ввода полного имени
    public void enterFullNameStudent(String studentFullName) {
        SelenideElement fullNameInput = Selenide.$("div.text-center input#sw-form-capture-full_name-input");
        fullNameInput.setValue(studentFullName);
    }

    // Метод для ввода электронной почты
    public void enterEmailStudent(String studentEmail) {
        SelenideElement emailInput = Selenide.$("div.text-center input#sw-form-capture-email-input");
        emailInput.setValue(studentEmail);
    }

    // Метод для ввода пароля
    public void enterPasswordStudent(String studentPassword) {
        SelenideElement passwordInput = Selenide.$("input#sw-form-password-input");
        passwordInput.setValue(studentPassword);
    }

}
