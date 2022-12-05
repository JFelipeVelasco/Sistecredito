package co.com.sistecredito.certifications.retotecnico.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sistecredito.certifications.retotecnico.userinterfaces.HomePage.*;
import static co.com.sistecredito.certifications.retotecnico.userinterfaces.HomePage.HOME_ITEM;
import static co.com.sistecredito.certifications.retotecnico.userinterfaces.ItemDetailPage.*;
import static co.com.sistecredito.certifications.retotecnico.userinterfaces.ItemsPage.RND_ITEM;

public class AddItemsTo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        WaitUntil.the(BTN_CATEGORIES, WebElementStateMatchers.isClickable()).forNoMoreThan(3).seconds();
        actor.attemptsTo(Click.on(BTN_CATEGORIES),
                Click.on(FURNITURE_CATE),
                Click.on(FURNITURE_ITEM),
                Click.on(RND_ITEM),
                Click.on(ADD_CART_BTN));
        WaitUntil.the(PLUS_BUTTON, WebElementStateMatchers.isClickable()).forNoMoreThan(3).seconds();

        int numberOne = (int) (Math.random() * 5);

        while (numberOne > 0) {
            actor.attemptsTo(Click.on(PLUS_BUTTON));
            numberOne--;
        }

        actor.attemptsTo(Click.on(CONTINUE_SHOPPING));
        WaitUntil.the(BTN_CATEGORIES, WebElementStateMatchers.isClickable()).forNoMoreThan(3).seconds();
        actor.attemptsTo(Click.on(BTN_CATEGORIES),
                Click.on(SPORTS_CATE),
                Click.on(SPORTS_ITEM),
                Click.on(RND_ITEM),
                Click.on(ADD_CART_BTN));
        WaitUntil.the(PLUS_BUTTON, WebElementStateMatchers.isClickable()).forNoMoreThan(3).seconds();

        int numberTwo = (int) (Math.random() * 5);

        while (numberTwo > 0) {
            actor.attemptsTo(Click.on(PLUS_BUTTON));
            numberTwo--;
        }

        actor.attemptsTo(Click.on(CONTINUE_SHOPPING));
        WaitUntil.the(BTN_CATEGORIES, WebElementStateMatchers.isClickable()).forNoMoreThan(3).seconds();
        actor.attemptsTo(Click.on(BTN_CATEGORIES),
                Click.on(HOME_CATE),
                Click.on(HOME_ITEM),
                Click.on(RND_ITEM),
                Click.on(ADD_CART_BTN));
        WaitUntil.the(PLUS_BUTTON, WebElementStateMatchers.isClickable()).forNoMoreThan(3).seconds();

        int numberThree = (int) (Math.random() * 5);

        while (numberThree > 0) {
            actor.attemptsTo(Click.on(PLUS_BUTTON));
            numberThree--;
        }
    }

    public static AddItemsTo cart() {
        return Tasks.instrumented(AddItemsTo.class);
    }
}
