package in.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.cg.model.Application;
import in.cg.model.Customer;
import in.cg.model.InsurancePlan;

@Service
public class InsuranceService {

    private List<Customer> customers = new ArrayList<>();
    private List<Application> applications = new ArrayList<>();

    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<InsurancePlan> getAllPlans() {
        List<InsurancePlan> plans = new ArrayList<>();
        plans.add(new InsurancePlan("Basic Health Plan", 5000));
        plans.add(new InsurancePlan("Premium Health Plan", 10000));
        plans.add(new InsurancePlan("Family Coverage Plan", 15000));
        return plans;
    }

    public void applyForPlan(String name, String planName) {
        Application app = new Application(name, planName, "Pending");
        applications.add(app);
    }

    public String checkStatus(String name) {
        for (Application app : applications) {
            if (app.getCustomerName().equalsIgnoreCase(name)) {
                return app.getStatus();
            }
        }
        return "No Application Found";
    }
}