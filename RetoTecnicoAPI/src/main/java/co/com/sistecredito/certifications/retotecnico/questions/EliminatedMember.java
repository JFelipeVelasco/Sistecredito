package co.com.sistecredito.certifications.retotecnico.questions;

import co.com.sistecredito.certifications.retotecnico.tasks.ExecuteGet;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EliminatedMember implements Question<Boolean> {

    private String id;
    private Boolean match;

    public EliminatedMember(String id) {
        this.id = id;
        this.match = false;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String idResponse = SerenityRest.lastResponse().getBody().jsonPath().getString("member.id");

        if (id.equals(idResponse)) {
            match = true;
        }

        return match;
    }

    public static EliminatedMember verify(String id) {
        return new EliminatedMember(id);
    }
}
