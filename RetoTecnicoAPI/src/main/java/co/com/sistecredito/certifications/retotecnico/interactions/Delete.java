package co.com.sistecredito.certifications.retotecnico.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Delete extends RestInteraction {

    private final String resource;

    public Delete (String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().delete(as(actor).resolve(resource)).then().log().all();
    }

    public static Delete resource(String resource) {
        return instrumented(Delete.class, resource);
    }

}
