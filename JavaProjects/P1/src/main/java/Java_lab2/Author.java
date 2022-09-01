package Java_lab2;

public class Author {
    private String firstName, lastName;
    Author(String f, String l) {firstName = f; lastName = l; }
    public String getFirstName() {return firstName; }
    public String getLastName() {return lastName; }
    public void setFirstName(String n) {firstName = n; }
    public void setLastName(String n) {lastName = n; }
    @Override
    public String toString() { return String.format("%s %s", firstName, lastName); }
}
