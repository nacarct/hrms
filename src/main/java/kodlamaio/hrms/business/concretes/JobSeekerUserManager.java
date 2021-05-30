package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerUserService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.InfoSystem.InfoService;
import kodlamaio.hrms.core.NICS.NationalIdentityCheckService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerUserDao;
import kodlamaio.hrms.entitiy.concretes.JobSeekerUser;
import kodlamaio.hrms.entitiy.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerUserManager implements JobSeekerUserService {

    private JobSeekerUserDao jobSeekerUserDao;
    private UserService userService;
    private InfoService infoService;
    private NationalIdentityCheckService nationalIdentityCheckService;


    @Autowired
    public JobSeekerUserManager(JobSeekerUserDao jobSeekerUserDao,
                                UserService userService,
                                NationalIdentityCheckService nationalIdentityCheckService,
                                InfoService infoService) {

        this.jobSeekerUserDao = jobSeekerUserDao;
        this.userService = userService;
        this.nationalIdentityCheckService = nationalIdentityCheckService;
        this.infoService=infoService;
    }

    @Override
    public DataResult<List<JobSeekerUser>> getAll() {
        return new SuccessDataResult<List<JobSeekerUser>>(jobSeekerUserDao.findAll());
    }

    @Override
    public Result add(JobSeekerUser jobSeekerUser, String rePassword) {
        try{
            if (jobSeekerUser.getFirstName()=="" || jobSeekerUser.getLastName()=="" ||
                    jobSeekerUser.getCitizenId()=="" || jobSeekerUser.getYearOfBirth()=="" ||
                    jobSeekerUser.getUser().getEmail()=="" || jobSeekerUser.getUser().getPassword()=="" ||
                    rePassword=="")
                return new ErrorResult("Tüm alanlar zorunludur. Boş alan bırakmayınız!");

            if (!jobSeekerUser.getUser().getPassword().equals(rePassword))
                return new ErrorResult("Parolalar uyuşmuyor!");

            if (getJobSeekerUserByCitizenId(jobSeekerUser.getCitizenId()))
                return new ErrorResult("TC no kayıtlı!");

            if (!nationalIdentityCheckService.checkNationalIdentity(jobSeekerUser.getCitizenId()))
                return new ErrorResult("TC no hatalı!");

            if (getJobSeekerUserByUserEmail(jobSeekerUser.getUser().getEmail()))
                return new ErrorResult("Email kayıtlı!");

            userService.add(jobSeekerUser.getUser());
            jobSeekerUserDao.save(jobSeekerUser);
            infoService.sendInfo(jobSeekerUser.getUser().getEmail());
            return new SuccessResult("İş arayan bilgisi eklendi.");
        }
        catch (Exception e){
            return new ErrorResult("İş arayan bilgisi eklenemedi. Hata : " +e.toString());
        }
    }

    @Override
    public boolean getJobSeekerUserByCitizenId(String citizenId) {
        var result=false;
        try{
            if (this.jobSeekerUserDao.getJobSeekerUserByCitizenId(citizenId).getCitizenId().length()>0)
                result=true;
            else
                result=false;
        }
        catch (Exception e){
            return false;
        }


        return result;
    }

    @Override
    public boolean getJobSeekerUserByUserEmail(String email) {
        var result=false;
        try {
            if (this.jobSeekerUserDao.getJobSeekerUserByUserEmail(email).getUser().getEmail().length()>0)
                result=true;
            else
                result=false;
        }
        catch (Exception e){
            return false;
        }

        return result;
    }
}
