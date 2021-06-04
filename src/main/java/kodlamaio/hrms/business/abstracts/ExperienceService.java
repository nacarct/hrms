package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitiy.concretes.Experience;

import java.util.List;

public interface ExperienceService {
    DataResult<List<Experience>> getAll();
    Result add(Experience experience);
}
