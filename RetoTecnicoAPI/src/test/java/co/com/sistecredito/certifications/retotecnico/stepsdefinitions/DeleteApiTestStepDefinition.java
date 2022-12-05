package co.com.sistecredito.certifications.retotecnico.stepsdefinitions;

import co.com.sistecredito.certifications.retotecnico.questions.EliminatedMember;
import co.com.sistecredito.certifications.retotecnico.questions.InformationValidation;
import co.com.sistecredito.certifications.retotecnico.tasks.ExecuteDelete;
import co.com.sistecredito.certifications.retotecnico.tasks.ExecuteGet;
import co.com.sistecredito.certifications.retotecnico.tasks.ExecutePost;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class DeleteApiTestStepDefinition {
    @When("^the user consumes DELETE services$")
    public void theUserConsumesDELETEServices(List<Map<String, String>> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(ExecuteDelete.with(data.get(0)));
    }

    @And("the user verify the eliminated member$")
    public void theUserVerifyTheEliminatedMember(List<Map<String, String>> data) {

        OnStage.theActorInTheSpotlight().attemptsTo(ExecuteGet.with(data.get(0)));
        OnStage.theActorInTheSpotlight().should(seeThat(EliminatedMember.verify(data.get(0).get("id")), Matchers.is(false)));
    }
}
