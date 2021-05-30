package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitiy.concretes.JobForm;
import kodlamaio.hrms.entitiy.dtos.JobFormDto;

import java.util.List;

public interface JobFormService {
    DataResult<List<JobFormDto>> getAll();
    DataResult<List<JobFormDto>> getAllDateSorted(boolean sortType);
    DataResult<List<JobFormDto>> getCompanyForms(String companyName);
    Result add(JobForm jobForm);
    Result closeJobForm(int jobId);
}
