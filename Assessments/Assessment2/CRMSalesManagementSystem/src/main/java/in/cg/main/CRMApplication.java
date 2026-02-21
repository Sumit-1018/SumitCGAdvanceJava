package in.cg.main;

import in.cg.entities.Address;
import in.cg.services.*;

import java.util.*;

public class CRMApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        LeadService leadService = new LeadService();
        OrderService orderService = new OrderService();

        while (true) {

            System.out.println("\n------ CRM MENU ------");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address to Customer");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead to Employee");
            System.out.println("5. Convert Lead to Customer");
            System.out.println("6. Place Order");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    customerService.registerCustomer(cname, email, phone);
                    break;

                case 2:
                    System.out.print("Customer ID: ");
                    Long cid = sc.nextLong();
                    sc.nextLine();

                    Address address = new Address();
                    System.out.print("Street: ");
                    address.setStreet(sc.nextLine());
                    System.out.print("City: ");
                    address.setCity(sc.nextLine());
                    System.out.print("State: ");
                    address.setState(sc.nextLine());
                    System.out.print("Zip: ");
                    address.setZipCode(sc.nextLine());

                    customerService.addAddressToCustomer(cid, address);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Lead Name: ");
                    String lname = sc.nextLine();
                    System.out.print("Source: ");
                    String source = sc.nextLine();
                    System.out.print("Contact Info: ");
                    String contact = sc.nextLine();

                    leadService.createLead(lname, source, contact);
                    break;

                case 4:
                    System.out.print("Lead ID: ");
                    Long leadId = sc.nextLong();
                    System.out.print("Employee ID: ");
                    Long empId = sc.nextLong();

                    leadService.assignLeadToEmployee(leadId, empId);
                    break;

                case 5:
                    System.out.print("Lead ID to convert: ");
                    Long lid = sc.nextLong();

                    leadService.convertLeadToCustomer(lid);
                    break;

                case 6:
                    System.out.print("Customer ID: ");
                    Long customerId = sc.nextLong();

                    System.out.print("Number of products: ");
                    int n = sc.nextInt();

                    List<Long> productIds = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Product ID: ");
                        productIds.add(sc.nextLong());
                    }

                    orderService.placeOrder(customerId, productIds);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}