package kodlamaio.hrms.entitiy.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employer_users")
public class EmployerUser{

    @Id
    @GeneratedValue
    @Column(name = "employer_user_id")
    private int employerUserId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_status")
    private boolean emailStatus;

    @Column(name = "system_status")
    private boolean systemStatus;

    @Column(name = "user_id")
    private int userId;
}

