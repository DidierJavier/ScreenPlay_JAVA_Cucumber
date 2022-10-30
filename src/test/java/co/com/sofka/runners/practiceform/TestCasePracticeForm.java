package co.com.sofka.runners.practiceform;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/practiceform/practiceForm.feature"},
        glue = {"co/com/sofka/stepdefinitions/practiceform"},
        tags = ""
)
public class TestCasePracticeForm {
}

