package kodlamaio.hrms.entitiy.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobForms"})
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_position_id")
    private int jobPositionId;

    @Column(name = "job_position_name")
    private String jobPositionName;

    @OneToMany(mappedBy = "jobPosition")
    private List<JobForm> jobForms;
}
