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

        String fPrice = FIRST_ITEM_COST.resolveFor(actor).getText().trim();
        fPrice = fPrice.replaceAll("\\D+", "");
        System.out.println("STRING" + fPrice);
        int firstPrice;
        firstPrice = Integer.parseInt(fPrice)
                * Integer.parseInt(FIRST_ITEM_AMT.resolveFor(actor).getValue());

        System.out.println(firstPrice);

        String sPrice = SECOND_ITEM_COST.resolveFor(actor).getText().trim();
        sPrice = sPrice.replaceAll("\\D+", "");
        int secondPrice;
        secondPrice = Integer.parseInt(sPrice)
                * Integer.parseInt(SECOND_ITEM_AMT.resolveFor(actor).getValue());

        System.out.println(secondPrice);

        String tPrice = THIRD_ITEM_COST.resolveFor(actor).getText().trim();
        tPrice = tPrice.replaceAll("\\D+", "");
        int thirdPrice;
        thirdPrice = Integer.parseInt(tPrice)
                * Integer.parseInt(THIRD_ITEM_AMT.resolveFor(actor).getValue());

        System.out.println(thirdPrice);

        int finalPrice = firstPrice + secondPrice + thirdPrice;
        String finalStringPrice = String.valueOf(finalPrice);

        System.out.println(finalPrice);
        System.out.println("STRING" + finalStringPrice);

        System.out.println("SUBTOTAL" + SUBTOTAL.resolveFor(actor).getText().replaceAll("\\D+", ""));

        if (finalStringPrice.equals(SUBTOTAL.resolveFor(actor).getText().replaceAll("\\D+", "")))
            answer = true;

        return answer;
    }

    public static VerifyShopping cart() {
        return new VerifyShopping();
    }
}
