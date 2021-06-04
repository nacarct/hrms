package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitiy.concretes.EducationInfo;

import java.util.List;

public interface EducationInfoService {
    DataResult<List<EducationInfo>> getAll();
    Result add(EducationInfo educationInfo);
}
