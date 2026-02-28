package in.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.cg.model.Customer;
import in.cg.service.InsuranceService;

@Controller
public class InsuranceController {

    @Autowired
    private InsuranceService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer, Model model) {
        service.registerCustomer(customer);
        model.addAttribute("msg", "Customer Registered Successfully!");
        return "success";
    }

    @GetMapping("/plans")
    public String showPlans(Model model) {
        model.addAttribute("plans", service.getAllPlans());
        return "plans";
    }

    @PostMapping("/apply")
    public String applyPlan(@RequestParam("name") String name,
                            @RequestParam("planName") String planName,
                            Model model) {

        service.applyForPlan(name, planName);
        model.addAttribute("msg", "Application Submitted Successfully!");
        return "success";
    }

    @GetMapping("/status")
    public String showStatusPage() {
        return "status";
    }

    @PostMapping("/checkStatus")
    public String checkStatus(@RequestParam("name") String name, Model model) {
        String status = service.checkStatus(name);
        model.addAttribute("status", status);
        return "statusResult";
    }
}