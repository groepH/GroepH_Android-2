package com.webcomrades.demo.model;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TripUser implements Serializable {

    private int id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String phoneNumber;

    private char gender;

    private String email;

    private String password;

    private String role;

    private Date dateRegistered;
    //@Column(name="isAdmin", nullable = false)
    //private Boolean isAdmin;


    private Address address;


    private boolean accountNonExpired;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private boolean accountNonLocked;

    /*
        @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Trip> trips = new ArrayList<Car>();
     */


    public TripUser() {
    }

    public TripUser(String firstName, String lastName, Date dateOfBirth, String phoneNumber, char gender, String email, String password, Address address, Date dateRegistered, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.address = address;
        this.dateRegistered = dateRegistered;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isAdmin(){
        if(role.equals("ROLE_ADMIN")){
            return  true;
        }
        return false;
    }





    @Override
    public int hashCode() {
        int result = 31 * (getFirstName() != null ? getFirstName().hashCode() : 0);
        result += 31 * (getLastName() != null ? getLastName().hashCode() : 0);
        result += 31 * (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result += 17 * (getPhoneNumber() != null ? phoneNumber.hashCode() : 0);
        result += 31 * (getEmail() != null ? getEmail().hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TripUser user = (TripUser) obj;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dob = "";
        String userdob = "";

        try {
            dob = sdf.format(dateOfBirth);
            userdob = sdf.format(user.dateOfBirth);
        } catch (NullPointerException e) {
            //TODO hier nog deftige exception message zetten...
        }

        return !(firstName != null ? !firstName.equals(user.getFirstName()) : user.getFirstName() != null)
                && !(lastName != null ? !lastName.equals(user.getLastName()) : user.getLastName() != null)
                && !(dob != null ? !dob.equals(userdob) : userdob != null)
                && !(email != null ? !email.equals(user.getEmail()) : user.getEmail() != null);
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " ";
    }


}