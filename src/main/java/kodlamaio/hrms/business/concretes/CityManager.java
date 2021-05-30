package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entitiy.concretes.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    CityDao cityDao;

    public CityManager(CityDao cityDao) {
        this.cityDao=cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(cityDao.findAll());
    }

    @Override
    public Result add(City city) {
        this.cityDao.save(city);
        return new SuccessResult("Şehir eklendi.");
    }

    @Override
    public DataResult<City> getCityByCityId(int cityId) {
        return new SuccessDataResult<City>(this.cityDao.getCityByCityId(cityId));
    }
}
