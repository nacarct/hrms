package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.JobSeekerUserService;
import kodlamaio.hrms.entitiy.concretes.JobSeekerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/jobseekerusers")
public class JobSeekerUserController {

    private JobSeekerUserService jobSeekerUserService;

    @Autowired
    public JobSeekerUserController(JobSeekerUserService jobSeekerUserService) {
        this.jobSeekerUserService = jobSeekerUserService;
    }

    @GetMapping("/getall")
    public List<JobSeekerUser> getAll(){
        return jobSeekerUserService.getAll();
    }
}
