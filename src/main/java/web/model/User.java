package web.model;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty(message = "name empty" )
    @Size(min = 2, max = 30, message = "name size")
    @Pattern(regexp = "[^A-Za-zА-Яа-я]")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "lastname empty" )
    @Size(min = 2, max = 30, message = "lastname size")
    @Pattern(regexp = "[^A-Za-zА-Яа-я]")
    @Column(name = "lastName")
    private String lastName;
    public User() { }
    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
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
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
