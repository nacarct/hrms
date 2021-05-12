package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.SystemUserService;
import kodlamaio.hrms.entitiy.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/systemusers")
public class SystemUserController {

    private SystemUserService systemUserService;

    @Autowired
    public SystemUserController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @GetMapping("/getall")
    public List<SystemUser> getAll(){
        return systemUserService.getAll();
    }

}
