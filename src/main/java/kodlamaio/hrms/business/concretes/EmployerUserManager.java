package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerUserService;
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
    public List<EmployerUser> getAll() {
        return employerUserDao.findAll();
    }
}
