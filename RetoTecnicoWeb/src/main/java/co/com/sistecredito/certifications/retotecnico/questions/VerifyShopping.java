package co.com.sistecredito.certifications.retotecnico.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sistecredito.certifications.retotecnico.userinterfaces.ItemDetailPage.GO_SHOPPING_CART_BTN;
import static co.com.sistecredito.certifications.retotecnico.userinterfaces.ShoppingCartPage.*;

public class VerifyShopping implements Question<Boolean> {

    private Boolean answer;

    public VerifyShopping() {
        this.answer = false;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        WaitUntil.the(GO_SHOPPING_CART_BTN, WebElementStateMatchers.isClickable()).forNoMoreThan(3).seconds();
        actor.attemptsTo(Click.on(GO_SHOPPING_CART_BTN));

        float firstPrice;
        firstPrice = Float.parseFloat(FIRST_ITEM_COST.resolveFor(actor).getText().trim())
                * Float.parseFloat(FIRST_ITEM_AMT.resolveFor(actor).getValue());

        float secondPrice;
        secondPrice = Float.parseFloat(SECOND_ITEM_COST.resolveFor(actor).getText().trim())
                * Float.parseFloat(SECOND_ITEM_AMT.resolveFor(actor).getValue());

        float thirdPrice;
        thirdPrice = Float.parseFloat(THIRD_ITEM_COST.resolveFor(actor).getText().trim())
                * Float.parseFloat(THIRD_ITEM_AMT.resolveFor(actor).getValue());

        double finalPrice = firstPrice + secondPrice + thirdPrice;
        String finalStringPrice = "$ " + finalPrice;

        if (finalStringPrice.equals(SUBTOTAL.resolveFor(actor).getText()))
            answer = true;

        return answer;
    }

    public static VerifyShopping cart() {
        return new VerifyShopping();
    }
}
