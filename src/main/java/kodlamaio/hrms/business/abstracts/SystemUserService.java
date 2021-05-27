package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entitiy.concretes.SystemUser;

import java.util.List;

public interface SystemUserService {
    DataResult<List<SystemUser>> getAll();
}
