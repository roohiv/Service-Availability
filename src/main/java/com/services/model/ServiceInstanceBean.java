package com.services.model;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceInstanceBean {

    private String requestedServiceName;
    private int expectedServiceInstances;
    private int actualServiceInstances;
    private Set<String> allServicesName;
    private String serviceState;
    private String requestedServiceUrl;

    private Map<String, Integer> serviceInstanceMap;


    public enum ServiceName {
       //add all the service name here
        servicename;

    }

    public ServiceInstanceBean() {
        allServicesName = getEnumServicesSet();

    }

    public Map<String, Integer> getServiceInstanceMap() {
        return serviceInstanceMap;
    }

    public void setServiceInstanceMap(Map<String, Integer> serviceInstanceMap) {
        this.serviceInstanceMap = serviceInstanceMap;
    }

    public String getRequestedServiceName() {
        return requestedServiceName;
    }

    public void setRequestedServiceName(String requestedServiceName) {
        this.requestedServiceName = requestedServiceName;
    }


    public int getExpectedServiceInstances() {
        return expectedServiceInstances;
    }

    public void setExpectedServiceInstances(int expectedServiceInstances) {
        this.expectedServiceInstances = expectedServiceInstances;
    }


    public int getActualServiceInstances() {
        return actualServiceInstances;
    }

    public void setActualServiceInstances(int actualServiceInstances) {
        this.actualServiceInstances = actualServiceInstances;
    }

    public Set<String> getEnumServicesSet() {
        return Stream.of(ServiceName.values())
                .map(ServiceName::name)
                .collect(Collectors.toCollection(TreeSet::new));

    }

    public Set<String> getAllServicesName() {
        return allServicesName;
    }

    public void setAllServicesName(Set<String> allServicesName) {
        this.allServicesName = allServicesName;
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public String getRequestedServiceUrl() {
        return requestedServiceUrl;
    }

    public void setRequestedServiceUrl(String requestedServiceUrl) {
        this.requestedServiceUrl = requestedServiceUrl;
    }

}
