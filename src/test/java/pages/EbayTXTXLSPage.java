package pages;

import java.util.ResourceBundle;
import static java.util.ResourceBundle.getBundle;

public class EbayTXTXLSPage extends Page {
    private final ResourceBundle resourceBundle;
    private final String url;
    private final String explicitTime;
    public final String ebayUrl;
    public final String ebayTextbookNameLoc;
    public final String ebayTextbookPriceLoc;


    public EbayTXTXLSPage() {
        resourceBundle = getBundle("pages.EbayTXTXLSPage");
        url = this.getResourceBundle().getString("url");
        explicitTime = this.getResourceBundle().getString("explicitTime");
        ebayUrl = this.getResourceBundle().getString("ebayUrl");
        ebayTextbookNameLoc = this.getResourceBundle().getString("ebayTextbookNameLoc");
        ebayTextbookPriceLoc = this.getResourceBundle().getString("ebayTextbookPriceLoc");

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

