package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entitiy.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(userDao.findAll(),"Liste getirildi.");
    }

    @Override
    public Result add(User user) {
        try{
            userDao.save(user);
            return new SuccessResult("Kullanıcı eklendi.");
        }
        catch (Exception e){
            return new ErrorResult("Kullanıcı eklenemedi. Hata : " + e.toString());
        }
    }

    @Override
    public boolean getUserByEmail(String email) {
        var result=false;
        if (this.userDao.getUserByEmail(email).getEmail().length()>0)
            result=true;
        else
            result=false;

        return result;
    }
}
