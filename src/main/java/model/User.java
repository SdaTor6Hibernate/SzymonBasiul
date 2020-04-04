package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NamedQueries({@NamedQuery(name = "user.select", query = "Select u from User u where u.email=:email")})
@EqualsAndHashCode(exclude = {"address", "orders"})
@ToString(exclude = {"address", "orders"})
public class User implements ModelClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private int id;
    @Column(name = "USR_FIRSTNAME")
    private String firstName;
    @Column(name = "USR_LASTNAME")
    private String lastName;
    @Column(name = "USR_PASSWORD")
    private String password;
    @Column(name = "USR_EMAIL")
    private String email;
    @Column(name = "USR_BIRTH_DATE")
    private LocalDateTime birthDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_ADD_ID", referencedColumnName = "ADD_ID")
    private Adress adress;
    @Transient
    private String fullName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    Set<Order> order = new HashSet<>();

    public String getFullName(){
        return fullName = firstName + " "+lastName;
    }

    @Override
    public String toString(){
        return ""+id;
    }
}
