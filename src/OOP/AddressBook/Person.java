package OOP.AddressBook;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;

    public static void main(String[] args) throws Exception {
        var person = new Person("Muso", "Ismailov", "A");
        System.out.println(person.toString());
    }

    public Person(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(lastName);
        if (firstName != null) {
            sb.append(" ").append(firstName.charAt(0)).append(".");
        }
        if (middleName != null) {
            sb.append(middleName.charAt(0)).append(".");
        }
        return sb.toString();
    }
}

