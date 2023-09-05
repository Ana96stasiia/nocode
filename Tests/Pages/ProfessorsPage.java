package Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ProfessorsPage extends BasePage {
    public void enterNameProfessor (String professorSearch) {
        SelenideElement nameInput = $("input.MuiInputBase-input.MuiOutlinedInput-input.MuiInputBase-inputAdornedStart.MuiInputBase-inputAdornedEnd[aria-invalid=\"false\"][placeholder=\"Search by course name or professor\"]");
        nameInput.setValue(professorSearch);
    }

    public void clickProfessorsButton() {
        SelenideElement professorsButton = $("#home_header4 > header > div > div > div.css-183hjg0 > a:nth-child(3)");
        professorsButton.click();
    }

    public boolean areSearchResultsContainOnlyProfessors(String student) {
        SelenideElement teacherProfile = $("student");
        return teacherProfile.exists();
    }
}
