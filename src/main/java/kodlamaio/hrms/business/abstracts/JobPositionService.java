package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entitiy.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAll();
}
