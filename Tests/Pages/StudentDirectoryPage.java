package Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class StudentDirectoryPage extends BasePage {

    public void enterNameStudent(String studentSearch) {
        SelenideElement nameInput = $("input.MuiInputBase-input");
        nameInput.setValue(studentSearch);
    }

    public void clickStudentDirectoryButton() {
        SelenideElement studentDirectoryButton = $("a[href=\"/student-directory\"] span.MuiBox-root.css-0");
        studentDirectoryButton.click();
    }

    public boolean areSearchResultsContainOnlyStudents(String teacher) {
        SelenideElement teacherProfile = $("teacher");
        return teacherProfile.exists();
    }
}
