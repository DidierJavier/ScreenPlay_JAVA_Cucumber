package co.com.sofka.tasks.practiceform;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.sofka.interactions.common.common.Click.clickOn;
import static co.com.sofka.interactions.common.common.Scroll.scrollTo;
import static co.com.sofka.interactions.common.sikulis.Click.clickWithSikulixOn;
import static co.com.sofka.interactions.common.sikulis.Write.writeWithSikulixOn;
import static co.com.sofka.userinterfaces.practiceform.BrowseToPracticeFormPage.*;
import static co.com.sofka.userinterfaces.practiceform.SikulixPathPracticeForm.*;
import static co.com.sofka.utils.gender.Gender.FEMALE;
import static co.com.sofka.utils.gender.Gender.MALE;

public class FillAllFieldsPracticeForm implements Task {
    private String firstName;
    private String lastName;
    private String gender;
    private String mobile;

    public FillAllFieldsPracticeForm usingFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FillAllFieldsPracticeForm usingLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public FillAllFieldsPracticeForm usingGender(String gender) {
        this.gender = gender;
        return this;
    }

    public FillAllFieldsPracticeForm andMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(FIRST_NAME),
                Clear.field(FIRST_NAME),
                Enter.theValue(firstName).into(FIRST_NAME),

                Scroll.to(LAST_NAME),
                Clear.field(LAST_NAME),
                Enter.theValue(lastName).into(LAST_NAME),

                Check.whether(MALE.getValue().equals(gender)).andIfSo(
                        Scroll.to(GENDER_MALE),
                        Click.on(GENDER_MALE)
                ).otherwise(
                        Check.whether(FEMALE.getValue().equals(gender)).andIfSo(
                                Scroll.to(GENDER_FEMALE),
                                Click.on(GENDER_FEMALE)
                ).otherwise(
                                Scroll.to(GENDER_OTHER),
                                Click.on(GENDER_OTHER)
                        )
                ),
                Scroll.to(MOBILE),
                Clear.field(MOBILE),
                Enter.theValue(mobile).into(MOBILE),

                //Sikulix
                clickWithSikulixOn(SELECT_PICTURE_PATH),
                writeWithSikulixOn(FILE_NAME_TEXT_BOX_PATH, ATTACHMENT_FILE_PATH),
                clickWithSikulixOn(SELECT_OPEN_PATH),
                //End Sikulix

                scrollTo(SUBMIT),
                clickOn(SUBMIT)
        );
    }

    public static FillAllFieldsPracticeForm fillAllFieldsPracticeForm(){
        return new FillAllFieldsPracticeForm();
    }
}
