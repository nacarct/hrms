package kodlamaio.hrms.entitiy.dtos;

import kodlamaio.hrms.entitiy.concretes.*;

import javax.persistence.*;
import java.util.List;

public class ResumeDto {
    private Resume resume;
    private List<EducationInfo> educationInfos;
    private List<Experience> experiences;
    private List<ForeignLanguage> foreignLanguages;
    private List<Skill> skills;
}
