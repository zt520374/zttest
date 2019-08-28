package com.sitech.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Commons {


    public static String APP_NAME;


    public static String APP_VERSION;

    @Value("${appname}")
    public void setAppName(String appName) {
        APP_NAME = appName;
    }

    @Value("${appversion}")
    public void setAppVersion(String appVersion) {
        APP_VERSION = appVersion;
    }


}
