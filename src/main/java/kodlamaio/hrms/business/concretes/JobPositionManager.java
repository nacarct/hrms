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
            if (jobPositionNameIsExist(jobPosition.getJobPositionName()))
                return new ErrorResult("İş pozisyonu sistemde var!");

            jobPositionDao.save(jobPosition);
            return new SuccessResult("İş Pozisyonu eklendi.");
        }
        catch (Exception e){
            return new ErrorResult("İş Pozisyonu eklenemedi. Hata : " + e.toString());
        }
    }

    @Override
    public boolean jobPositionNameIsExist(String jobPositionName) {
        var result=false;

        try{
            if (this.jobPositionDao.getJobPositionByJobPositionName(jobPositionName).getJobPositionName().length()>0)
                result=true;
            else
                result=false;
        }
        catch (Exception e){
            return false;
        }

        return result;
    }

    @Override
    public DataResult<JobPosition> getJobPositionByJobPositionName(String jobPositionName) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.getJobPositionByJobPositionName(jobPositionName));
    }

    @Override
    public DataResult<JobPosition> getJobPositionByJobPositionId(int jobPositionId) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.getJobPositionByJobPositionId(jobPositionId));
    }
}
