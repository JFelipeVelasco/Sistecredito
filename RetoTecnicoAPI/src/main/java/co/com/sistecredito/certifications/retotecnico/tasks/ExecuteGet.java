package co.com.sistecredito.certifications.retotecnico.tasks;

import co.com.sistecredito.certifications.retotecnico.interactions.Get;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

import static co.com.sistecredito.certifications.retotecnico.utils.RestService.PATH;
import static co.com.sistecredito.certifications.retotecnico.utils.RestService.ID;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteGet implements Task {

    private final Map<String, String> data;

    public ExecuteGet(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Get.resource(PATH + "/" + data.get(ID)).with(requestSpecification -> requestSpecification
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .header("Authorization", "Basic YWRtaW46YWRtaW4=")
                .header("login", "admin")
                .header("password", "admin")
        ));
    }

    public static ExecuteGet with(Map<String, String> data) {
        return instrumented(ExecuteGet.class, data);
    }
}
