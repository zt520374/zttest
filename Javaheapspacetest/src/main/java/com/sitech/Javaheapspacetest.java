package com.sitech;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Javaheapspacetest {

    public static void main(String s[]){
        Set<MyObject> objects = new LinkedHashSet<MyObject>();
        objects.add(new MyObject());
        objects.add(new MyObject());
        objects.add(new MyObject());
        System.out.println(objects.size());
        while(true){
            objects.add(new MyObject());
        }
    }


}



class MyObject{
    //设置默认数组长度为99999更快的发生OutOfMemoryError
    List<String> list = new ArrayList<String>();
}
