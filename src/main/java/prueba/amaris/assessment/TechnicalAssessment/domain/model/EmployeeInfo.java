package prueba.amaris.assessment.TechnicalAssessment.domain.model;

import java.io.Serializable;

public record EmployeeInfo(Long id, String employee_name, Long employee_salary, int employee_age, String profile_image)
implements Serializable {
    private static final long serialVersionUID = 1L;
}
