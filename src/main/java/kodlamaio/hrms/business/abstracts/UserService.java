package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entitiy.concretes.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
}
