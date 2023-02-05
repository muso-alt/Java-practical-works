package OOP.AddressBook;

import java.sql.Date;

public class Person {
    public String PersonName;
    public String PersongLastName;
    public Address PersonsAdress;
    public int BirthdayDate;

    public Person(String name, String lastName, int birthday, Address address){
        PersonName = name;
        PersongLastName = lastName;
        PersonsAdress = address;
        BirthdayDate = birthday;
    }
}

