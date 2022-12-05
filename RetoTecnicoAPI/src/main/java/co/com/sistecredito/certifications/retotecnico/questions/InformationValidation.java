package co.com.sistecredito.certifications.retotecnico.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class InformationValidation implements Question<Boolean> {

    private String name;
    private String gender;
    private Boolean match;

    public InformationValidation(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.match = false;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String nameResponse = SerenityRest.lastResponse().getBody().jsonPath().getString("member.name");
        String genderResponse = SerenityRest.lastResponse().getBody().jsonPath().getString("member.gender");

        if (nameResponse != null) {
            if (name.equals(nameResponse) && gender.equals(genderResponse)) {
                match = true;
            }
        } else {
            match = true;
        }
        return match;
    }

    public static InformationValidation verify(String name, String gender) {
        return new InformationValidation(name, gender);
    }
}
