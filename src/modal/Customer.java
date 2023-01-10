package modal;

public class Customer {
  private String id;
  private String name;
  private String phoneNumber;
  private String birthday;
  private String gender;
  private String address;

  public Customer(String id, String name, String birthday, String gender, String address, String phoneNumber) {
    this.id = id;
    this.name = name;
    this.birthday = birthday;
    this.gender = gender;
    this.address = address;
    this.phoneNumber = phoneNumber;
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

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
