package prueba.amaris.assessment.TechnicalAssessment.application.dtos;

import lombok.Builder;

@Builder
public record EmployeeInfoDTO(Long id, String employeeName, Long employeeSalary, int employeeAge, String profileImage, Long employeeAnnualSalary) {
}
