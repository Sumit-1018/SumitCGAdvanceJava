package in.cg.model;

public class InsurancePlan {

    private String planName;
    private double premium;

    public InsurancePlan() {}

    public InsurancePlan(String planName, double premium) {
        this.planName = planName;
        this.premium = premium;
    }

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

    
}