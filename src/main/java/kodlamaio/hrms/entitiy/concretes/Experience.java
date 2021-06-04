package kodlamaio.hrms.entitiy.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private int experienceId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    @Nullable
    private int endYear;

    @Column(name = "working_now")
    private boolean workingNow;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
