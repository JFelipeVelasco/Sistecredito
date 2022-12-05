package co.com.sistecredito.certifications.retotecnico.stepsdefinitions;

import co.com.sistecredito.certifications.retotecnico.tasks.ExecutePost;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.Map;

public class PostApiTestStepDefinition {
    @When("^consumes post services$")
    public void consumePostServices(List<Map<String, String>> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(ExecutePost.with(data.get(0)));
    }
}
