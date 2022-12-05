package co.com.sistecredito.certifications.retotecnico.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidationCode implements Question<Boolean> {

    private final String codeStatus;
    private Boolean confirmation;

    public ValidationCode(String codeStatus) {
        this.codeStatus = codeStatus;
        this.confirmation = false;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String response = String.valueOf(SerenityRest.lastResponse().getStatusCode());

        if (codeStatus.equals(response)) {
            confirmation = true;
        }

        return confirmation;
    }

    public static ValidationCode match(String codeStatus) {
        return new ValidationCode(codeStatus);
    }
}
