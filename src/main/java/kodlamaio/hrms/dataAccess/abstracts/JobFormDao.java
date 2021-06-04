package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entitiy.concretes.JobForm;
import kodlamaio.hrms.entitiy.dtos.JobFormDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobFormDao extends JpaRepository<JobForm,Integer> {
    List<JobForm> getJobFormByActive(boolean active);
    List<JobForm> getJobFormByActiveOrderByFormDateAsc(boolean active);
    List<JobForm> getJobFormByActiveOrderByFormDateDesc(boolean active);
    List<JobForm> getJobFormByActiveAndEmployerUserCompanyName(boolean active,String companyName);
    JobForm getJobFormByJobId(int jobId);

    @Query("SELECT NEW kodlamaio.hrms.entitiy.dtos.JobFormDto" +
            "(e.companyName,p.jobPositionName,j.jobDefinition,j.positionCount,j.formDate,j.formEndDate,c.cityName)" +
            "FROM JobForm j INNER JOIN j.employerUser e INNER JOIN j.jobPosition p INNER JOIN j.city c")
    List<JobFormDto> getJobFormDetails();

    @Query("SELECT NEW kodlamaio.hrms.entitiy.dtos.JobFormDto" +
            "(e.companyName,p.jobPositionName,j.jobDefinition,j.positionCount,j.formDate,j.formEndDate,c.cityName)" +
            "FROM JobForm j " +
            "INNER JOIN j.employerUser e " +
            "INNER JOIN j.jobPosition p " +
            "INNER JOIN j.city c  WHERE e.companyName=:companyName")
    List<JobFormDto> getJobFormDetailsByCompanyName(String companyName);

    @Query("SELECT NEW kodlamaio.hrms.entitiy.dtos.JobFormDto" +
            "(e.companyName,p.jobPositionName,j.jobDefinition,j.positionCount,j.formDate,j.formEndDate,c.cityName)" +
            "FROM JobForm j INNER JOIN j.employerUser e INNER JOIN j.jobPosition p INNER JOIN j.city c ORDER BY j.formDate")
    List<JobFormDto> getJobFormDetailsOrderByASC();

    @Query("SELECT NEW kodlamaio.hrms.entitiy.dtos.JobFormDto" +
            "(e.companyName,p.jobPositionName,j.jobDefinition,j.positionCount,j.formDate,j.formEndDate,c.cityName)" +
            "FROM JobForm j INNER JOIN j.employerUser e INNER JOIN j.jobPosition p INNER JOIN j.city c ORDER BY j.formDate DESC")
    List<JobFormDto> getJobFormDetailsOrderByDesc();
}
