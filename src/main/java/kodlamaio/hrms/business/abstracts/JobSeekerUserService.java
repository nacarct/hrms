package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entitiy.concretes.JobSeekerUser;

import java.util.List;

public interface JobSeekerUserService {
    List<JobSeekerUser> getAll();
}
