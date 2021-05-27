package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.EmployerUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entitiy.concretes.EmployerUser;
import kodlamaio.hrms.entitiy.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result add(@RequestBody EmployerUser employerUser){
        return this.employerUserService.add(employerUser);
    }
}
