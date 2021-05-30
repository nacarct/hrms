package kodlamaio.hrms.entitiy.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobFormDto {
    private String companyName;
    private String jobPositionName;
    private String jobDefinition;
    private int positionCount;
    private LocalDate formDate;
    private LocalDate formEndDate;
    private String cityName;
}
