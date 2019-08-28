package com.sitech;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sitech.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@RestController
public class Controller {


    @Autowired
    RestTemplate restT;

    @Autowired
    HttpServletRequest httpServletRequest;


    @RequestMapping("/*" )
     public JSONObject request(@RequestBody JSONObject jsondata){
        //通过getHeaderNames获得所有头名字的Enumeration集合

        Enumeration<String> headNames = httpServletRequest.getHeaderNames();
        while(headNames.hasMoreElements()){
            String headName = headNames.nextElement();
        }

        JSONObject returnData = new JSONObject();
        String data = Commons.APP_NAME + "_" + Commons.APP_VERSION;
        String requestdata = jsondata.getString("next_srv");
        if(null != requestdata && !"".equals(requestdata)){
            JSONObject req = new JSONObject();
            String requrl = null;
            String reqdata = "";
            if(requestdata.contains(",")){
                requrl = requestdata.substring(0,requestdata.indexOf(","));
                reqdata = requestdata.substring(requestdata.indexOf(",") +1);
            }else{
                requrl = requestdata;
            }
            if(!requrl.contains(":")){
                requrl = requrl + ":8080";
            }
            req.put("next_srv",reqdata);
//            String result = restT.getForObject("http://" + requrl,String.class,req.toString());
            String result =restT.postForObject("http://" + requrl  ,req,String.class);
//            String result = MyRestTemplate.restTemplatePost("http://" + requrl  ,req.toString());
//            String result = method.postJson("http://" + requrl  ,req.toString());
            String resultdata = "";
            if(null != result){
                resultdata = JSON.parseObject(result).getString("result");
            }
            data = data + "," +resultdata;
        }
        returnData.put("result", data);
        return returnData;
     }


    @Bean
    public RestTemplate getRest() {
        return new RestTemplate();
    }

}
