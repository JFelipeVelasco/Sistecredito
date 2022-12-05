package co.com.sistecredito.certifications.retotecnico.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/frente_web.feature",
        glue = "co.com.sistecredito.certifications.retotecnico.stepsdefinitions",
        snippets = CAMELCASE)

public class FrenteWebRunner {
}
