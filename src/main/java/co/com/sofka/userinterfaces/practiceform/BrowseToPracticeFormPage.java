package co.com.sofka.userinterfaces.practiceform;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.*;

public class BrowseToPracticeFormPage extends PageObject {

    public static final Target ELEMENTS = Target
            .the("Elements")
            .located(xpath("//div[@class='category-cards']//div[1]//div[1]//div[1]"));

    public static final Target FORMS = Target
            .the("Form")
            .located(xpath("//div[normalize-space()='Forms']"));

    public static final Target PRACTICE_FORM = Target
            .the("Practice form")
            .located(xpath("//span[normalize-space()='Practice Form']"));

    public static final Target FIRST_NAME = Target
            .the("First Name")
            .located(id("firstName"));

    public static final Target LAST_NAME = Target
            .the("Last Name")
            .located(id("lastName"));

    public static final Target USER_EMAIL = Target
            .the("User Email")
            .located(id("userEmail"));

    public static final Target GENDER_MALE = Target
            .the("Gender Male")
            .located(xpath("//label[normalize-space()='Male']"));

    public static final Target GENDER_FEMALE = Target
            .the("Gender Female")
            .located(xpath("//label[normalize-space()='Female']"));

    public static final Target GENDER_OTHER = Target
            .the("Gender Other")
            .located(xpath("//label[normalize-space()='Other']"));

    public static final Target MOBILE = Target
            .the("Mobile")
            .located(id("userNumber"));

    public static final Target SUBMIT = Target
            .the("Submit")
            .located(id("submit"));

    public static final Target BIRTHDAY = Target
            .the("Birthday")
            .located(id("dateOfBirthInput"));

    public static final Target SUBJECTS = Target
            .the("Subjects")
            .located(id("subjectsInput"));

    public static final Target HOBBIES_SPORTS = Target
            .the("Hobbies Sports")
            .located(cssSelector("label[for='hobbies-checkbox-1']"));

    public static final Target HOBBIES_READING = Target
            .the("Hobbies Reading")
            .located(cssSelector("label[for='hobbies-checkbox-2']"));

    public static final Target HOBBIES_MUSIC = Target
            .the("Hobbies Music")
            .located(cssSelector("label[for='hobbies-checkbox-3']"));

    public static final Target UPLOAD_PICTURE = Target
            .the("Upload Picture")
            .located(id("uploadPicture"));

    public static final Target CURRENT_ADDRESS = Target
            .the("Current Address")
            .located(id("currentAddress"));

    public static final Target STATE = Target
            .the("State")
            .located(id("react-select-3-input"));

    public static final Target CITY = Target
            .the("City")
            .located(id("react-select-4-input"));

    //For validations
    public static final Target STUDENT_NAME_VALIDATION = Target
            .the("Student Name")
            .located(xpath("//table/tbody/tr[1]/td[2]"));

    public static final Target GENDER_VALIDATION = Target
            .the("Gender")
            .located(xpath("//table/tbody/tr[3]/td[2]"));

    public static final Target MOBILE_VALIDATION = Target
            .the("Mobile")
            .located(xpath("//table/tbody/tr[4]/td[2]"));
}


