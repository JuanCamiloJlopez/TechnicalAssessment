package prueba.amaris.assessment.TechnicalAssessment.application.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeSalaryService {

    public Long calculateAnnualSalary(final Long baseSalary) {
        if(Objects.isNull(baseSalary)) {
            return 0L;
        }
        return baseSalary * 12;
    }

}
