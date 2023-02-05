package OOP.AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyAddressBook {

    private Person[] _persons;
    Scanner reader;

    public void Initialize(){

        reader = new Scanner(System.in);

        System.out.print("Enter peoples's count: ");
	    int pplCount = reader.nextInt();

        _persons = new Person[pplCount];

        for(int i = 0; i < pplCount; i++){
            System.out.print("Enter " + i + " people name: ");
	        var name = reader.next();
            
            System.out.print("Enter " + name + "'s last name: ");
	        var lastname = reader.next();

            System.out.print("Enter " + name + "'s birthday year: ");
	        var birthdayYear = reader.nextInt();
            
            System.out.print("Enter " + name + "'s city: ");
	        var city = reader.next();
            System.out.print("Enter " + name + "'s address: ");
	        var address = reader.next();

            var personAdress = new Address(city, address);
            var person = new Person(name, lastname, birthdayYear, personAdress);

            _persons[i] = person;

            System.out.println("Added!\n");
        }

        while(true){
            System.out.println("Enter 1 to search person by last name");
            System.out.println("Enter 2 to search person by city");
            System.out.println("Enter 3 to get people of born on date range:");
            System.out.println("Enter 4 to search oldest and youngest");
            System.out.println("Enter 5 to search people who lives in one district");

            System.out.println("Enter 0 to close programm");
            System.out.println("\n-------------\n");
            System.out.print("Your choose: ");

            var userChoose = reader.nextInt();
            switch(userChoose){
                case 1:
                    SearchFromLastName();
                    break; 
                case 2:
                    SearchFromCity();
                    break; 
                case 3:
                    SearchFromBirthRange();
                    break; 
                case 4:
                    FindYoungestAndOldest();
                    break; 
                case 5:
                    SearchFromDistrict();
                    break; 
                case 0:
                    return;
                default:
                    System.out.println("Error type, pls try again!");
            }
        }
    }

    private void SearchFromLastName(){
        System.out.print("Write person's last name: ");
        var lastName = reader.next();

        System.out.println("Searching... \n");
        List<Person> persons = new ArrayList<>();
        
        for(int i = 0; i < _persons.length; i++){
            if(_persons[i].PersongLastName.toLowerCase().equals(lastName.toLowerCase())){
                persons.add(_persons[i]);
            }
        }

        if(persons.size() == 0){
            System.out.println("Not found! Please try again!\n");
            return;
        }

        System.out.println("Finded " + persons.size() + " persons\n");
        for (Person person : persons) {
            ShowInformation(person);
            System.out.println("\n-------------\n");
        }
    }

    private void SearchFromCity(){
        System.out.print("Enter city: ");
        var cityName = reader.next();

        System.out.println("Searching... \n");
        List<Person> persons = new ArrayList<>();
        
        for(int i = 0; i < _persons.length; i++){
            if(_persons[i].PersonsAdress.City.toLowerCase().equals(cityName.toLowerCase())){
                persons.add(_persons[i]);
            }
        }

        if(persons.size() == 0){
            System.out.println("Not found! Please try again!\n");
            return;
        }

        System.out.println("Finded " + persons.size() + " persons who lives in " + cityName + "\n");
        for (Person person : persons) {
            ShowInformation(person);
            System.out.println("\n-------------\n");
        }
    }

    private void SearchFromBirthRange(){
        System.out.print("Enter min range: ");
        var min = reader.nextInt();

        System.out.print("Enter max range: ");
        var max = reader.nextInt();

        System.out.println("Searching... \n");
        List<Person> persons = new ArrayList<>();
        
        for(int i = 0; i < _persons.length; i++){
            var date = _persons[i].BirthdayDate;
            if(date>= min && date <= max){
                persons.add(_persons[i]);
            }
        }

        if(persons.size() == 0){
            System.out.println("Not found! Please try again!\n");
            return;
        }

        System.out.println("Finded " + persons.size() + " persons who born between " + min + " to "+ max + "\n");
        for (Person person : persons) {
            ShowInformation(person);
            System.out.println("\n-------------\n");
        }
    }

    private void FindYoungestAndOldest(){
        System.out.println("Searching... \n");

        Person youngest = null;
        Person oldest = null;

        var min = Integer.MIN_VALUE;
        var max = Integer.MAX_VALUE;

        for(int i = 0; i < _persons.length; i++){
            var date = _persons[i].BirthdayDate;
            if(date > min){
                youngest = _persons[i];
                min = date;
            }
            if(date < max){
                oldest = _persons[i];
                max = date;
            }
        }

        System.out.println("Youngest is: ");
        ShowInformation(youngest);

        System.out.println("\n-------------\n");

        System.out.println("Oldest is: ");
        ShowInformation(oldest);

        System.out.println("\n-------------\n");
    }

    private void SearchFromDistrict(){
        System.out.print("Enter district: ");
        var district = reader.next();

        System.out.println("Searching... \n");
        List<Person> persons = new ArrayList<>();
        
        for(int i = 0; i < _persons.length; i++){
            if(_persons[i].PersonsAdress.HomeAddress.toLowerCase().equals(district.toLowerCase())){
                persons.add(_persons[i]);
            }
        }

        if(persons.size() == 0){
            System.out.println("Not found! Please try again!\n");
            return;
        }

        System.out.println("Finded " + persons.size() + " persons who lives in " + district + "\n");
        for (Person person : persons) {
            ShowInformation(person);
            System.out.println("\n-------------\n");
        }
    }

    private void ShowInformation(Person person){
        System.out.println("First name: " + person.PersonName);
        System.out.println("Last name: " + person.PersongLastName);
        System.out.println("Birthday date: " + person.BirthdayDate);
        System.out.println("City Address: " + person.PersonsAdress.City);
        System.out.println("District: " + person.PersonsAdress.HomeAddress);
    }
}