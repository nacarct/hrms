package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitiy.concretes.JobSeekerUser;

import java.util.List;

public interface JobSeekerUserService {
    DataResult<List<JobSeekerUser>> getAll();
    Result add(JobSeekerUser jobSeekerUser,String rePassword);
    boolean getJobSeekerUserByCitizenId(String citizenId);
    boolean getJobSeekerUserByUserEmail(String email);
}
