package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entitiy.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceDao extends JpaRepository<Experience,Integer> {
}
