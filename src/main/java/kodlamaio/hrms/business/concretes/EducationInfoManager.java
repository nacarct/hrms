package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationInfoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationInfoDao;
import kodlamaio.hrms.entitiy.concretes.EducationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationInfoManager implements EducationInfoService {

    private EducationInfoDao educationInfoDao;

    @Autowired
    public EducationInfoManager(EducationInfoDao educationInfoDao) {
        this.educationInfoDao = educationInfoDao;
    }

    @Override
    public DataResult<List<EducationInfo>> getAll() {
        return new SuccessDataResult<>(this.educationInfoDao.findAll());
    }

    @Override
    public Result add(EducationInfo educationInfo) {
        this.educationInfoDao.save(educationInfo);
        return new SuccessResult("Eğitim bilgisi eklendi.");
    }
}
