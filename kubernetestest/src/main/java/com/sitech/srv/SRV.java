package com.sitech.srv;

import com.alibaba.fastjson.JSONObject;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.util.Config;

import java.io.IOException;

public class SRV {

    public static JSONObject getPods(){
        try {

//            ApiClient client = Config.defaultClient();
//            Configuration.getDefaultApiClient();
            ApiClient client = Config.fromConfig("F:/kubernetes.yaml");
            Configuration.setDefaultApiClient(client);
            CoreV1Api api = new CoreV1Api();
            V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
            System.out.println(list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        getPods();
    }
}
