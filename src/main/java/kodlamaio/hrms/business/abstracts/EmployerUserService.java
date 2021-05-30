package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitiy.concretes.EmployerUser;

import java.util.List;

public interface EmployerUserService {
    DataResult<List<EmployerUser>> getAll();
    Result add(EmployerUser employerUser, String rePassword);
    boolean getEmployerUserByUserEmail(String email);
    DataResult<EmployerUser> getEmployerUserByCompanyName(String companyName);
    DataResult<EmployerUser> getEmployerUserByEmployerUserId(int employerUserId);
}
