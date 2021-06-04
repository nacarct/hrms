package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entitiy.concretes.EducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationInfoDao extends JpaRepository<EducationInfo,Integer> {
}
