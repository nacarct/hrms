package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerUserService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerUserDao;
import kodlamaio.hrms.entitiy.concretes.JobSeekerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerUserManager implements JobSeekerUserService {

    private JobSeekerUserDao jobSeekerUserDao;

    @Autowired
    public JobSeekerUserManager(JobSeekerUserDao jobSeekerUserDao) {
        this.jobSeekerUserDao = jobSeekerUserDao;
    }

    @Override
    public List<JobSeekerUser> getAll() {
        return jobSeekerUserDao.findAll();
    }
}
