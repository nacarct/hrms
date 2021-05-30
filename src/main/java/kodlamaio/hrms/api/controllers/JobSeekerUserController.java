package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobSeekerUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitiy.concretes.JobSeekerUser;
import kodlamaio.hrms.entitiy.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<List<JobSeekerUser>> getAll(){
        return jobSeekerUserService.getAll();
    }

    @GetMapping("/add")
    public Result add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                      @RequestParam("citizenId") String citizenId, @RequestParam("yearOfBirth") String yearOfBirth,
                      @RequestParam("email") String email, @RequestParam("password") String password,
                      @RequestParam("rePassword") String rePassword){



        User user = new User();

        user.setEmail(email);
        user.setPassword(password);
        user.setUserStatus(false);

        JobSeekerUser jobSeekerUser=new JobSeekerUser();

        jobSeekerUser.setUser(user);
        jobSeekerUser.setFirstName(firstName);
        jobSeekerUser.setLastName(lastName);
        jobSeekerUser.setCitizenId(citizenId);
        jobSeekerUser.setYearOfBirth(yearOfBirth);
        jobSeekerUser.setCitizenIdStatus(true);
        jobSeekerUser.setEmailStatus(false);

        return this.jobSeekerUserService.add(jobSeekerUser, rePassword);

    }
}
