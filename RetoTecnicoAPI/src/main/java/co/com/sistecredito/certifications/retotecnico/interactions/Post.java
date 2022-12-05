package co.com.sistecredito.certifications.retotecnico.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Post extends RestInteraction {

    private final String resource;

    public Post(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().post(as(actor).resolve(resource)).then().log().all();
    }

    public static Post resource(String resource) {
        return instrumented(Post.class, resource);
    }

}
