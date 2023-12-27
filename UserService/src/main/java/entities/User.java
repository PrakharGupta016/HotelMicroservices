package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "micro_users")
public class User {
    @Id
    private String userId;
    private String name;
    private String email;

    private String about;
}
