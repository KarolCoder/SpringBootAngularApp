package com.kgodlewski.app.controllers;

import com.kgodlewski.app.entities.Location;
import com.kgodlewski.app.repository.LocationRepository;
import com.kgodlewski.app.service.LocationService;
import com.kgodlewski.app.util.EmailUtil;
import com.kgodlewski.app.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    LocationService service;

    @Autowired
    LocationRepository repository;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    ReportUtil reportUtil;

    @Autowired
    ServletContext servletContext;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location locationSaved = service.saveLocation(location);
        String msg = "Location saved with id: " + locationSaved.getId();
        modelMap.addAttribute("msg", msg);
        emailUtil.sendEmail("testestowykg@gmail.com", "LocationSaved", "Location saved successfully and about to return a response");
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> allLocations = service.getAllLocations();
        System.out.println(allLocations);
        modelMap.addAttribute("allLocations", allLocations);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam int id, ModelMap modelMap) {
//        Location location = service.getLocationById(id);
        Location location = new Location();
        location.setId(id);
        service.deleteLocation(location);
        List<Location> allLocations = service.getAllLocations();
        modelMap.addAttribute("allLocations", allLocations);
        return "displayLocations";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam int id, ModelMap modelMap) {
        Location location = service.getLocationById(id);
        modelMap.addAttribute("location", location);
        return "updateLocation";
    }

    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        service.updateLocation(location);
        List<Location> allLocations = service.getAllLocations();
        modelMap.addAttribute("allLocations", allLocations);
        return "displayLocations";
    }
    @RequestMapping("/generateReport")
    public String generateReport(){
        List<Object[]> data = repository.findTypeAndTypeCount();
        String path = servletContext.getRealPath("/");
        reportUtil.generatePieChart(path,data);
        return "report";
    }

}
