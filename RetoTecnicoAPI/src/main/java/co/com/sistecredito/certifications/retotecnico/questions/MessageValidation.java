package co.com.sistecredito.certifications.retotecnico.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MessageValidation implements Question<Boolean> {

    private String message;
    private Boolean match;

    public MessageValidation(String message) {
        this.message = message;
        this.match = false;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String messageResponse = SerenityRest.lastResponse().getBody().jsonPath().getString("name");
        if (messageResponse == null) {
            messageResponse = SerenityRest.lastResponse().getBody().jsonPath().getString("msg");
        }

        if (message.equals(messageResponse)) {
            match = true;
        }

        return match;
    }

    public static MessageValidation verify(String message) {
        return new MessageValidation(message);
    }
}
