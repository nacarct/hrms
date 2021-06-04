package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobFormService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobFormDao;
import kodlamaio.hrms.entitiy.concretes.EmployerUser;
import kodlamaio.hrms.entitiy.concretes.JobForm;
import kodlamaio.hrms.entitiy.dtos.JobFormDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobFormManager implements JobFormService {

    private JobFormDao jobFormDao;

    @Autowired
    public JobFormManager(JobFormDao jobFormDao) {
        this.jobFormDao = jobFormDao;
    }

    @Override
    public DataResult<List<JobFormDto>> getAll() {
        return new SuccessDataResult<List<JobFormDto>>(this.jobFormDao.getJobFormDetails());
    }

    @Override
    public DataResult<List<JobFormDto>> getAllDateSorted(boolean sortType) {
        if (sortType)
            return new SuccessDataResult<List<JobFormDto>>(this.jobFormDao.getJobFormDetailsOrderByDesc());

        return new SuccessDataResult<List<JobFormDto>>(this.jobFormDao.getJobFormDetailsOrderByASC());
    }

    @Override
    public DataResult<List<JobFormDto>> getCompanyForms(String companyName) {
        return new SuccessDataResult<List<JobFormDto>>(this.jobFormDao.getJobFormDetailsByCompanyName(""));
    }

    @Override
    public Result add(JobForm jobForm) {

        if (jobForm.getJobPosition().getJobPositionName()=="" || jobForm.getJobDefinition()=="" ||
                jobForm.getCity().getCityName()=="" || jobForm.getPositionCount()==0
        )
            return new ErrorResult("Lütfen zorunlu alanları doldurunuz.");

        this.jobFormDao.save(jobForm);

        return new SuccessResult("İş Formu eklendi.");
    }

    @Override
    public Result closeJobForm(int jobId) {
        JobForm jobForm = new JobForm();
        jobForm = this.jobFormDao.getJobFormByJobId(jobId);
        jobForm.setActive(false);
        this.jobFormDao.save(jobForm);
        return new SuccessResult("İş Formu kapatıldı!");
    }

}
