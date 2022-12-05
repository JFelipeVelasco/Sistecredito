package co.com.sistecredito.certifications.retotecnico.stepsdefinitions;

import co.com.sistecredito.certifications.retotecnico.questions.InformationValidation;
import co.com.sistecredito.certifications.retotecnico.questions.MessageValidation;
import co.com.sistecredito.certifications.retotecnico.tasks.ExecutePut;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PutApiTestStepDefinition {
    @When("^the user consumes PUT services$")
    public void theUserConsumePUTServices(List<Map<String, String>> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(ExecutePut.with(data.get(0)));
    }

    @And("and verify the update information$")
    public void andVerifyTheUpdateInformation(List<Map<String, String>> data) {

        OnStage.theActorInTheSpotlight().should(seeThat(InformationValidation.verify(data.get(0).get("name"), data.get(0).get("gender")), Matchers.is(true)));
    }
}
