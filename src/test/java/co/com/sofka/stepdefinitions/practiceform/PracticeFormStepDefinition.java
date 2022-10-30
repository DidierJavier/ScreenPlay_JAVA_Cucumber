package co.com.sofka.stepdefinitions.practiceform;

import co.com.sofka.setup.ui.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.questions.practiceform.PracticeForm.practiceForm;
import static co.com.sofka.tasks.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.practiceform.BrowseToPracticeForm.browseToPracticeForm;
import static co.com.sofka.tasks.practiceform.FillAllFieldsPracticeForm.fillAllFieldsPracticeForm;
import static co.com.sofka.utils.Number.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class PracticeFormStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(PracticeFormStepDefinition.class);

    private static final String ACTOR_NAME = "Student";
    private DataTable dataTableToValidate;
    @Given("the student is on landing page of Tools QA")
    public void the_student_is_on_landing_page_of_tools_qa() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
        LOGGER.info("El estudiante está en la página de Tools QA");
    }

    @When("him browse to registration form")
    public void him_browse_to_registration_form() {
        theActorInTheSpotlight().attemptsTo(
                browseToPracticeForm()
        );
        LOGGER.info("El estudiante accede al formulario");
    }

    @When("him has filled it and submitted")
    public void him_has_filled_it_and_submitted(DataTable studentDataTable) {
        dataTableToValidate = studentDataTable;
        theActorInTheSpotlight().attemptsTo(
                fillAllFieldsPracticeForm()
                        .usingFirstName(studentDataTable.row(CERO.getNumber()).get(UNO.getNumber()))
                        .usingLastName(studentDataTable.row(UNO.getNumber()).get(UNO.getNumber()))
                        .usingGender(studentDataTable.row(DOS.getNumber()).get(UNO.getNumber()))
                        .andMobile(studentDataTable.row(TRES.getNumber()).get(UNO.getNumber()))
        );
        LOGGER.info("El estudiante llenó el formulario");
    }

    @Then("the student will see a registration information")
    public void the_student_will_see_a_registration_information() {
        theActorInTheSpotlight().should(
            seeThat(
                    practiceForm()
                        .wasFilledWithFirstName(dataTableToValidate.row(CERO.getNumber()).get(UNO.getNumber()))
                        .andWithLastName(dataTableToValidate.row(UNO.getNumber()).get(UNO.getNumber()))
                        .andWithGender(dataTableToValidate.row(DOS.getNumber()).get(UNO.getNumber()))
                        .andWithMobile(dataTableToValidate.row(TRES.getNumber()).get(UNO.getNumber()))
                        .is(), equalTo(true)
            )
        );
        LOGGER.info("Los datos se han llenado correctamente");
    }
}
