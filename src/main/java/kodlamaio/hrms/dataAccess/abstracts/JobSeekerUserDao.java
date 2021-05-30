package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entitiy.concretes.JobSeekerUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerUserDao extends JpaRepository<JobSeekerUser,Integer> {
    JobSeekerUser getJobSeekerUserByCitizenId(String citizenId);
    JobSeekerUser getJobSeekerUserByUserEmail(String email);
}
