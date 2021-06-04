package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entitiy.concretes.Resume;
import kodlamaio.hrms.entitiy.dtos.ResumeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResumeDao extends JpaRepository<Resume,Integer> {
}
