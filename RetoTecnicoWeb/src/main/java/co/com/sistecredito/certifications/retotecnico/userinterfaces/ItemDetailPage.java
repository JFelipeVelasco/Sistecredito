package co.com.sistecredito.certifications.retotecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ItemDetailPage {
    public static final Target ADD_CART_BTN = Target.the("Add to shopping cart button").located(By.id("buttonForCustomers"));
    public static final Target PLUS_BUTTON = Target.the("Plus button").located(By.id("testId-stepper-increment-btn"));
    public static final Target CONTINUE_SHOPPING = Target.the("Continue shopping button").locatedBy("//button[contains(text(),'Seguir comprando')]");
    public static final Target GO_SHOPPING_CART_BTN = Target.the("Go to shopping cart button").located(By.id("linkButton"));
}
