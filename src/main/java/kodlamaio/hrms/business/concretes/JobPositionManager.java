package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entitiy.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll());
    }

    @Override
    public Result add(JobPosition jobPosition) {
        try{
            jobPositionDao.save(jobPosition);
            return new SuccessResult("İş Pozisyonu eklendi.");
        }
        catch (Exception e){
            return new ErrorResult("İş Pozisyonu eklenemedi. Hata : " + e.toString());
        }
    }
}
