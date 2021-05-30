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
    private ModelMapper modelMapper;

    @Autowired
    public JobFormManager(JobFormDao jobFormDao, ModelMapper modelMapper) {
        this.jobFormDao = jobFormDao;
        this.modelMapper=modelMapper;
    }

    @Override
    public DataResult<List<JobFormDto>> getAll() {
        return new SuccessDataResult<List<JobFormDto>>(this.jobFormDao.getJobFormByActive(true).stream().map(this::convertToDto).collect(Collectors.toList()));
        //return new SuccessDataResult<List<JobForm>>(this.jobFormDao.findAll());
    }

    @Override
    public DataResult<List<JobFormDto>> getAllDateSorted(boolean sortType) {
        if (sortType)
            return new SuccessDataResult<List<JobFormDto>>(this.jobFormDao.getJobFormByActiveOrderByFormDateAsc(true).stream().map(this::convertToDto).collect(Collectors.toList()));
        else
            return new SuccessDataResult<List<JobFormDto>>(this.jobFormDao.getJobFormByActiveOrderByFormDateDesc(true).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @Override
    public DataResult<List<JobFormDto>> getCompanyForms(String companyName) {
        return new SuccessDataResult<List<JobFormDto>>(this.jobFormDao.getJobFormByActiveAndEmployerUserCompanyName(true,companyName).stream().map(this::convertToDto).collect(Collectors.toList()));
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

    private JobFormDto convertToDto(JobForm jobForm) {
        JobFormDto jobFormDto = modelMapper.map(jobForm, JobFormDto.class);
        jobFormDto.setCompanyName(jobForm.getEmployerUser().getCompanyName());
        return jobFormDto;
    }


}
