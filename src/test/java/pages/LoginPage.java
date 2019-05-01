package pages;

import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

public class LoginPage extends Page {
    private final ResourceBundle resourceBundle;
    private final String url;
    private final String explicitTime;
    public final String googleBtnSearchLoc;
    public final String jsonendpoint;
    public final String foxPageLoc;
    public final String foxPageHomeLoc;
    public final String aolVideoBtnLoc;
    public final String urlAol;
    public final String urlHalfEbay;

    public LoginPage() {
        resourceBundle = getBundle("pages.LoginPage");
        url = this.getResourceBundle().getString("url");
        explicitTime = this.getResourceBundle().getString("explicitTime");
        googleBtnSearchLoc = this.getResourceBundle().getString("googleBtnSearchLoc");
        jsonendpoint = this.getResourceBundle().getString("jsonendpoint");
        foxPageLoc = this.getResourceBundle().getString("foxPageLoc");
        foxPageHomeLoc = this.getResourceBundle().getString("foxPageHomeLoc");
        aolVideoBtnLoc = this.getResourceBundle().getString("aolVideoBtnLoc");
        urlAol = this.getResourceBundle().getString("urlAol");
        urlHalfEbay = this.getResourceBundle().getString("urlHalfEbay");

    }
    @Override
    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
    @Override
    public String getUrl() {
        return url;
    }
    @Override
    public int getExplicitTime() {
        int expTime = Integer.parseInt(explicitTime);
        return expTime;
    }
}

