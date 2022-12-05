package co.com.sistecredito.certifications.retotecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ShoppingCartPage {

    public static final Target FIRST_ITEM_COST = Target.the("First item cost").locatedBy("//body/div[1]/main[1]/div[2]/div[1]/section[1]/form[1]/section[1]/div[1]/div[1]/div[1]/span[1]");
    public static final Target FIRST_ITEM_AMT = Target.the("First item amount").locatedBy("//body/div[1]/main[1]/div[2]/div[1]/section[1]/form[1]/section[1]/div[2]/div[1]/input[1]");
    public static final Target SECOND_ITEM_COST = Target.the("Second item cost").locatedBy("//body/div[1]/main[1]/div[2]/div[1]/section[2]/form[1]/section[1]/div[1]/div[1]/div[1]/span[1]");
    public static final Target SECOND_ITEM_AMT = Target.the("Second item amount").locatedBy("//body/div[1]/main[1]/div[2]/div[1]/section[2]/form[1]/section[1]/div[2]/div[1]/input[1]");
    public static final Target THIRD_ITEM_COST = Target.the("Third item cost").locatedBy("//body/div[1]/main[1]/div[2]/div[1]/section[3]/form[1]/section[1]/div[1]/div[1]/div[1]/span[1]");
    public static final Target THIRD_ITEM_AMT = Target.the("Third item amount").locatedBy("//body/div[1]/main[1]/div[2]/div[1]/section[3]/form[1]/section[1]/div[2]/div[1]/input[1]");
    public static final Target SUBTOTAL = Target.the("Subtotal of shopping cart").locatedBy("//body/div[1]/main[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/p[1]/span[2]");
}
