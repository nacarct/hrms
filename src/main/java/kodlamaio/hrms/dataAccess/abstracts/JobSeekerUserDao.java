package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entitiy.concretes.JobSeekerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerUserDao extends JpaRepository<JobSeekerUser,Integer> {
}
