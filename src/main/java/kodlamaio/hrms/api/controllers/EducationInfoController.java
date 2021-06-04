package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EducationInfoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entitiy.concretes.EducationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/educationInfos")
public class EducationInfoController {

    private EducationInfoService educationInfoService;

    @Autowired
    public EducationInfoController(EducationInfoService educationInfoService) {
        this.educationInfoService = educationInfoService;
    }

    @GetMapping("/getAll")
    public DataResult<List<EducationInfo>> getAll() {
        return this.educationInfoService.getAll();
    }

    @GetMapping("/add")
    public Result add(EducationInfo educationInfo) {
        return this.educationInfoService.add(educationInfo);
    }
}
