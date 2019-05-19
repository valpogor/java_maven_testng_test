package pages;

import web.driver.factory.DriverFactory;
import java.util.ResourceBundle;

public abstract class Page extends DriverFactory {
    public abstract ResourceBundle getResourceBundle();
    public abstract String getUrl();
    public abstract int getExplicitTime();
}
