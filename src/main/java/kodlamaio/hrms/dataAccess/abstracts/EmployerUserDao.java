package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entitiy.concretes.EmployerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerUserDao extends JpaRepository<EmployerUser,Integer> {
    EmployerUser getEmployerUserByUserEmail(String email);
    EmployerUser getEmployerUserByCompanyName(String companyName);
    EmployerUser getEmployerUserByEmployerUserId(int employerUserId);
}
