package kodlamaio.hrms.entitiy.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobFormDto {
    private String companyName;
    private String jobPositionName;
    private String jobDefinition;
    private int positionCount;
    private LocalDate formDate;
    private LocalDate formEndDate;
    private String cityName;
}
