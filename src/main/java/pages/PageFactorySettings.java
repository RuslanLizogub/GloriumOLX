package pages;

import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ruslan on 17.01.2017.
 */
public class PageFactorySettings {
    protected PageFactorySettings() {
        PageFactory.initElements(settings.Driver.get(), this);
    }
}
