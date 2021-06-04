package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitiy.concretes.Skill;

import java.util.List;

public interface SkillService {
    DataResult<List<Skill>> getAll();
    Result add(Skill skill);
}
