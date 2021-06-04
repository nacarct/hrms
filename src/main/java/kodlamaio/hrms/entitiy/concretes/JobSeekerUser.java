package kodlamaio.hrms.entitiy.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "job_seeker_users")
public class JobSeekerUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_seeker_user_id")
    private int jobSeekerUserId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "citizen_id")
    private String citizenId;

    @Column(name = "year_of_birth")
    private String yearOfBirth;

    @Column(name = "email_status")
    private boolean emailStatus;

    @Column(name = "citizen_id_status")
    private boolean citizenIdStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "jobSeekerUser")
    private List<Resume> resumes;
}
