package prueba.amaris.assessment.TechnicalAssessment.domain.model;

import java.io.Serializable;
import java.util.List;


public record EmployeeListResponse(String status, List<EmployeeInfo> data) implements Serializable {
    private static final long serialVersionUID = 2L;
}
