package prueba.amaris.assessment.TechnicalAssessment.domain.model;

import java.io.Serializable;

public record EmployeeInfoResponse(String status, EmployeeInfo data) implements Serializable {
    private static final long serialVersionUID = 3L;
}
