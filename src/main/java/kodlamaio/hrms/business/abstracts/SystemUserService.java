package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entitiy.concretes.SystemUser;

import java.util.List;

public interface SystemUserService {
    List<SystemUser> getAll();
}
