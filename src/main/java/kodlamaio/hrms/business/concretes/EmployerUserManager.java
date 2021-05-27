package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerUserService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUserDao;
import kodlamaio.hrms.entitiy.concretes.EmployerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerUserManager implements EmployerUserService {

    private EmployerUserDao employerUserDao;

    @Autowired
    public EmployerUserManager(EmployerUserDao employerUserDao) {
        this.employerUserDao = employerUserDao;
    }

    @Override
    public DataResult<List<EmployerUser>> getAll() {
        return new SuccessDataResult<List<EmployerUser>>(employerUserDao.findAll());
    }

    @Override
    public Result add(EmployerUser employerUser) {
        try{
            return new SuccessResult("İş veren eklendi.");
        }
        catch (Exception e){
            return new ErrorResult("İş veren eklenemedi. Hata : " + e.toString());
        }
    }
}
