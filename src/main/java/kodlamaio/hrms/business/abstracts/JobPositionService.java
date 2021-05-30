package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitiy.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>> getAll();
    Result add(JobPosition jobPosition);
    boolean jobPositionNameIsExist(String jobPositionName);
    DataResult<JobPosition> getJobPositionByJobPositionName(String jobPositionName);
    DataResult<JobPosition> getJobPositionByJobPositionId(int jobPositionId);
}
