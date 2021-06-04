package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.EmployerUserService;
import kodlamaio.hrms.business.abstracts.JobFormService;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entitiy.concretes.City;
import kodlamaio.hrms.entitiy.concretes.EmployerUser;
import kodlamaio.hrms.entitiy.concretes.JobForm;
import kodlamaio.hrms.entitiy.concretes.JobPosition;
import kodlamaio.hrms.entitiy.dtos.JobFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/jobforms")
public class JobFormController {

    private JobFormService jobFormService;
    private JobPositionService jobPositionService;
    private EmployerUserService employerUserService;
    private CityService cityService;


    @Autowired
    public JobFormController(JobFormService jobFormService, JobPositionService jobPositionService, EmployerUserService employerUserService, CityService cityService) {
        this.jobFormService = jobFormService;
        this.jobPositionService=jobPositionService;
        this.employerUserService=employerUserService;
        this.cityService=cityService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobFormDto>> getAll(){
        return this.jobFormService.getAll();
    }

    @GetMapping("/getAllDateSorted")
    public DataResult<List<JobFormDto>> getAllDateSorted(@RequestParam boolean sortType){
        return this.jobFormService.getAllDateSorted(sortType);
    }

    public DataResult<List<JobFormDto>> getJobFormDetailsByCompanyName(@RequestParam String companyName){
        return this.jobFormService.getCompanyForms(companyName);
    }

    @GetMapping("/closeJobForm")
    public Result closeJobForm(@RequestParam int jobId){
        return this.jobFormService.closeJobForm(jobId);
    }

    @GetMapping("/add")
    public Result add(@RequestParam("jobPositionId") int jobPositionId, @RequestParam String jobDefinition,
                      @RequestParam("cityId") int cityId, @RequestParam("minBudget") int minBudget, @RequestParam("maxBudget") int maxBudget,
                      @RequestParam("positionCount") int positionCount, @RequestParam(value = "formEndDate", required = false) String formEndDate,
                      @RequestParam("employerId") int employerId
                      ){

        JobPosition jobPosition = jobPositionService.getJobPositionByJobPositionId(jobPositionId).getData();
        EmployerUser employerUser = employerUserService.getEmployerUserByEmployerUserId(employerId).getData();
        City city = cityService.getCityByCityId(cityId).getData();

        JobForm jobForm = new JobForm();

        jobForm.setJobPosition(jobPosition);
        jobForm.setEmployerUser(employerUser);
        jobForm.setCity(city);

        jobForm.setFormDate(LocalDate.now());
        jobForm.setJobDefinition(jobDefinition);
        jobForm.setMinBudget(minBudget);
        jobForm.setMaxBudget(maxBudget);
        jobForm.setPositionCount(positionCount);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        jobForm.setFormEndDate(LocalDate.parse(formEndDate,formatter));
        jobForm.setActive(true);

        return this.jobFormService.add(jobForm);
    }
}
