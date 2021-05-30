package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerUserService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.InfoSystem.InfoService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUserDao;
import kodlamaio.hrms.entitiy.concretes.EmployerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerUserManager implements EmployerUserService {

    private EmployerUserDao employerUserDao;
    private UserService userService;
    private InfoService infoService;

    @Autowired
    public EmployerUserManager(EmployerUserDao employerUserDao, UserService userService, InfoService infoService) {
        this.employerUserDao = employerUserDao;
        this.userService = userService;
        this.infoService = infoService;
    }

    @Override
    public DataResult<List<EmployerUser>> getAll() {
        return new SuccessDataResult<List<EmployerUser>>(employerUserDao.findAll());
    }

    @Override
    public Result add(EmployerUser employerUser, String rePassword) {
        try{

            if (employerUser.getUser().getEmail()=="" || employerUser.getUser().getPassword()==""
                    || employerUser.getWebsite()=="" || employerUser.getCompanyName()=="" ||
                    employerUser.getPhoneNumber()=="" || rePassword==""
            )
                return new ErrorResult("Tüm alanların doldurulması zorunludur!");

            if (!employerUser.getUser().getPassword().equals(rePassword))
                return new ErrorResult("Parolalar uyuşmuyor!");

            if (getEmployerUserByUserEmail(employerUser.getUser().getEmail()))
                return new ErrorResult("Email sistemde kayıtlı!");

            if (!employerUser.getUser().getEmail().substring(employerUser.getUser().getEmail().indexOf("@")+1).
                    equals(employerUser.getWebsite()))
                return new ErrorResult("Email ile website alan adı uyuşmuyor!");

            userService.add(employerUser.getUser());
            employerUserDao.save(employerUser);

            return new SuccessResult("İş veren eklendi.");
        }
        catch (Exception e){
            return new ErrorResult("İş veren eklenemedi. Hata : " + e.toString());
        }
    }

    @Override
    public boolean getEmployerUserByUserEmail(String email) {
        try {
            if (employerUserDao.getEmployerUserByUserEmail(email).getUser().getEmail().equals(email))
                return true;
        }
        catch (Exception e){
            return false;
        }

        return false;
    }

    @Override
    public DataResult<EmployerUser> getEmployerUserByCompanyName(String companyName) {
        return new SuccessDataResult<EmployerUser>( this.employerUserDao.getEmployerUserByCompanyName(companyName));
    }

    @Override
    public DataResult<EmployerUser> getEmployerUserByEmployerUserId(int employerUserId) {
        return new SuccessDataResult<EmployerUser>(this.employerUserDao.getEmployerUserByEmployerUserId(employerUserId));
    }
}
