package kodlamaio.hrms.entitiy.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_seeker_users")
public class JobSeekerUser{

    @Id
    @GeneratedValue
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

    @Column(name = "user_id")
    private int userId;

    @Column(name = "email_status")
    private boolean emailStatus;

    @Column(name = "citizen_id_status")
    private boolean citizenIdStatus;

}
