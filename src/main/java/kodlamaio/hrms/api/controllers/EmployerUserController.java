package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitiy.concretes.EmployerUser;
import kodlamaio.hrms.entitiy.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employerusers")
public class EmployerUserController {

    private EmployerUserService employerUserService;

    @Autowired
    public EmployerUserController(EmployerUserService employerUserService) {
        this.employerUserService = employerUserService;
    }

    @GetMapping("/getall")
    public DataResult<List<EmployerUser>> getAll(){
        return employerUserService.getAll();
    }

    @GetMapping("/add")
    public Result add(@RequestParam("email") String email, @RequestParam("website") String website,
                      @RequestParam("company") String company, @RequestParam("phone") String phone,
                      @RequestParam("password") String password,
                      @RequestParam("rePassword") String rePassword
    ){


        User user = new User();

        user.setEmail(email);
        user.setPassword(password);
        user.setUserStatus(false);

        EmployerUser employerUser = new EmployerUser();

        employerUser.setUser(user);
        employerUser.setWebsite(website);
        employerUser.setCompanyName(company);
        employerUser.setPhoneNumber(phone);
        employerUser.setEmailStatus(false);
        employerUser.setSystemStatus(false);

        return this.employerUserService.add(employerUser, rePassword);
    }
}
