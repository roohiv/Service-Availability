package com.services.controller;


import com.services.manager.ServiceInstanceManager;
import com.services.model.ServiceInstanceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PingController {

    @Autowired
    private ServiceInstanceManager serviceInstanceManager;

    @Autowired
    private ServiceInstanceBean serviceInstanceBean;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView firstPage() {
        return new ModelAndView("ping", "servicesNameList", serviceInstanceBean.getAllServicesName());

    }

    @RequestMapping(value = "/serviceping", method = RequestMethod.GET)
    public ModelAndView getServicePing(@RequestParam("services") String key) {
        serviceInstanceBean = serviceInstanceManager.populateServiceInstanceBean(key);
        return new ModelAndView("ping","serviceInstance", serviceInstanceBean);

    }

}
