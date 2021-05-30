package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entitiy.concretes.JobForm;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobFormDao extends JpaRepository<JobForm,Integer> {
    List<JobForm> getJobFormByActive(boolean active);
    List<JobForm> getJobFormByActiveOrderByFormDateAsc(boolean active);
    List<JobForm> getJobFormByActiveOrderByFormDateDesc(boolean active);
    List<JobForm> getJobFormByActiveAndEmployerUserCompanyName(boolean active,String companyName);
    JobForm getJobFormByJobId(int jobId);
}
