package co.com.sistecredito.certifications.retotecnico.utils;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class BeforeHook {
    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Felipe");
    }
}
