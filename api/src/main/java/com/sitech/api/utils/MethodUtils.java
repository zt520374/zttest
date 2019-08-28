package com.sitech.api.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MethodUtils {

    public static String getIp(){

        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return  inetAddress.getHostAddress().toString();
    }
}
