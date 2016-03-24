package io.github.marcondesnjr.calconi.xml;

import java.util.HashMap;

/**
 * Created by Junior on 23/03/2016.
 */
public class Util {

    public static HashMap<String,String> StringToHash(String str){
        String[] atrr = str.split("&");
        HashMap<String,String> hash = new HashMap<>();
        for (String atr: atrr) {
            String[] keyValue = atr.split("=");
            hash.put(keyValue[0],keyValue[1]);
        }
        return hash;
    }

}
