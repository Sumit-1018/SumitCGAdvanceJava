package in.cg.model;

public class Application {

    private String customerName;
    private String planName;
    private String status;

    public Application() {}

    public Application(String customerName, String planName, String status) {
        this.customerName = customerName;
        this.planName = planName;
        this.status = status;
    }

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}