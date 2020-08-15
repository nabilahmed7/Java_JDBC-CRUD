public class Person {
    String firstName,lastName,address,mobileNumber,id;

    public Person() {
    }

    public Person(String firstName, String lastName, String address, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }
    public void PersonShow(String id, String firstName, String lastName, String address, String mobileNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    @Override
    public String toString() {
        return  "Person Id = "+ id +
                "\n FirstName = " + firstName +
                "\n LastName = " + lastName +
                "\n Address = " + address +
                "\n Mobile Number = " + mobileNumber + "\n";
    }
}
