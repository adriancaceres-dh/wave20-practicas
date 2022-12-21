public class Client {
    protected String dni, name, lastName, email;
    public Client(String dni, String name, String lastName, String email) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
