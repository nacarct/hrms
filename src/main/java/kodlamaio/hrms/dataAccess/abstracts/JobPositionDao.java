package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entitiy.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
    JobPosition getJobPositionByJobPositionName(String jobPositionName);
    JobPosition getJobPositionByJobPositionId(int jobPositionId);
}
