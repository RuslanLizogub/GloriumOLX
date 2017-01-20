package settings;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by Ruslan on 17.01.2017.
 */
public class BaseTestSettings {
    @BeforeClass
    protected void init() {
        Driver.init();
    }

    @AfterClass
    protected void cleanup() {
        Driver.get().close();
    }

}
