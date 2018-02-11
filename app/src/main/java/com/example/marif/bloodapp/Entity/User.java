package com.example.marif.bloodapp.Entity;

/**
 * Created by M. Arif on 12/13/2017.
 */

public class User {
    String Email;
    String FirstName;
    String LastName;
    String Password;
    String PhoneNum;
    String City;
    String DateOfBirth;
    String BloodGroup;
    double weight;
    double height;

    public User(String firstName, String lastName,String email,String phoneNum,  String password,  String city,String dob,String bg,double h,double w) {
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        PhoneNum = phoneNum;
        City = city;
        DateOfBirth = dob;
        BloodGroup = bg;
        weight = w;
        height = h;
    }

    public User()
    {

    }
    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }



    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
