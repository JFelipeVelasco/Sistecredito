package co.com.sistecredito.certifications.retotecnico.tasks;

import co.com.sistecredito.certifications.retotecnico.utils.SetBody;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

import static co.com.sistecredito.certifications.retotecnico.utils.RestService.ID;
import static co.com.sistecredito.certifications.retotecnico.utils.RestService.PATH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecutePut implements Task {

    private final Map<String, String> data;

    public ExecutePut(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Put.to(PATH + "/" + data.get(ID)).with(requestSpecification -> requestSpecification
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .header("Authorization", "Basic YWRtaW46YWRtaW4=")
                .header("login", "admin")
                .header("password", "admin")
                .body(new SetBody().body(data))
        ));
    }

    public static ExecutePut with(Map<String, String> data) {
        return instrumented(ExecutePut.class, data);
    }
}
