package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerUserService;
import kodlamaio.hrms.core.utilities.results.*;
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
    public DataResult<List<JobSeekerUser>> getAll() {
        return new SuccessDataResult<List<JobSeekerUser>>(jobSeekerUserDao.findAll());
    }

    @Override
    public Result add(JobSeekerUser jobSeekerUser) {
        try{
            jobSeekerUserDao.save(jobSeekerUser);
            return new SuccessResult("İş arayan bilgisi eklendi.");
        }
        catch (Exception e){
            return new ErrorResult("İş arayan bilgisi eklenemedi. Hata : " +e.toString());
        }
    }
}
