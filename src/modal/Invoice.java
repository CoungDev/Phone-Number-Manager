package modal;

public class Invoice {
	private String id;
	private String name;
	private String phoneNumber;
	private double totalPayment;
	public Invoice(String id, String name, String phoneNumber, double totalPayment) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.totalPayment = totalPayment;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}
	
	
}
