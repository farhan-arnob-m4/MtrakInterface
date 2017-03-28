package com.example.metafour.mtrakinterface.model;

/**
 * Created by farhan-arnob-m4 on 3/24/17.
 */

public class SiteDetails {
    private String siteName = "Pfizer Australia";
    private String siteCode = "iTrakII - it2930";

    public SiteDetails(String siteCode, String siteName) {
        this.siteCode = siteCode;
        this.siteName = siteName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }
}
