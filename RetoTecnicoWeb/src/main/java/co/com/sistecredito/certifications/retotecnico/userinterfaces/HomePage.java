package co.com.sistecredito.certifications.retotecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target BTN_CATEGORIES = Target.the("Categories").located(By.id("testId-HamburgerBtn-toggle"));
    public static final Target FURNITURE_CATE = Target.the("Bedroom category").locatedBy("//p[contains(text(),'Dormitorio')]");
    public static final Target SPORTS_CATE = Target.the("Sports category").locatedBy("//p[contains(text(),'Deportes')]");
    public static final Target CLOTHING_CATE = Target.the("Clothing category").locatedBy("//p[contains(text(),'Vestuario infantil')]");
    public static final Target FURNITURE_ITEM = Target.the("Bedroom item").locatedBy("//a[contains(text(),'Camas')]");
    public static final Target SPORTS_ITEM = Target.the("Sports item").locatedBy("//a[contains(text(),'Camisetas')]");
    public static final Target CLOTHING_ITEM = Target.the("Clothing item").locatedBy("//a[contains(text(),'Baberos')]");
}
