package kodlamaio.hrms.entitiy.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employerUsers","jobSeekerUsers"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_status")
    private boolean userStatus;

    @OneToMany(mappedBy = "user")
    private List<JobSeekerUser> jobSeekerUsers;

    @OneToMany(mappedBy = "user")
    private List<EmployerUser> employerUsers;
}
