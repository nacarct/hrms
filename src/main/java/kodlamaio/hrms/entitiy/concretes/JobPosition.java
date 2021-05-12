package kodlamaio.hrms.entitiy.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_positions")
public class JobPosition {

    @Id
    @GeneratedValue
    @Column(name = "job_position_id")
    private int jobPositionId;

    @Column(name = "job_position_name")
    private String jobPositionName;

}
