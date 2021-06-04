package kodlamaio.hrms.entitiy.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Entity
@Table(name = "education_infos")
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfo {

    @Id
    @Column(name = "education_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationId;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "school_section")
    private String schoolSection;

    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    @Nullable
    private int endYear;

    @Column(name = "study_now")
    private boolean studyNow;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
