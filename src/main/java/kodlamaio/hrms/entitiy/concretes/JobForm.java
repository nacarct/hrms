package kodlamaio.hrms.entitiy.concretes;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "job_forms")
public class JobForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int jobId;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @Column(name = "job_definition")
    private String jobDefinition;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "min_budget")
    private int minBudget;

    @Column(name = "max_budget")
    private int maxBudget;

    @Column(name = "position_count")
    private int positionCount;

    @Column(name = "form_date")
    private LocalDate formDate;

    @Column(name = "form_end_date")
    private LocalDate formEndDate;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "employer_user_id")
    private EmployerUser employerUser;
}
