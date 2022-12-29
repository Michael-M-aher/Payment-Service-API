package com.m_code.Fawry.Services.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m_code.Fawry.RuntimeData.DataStoreRuntime;
import com.m_code.Fawry.Services.AbstractService.AbstractService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    DataStoreRuntime dts;

    @GetMapping("/search")
    public ResponseEntity<ArrayList<String>> search(@RequestParam(name = "name") String name) {
        ArrayList<String> filteredBySearch = new ArrayList<String>();
        ArrayList<AbstractService> services = dts.getServices();
        for (AbstractService service : services) {
            if (service.getServiceProviderName().toLowerCase().contains(name.toLowerCase())) {
                filteredBySearch.add(service.getServiceProviderName());
            }
        }
        System.out.println(name);
        return ResponseEntity.ok(filteredBySearch);
    }
}
