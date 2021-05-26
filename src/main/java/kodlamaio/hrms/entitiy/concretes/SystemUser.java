package kodlamaio.hrms.entitiy.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "system_users")
public class SystemUser{
    @Id
    @GeneratedValue
    @Column(name = "system_user_id")
    private int systemUserId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_id")
    private int userId;
}
