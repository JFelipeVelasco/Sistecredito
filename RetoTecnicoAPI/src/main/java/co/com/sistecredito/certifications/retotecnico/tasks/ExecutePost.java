package co.com.sistecredito.certifications.retotecnico.tasks;

import co.com.sistecredito.certifications.retotecnico.utils.SetBody;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static co.com.sistecredito.certifications.retotecnico.utils.RestService.PATH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecutePost implements Task {

    private final Map<String, String> data;

    public ExecutePost(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.to(PATH).with(requestSpecification -> requestSpecification
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .header("Authorization", "Basic YWRtaW46YWRtaW4=")
                .header("login", "admin")
                .header("password", "admin")
                .body(new SetBody().body(data))
        ));
    }

    public static ExecutePost with(Map<String, String> data) {
        return instrumented(ExecutePost.class, data);
    }
}
