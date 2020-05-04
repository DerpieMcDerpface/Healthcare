package sogeti.model;

public class User {

    private int id;
    private String name;
    private String surname;
    private String mail;
    private String password;

<<<<<<< HEAD

=======
    @Column (name = "securityCode")
    private String securityCode;

    public User(){
    }

    public User(String name, String surname, String username, String email, String password, String securityCode) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.securityCode = securityCode;
    }
>>>>>>> master

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

<<<<<<< HEAD
=======
    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }


>>>>>>> master
}
