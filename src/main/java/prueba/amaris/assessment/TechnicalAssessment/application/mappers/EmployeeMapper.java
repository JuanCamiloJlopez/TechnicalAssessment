package prueba.amaris.assessment.TechnicalAssessment.application.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import prueba.amaris.assessment.TechnicalAssessment.application.dtos.EmployeeInfoDTO;
import prueba.amaris.assessment.TechnicalAssessment.application.service.EmployeeSalaryService;
import prueba.amaris.assessment.TechnicalAssessment.domain.model.EmployeeInfo;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final EmployeeSalaryService employeeSalaryService;

    public EmployeeInfoDTO mapEmployeeToDTO(final EmployeeInfo employeeInfo) {
        return EmployeeInfoDTO.builder()
                .employeeSalary(employeeInfo.employee_salary())
                .employeeAge(employeeInfo.employee_age())
                .employeeName(employeeInfo.employee_name())
                .id(employeeInfo.id())
                .employeeAnnualSalary(getEmployeeAnnualSalary(employeeInfo))
                .build();
    }

    private Long getEmployeeAnnualSalary(final EmployeeInfo employeeInfo) {
        return this.employeeSalaryService.calculateAnnualSalary(employeeInfo.employee_salary());
    }
}
