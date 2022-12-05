package co.com.sistecredito.certifications.retotecnico.stepsdefinitions;

import co.com.sistecredito.certifications.retotecnico.questions.VerifyShopping;
import co.com.sistecredito.certifications.retotecnico.tasks.AddItemsTo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class FrenteWebStepDefinition {

    @Managed(driver = "chrome")
    private WebDriver browser;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(browser)));
        OnStage.theActorCalled("Felipe");
    }

    @Given("^the user go to the homepage$")
    public void theUserGoToTheHomepage() {

        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.falabella.com.co/falabella-co"));
    }

    @When("^select the three items$")
    public void selectTheThreeItems() {

        SearchContext shadow = browser.findElement(By.cssSelector("div.airship-html-prompt-shadow")).getShadowRoot();
        shadow.findElement(By.cssSelector("button.airship-btn-deny")).click();

        OnStage.theActorInTheSpotlight().attemptsTo(AddItemsTo.cart());
    }

    @Then("^verify the shopping cart total$")
    public void verifyTheShoppingCartTotal() {

        OnStage.theActorInTheSpotlight().should(seeThat(VerifyShopping.cart(), Matchers.is(true)));
    }
}