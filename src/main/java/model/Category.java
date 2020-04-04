package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category implements ModelClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAT_ID")
    private int id;
    @Column(name = "CAT_NAME")
    private String name;

    @Override
    public String toString(){
        return ""+id;
    }
}
