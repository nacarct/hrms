package kodlamaio.hrms.entitiy.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "employer_users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobForms"})
public class EmployerUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "employerUser")
    private List<JobForm> jobForms;
}

