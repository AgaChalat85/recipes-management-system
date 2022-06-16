package pl.agachalat.recipesmanagementsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String eMail;
    private String password;

}
