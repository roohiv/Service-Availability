package com.services.util;


import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceInstanceUtil {

    public static Map<String, Integer> getSortedInstanceMap(Map<String, Integer> servicesMap) {
        Map<String, Integer> sortedServiceMap = new TreeMap<>(
                (instance1, instance2) -> {
                    if (getInstanceNumber(instance1) < getInstanceNumber(instance2)) {
                        return -1;
                    } else {
                        return 1;
                    }
                });
        sortedServiceMap.putAll(servicesMap);
        return sortedServiceMap;

    }


    public static int getInstanceNumber(String instanceId) {
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(instanceId);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }
}
