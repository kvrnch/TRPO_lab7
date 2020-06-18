public class User {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String address;
    public String city;
    public String phoneNumber;
    public int country;
    public String state;
    public int postalCode;
    public int dayOfBirth;
    public String monthOfBirth;
    public int yearOfBirth;
    public User(
            String firstName,
            String lastName,
            String email,
            String password,
            int dayOfBirth,
            String monthOfBirth,
            int yearOfBirth,
            String address,
            String city,
            int country,
            String state,
            int postalCode,
            String phoneNumber
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.city = city;
        this.country = country;
        this.state = state;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    }
}
