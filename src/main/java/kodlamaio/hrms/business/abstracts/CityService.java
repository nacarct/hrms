package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitiy.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
    Result add(City city);
    DataResult<City> getCityByCityId(int cityId);
}
