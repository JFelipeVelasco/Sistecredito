package co.com.sistecredito.certifications.retotecnico.stepsdefinitions;

import co.com.sistecredito.certifications.retotecnico.questions.MessageValidation;
import co.com.sistecredito.certifications.retotecnico.questions.ValidationCode;
import co.com.sistecredito.certifications.retotecnico.tasks.ExecuteGet;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static co.com.sistecredito.certifications.retotecnico.utils.RestService.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class RestApiTestStepDefinition {

    @Given("^the user wants to call the service$")
    public void theUserWantsToCallTheService() {
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(BASE_URL));
    }

    @When("^the user consumes get services$")
    public void theUserConsumesGetServices(List<Map<String, String>> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(ExecuteGet.with(data.get(0)));
    }

    @Then("^the user will see the correct response$")
    public void theUserWillSeeTheCorrectResponse(List<Map<String, String>> data) {

        //OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(response -> response.statusCode(data.get(0).get("response"))));
        OnStage.theActorInTheSpotlight().should(seeThat(ValidationCode.match(data.get(0).get("response")), Matchers.is(true)));
    }

    @And("^the user see the correct message$")
    public void theUserSeeTheCorrectMessage(List<Map<String, String>> data) {
        OnStage.theActorInTheSpotlight().should(seeThat(MessageValidation.verify(data.get(0).get("message")), Matchers.is(true)));
    }
}
