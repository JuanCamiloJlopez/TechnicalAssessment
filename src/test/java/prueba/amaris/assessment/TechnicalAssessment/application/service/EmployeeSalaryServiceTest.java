package prueba.amaris.assessment.TechnicalAssessment.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeSalaryServiceTest {

    @InjectMocks
    private EmployeeSalaryService employeeSalaryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateAnnualSalary_NullBaseSalary() {
        // Caso borde: baseSalary es null
        Long baseSalary = null;
        Long expectedAnnualSalary = 0L;

        Long actualAnnualSalary = employeeSalaryService.calculateAnnualSalary(baseSalary);

        assertEquals(expectedAnnualSalary, actualAnnualSalary, "El salario anual debería ser 0 cuando el salario base es null");
    }

    @Test
    public void testCalculateAnnualSalary_ZeroBaseSalary() {
        // Caso borde: baseSalary es 0
        Long baseSalary = 0L;
        Long expectedAnnualSalary = 0L;

        Long actualAnnualSalary = employeeSalaryService.calculateAnnualSalary(baseSalary);

        assertEquals(expectedAnnualSalary, actualAnnualSalary, "El salario anual debería ser 0 cuando el salario base es 0");
    }

    @Test
    public void testCalculateAnnualSalary_PositiveBaseSalary() {
        // Caso normal: baseSalary es positivo
        Long baseSalary = 5000L;
        Long expectedAnnualSalary = 5000L * 12;

        Long actualAnnualSalary = employeeSalaryService.calculateAnnualSalary(baseSalary);

        assertEquals(expectedAnnualSalary, actualAnnualSalary, "El salario anual debería ser baseSalary * 12");
    }

    @Test
    public void testCalculateAnnualSalary_LargeBaseSalary() {
        // Caso borde: baseSalary con un valor grande
        Long baseSalary = Long.MAX_VALUE / 12;
        Long expectedAnnualSalary = baseSalary * 12;

        Long actualAnnualSalary = employeeSalaryService.calculateAnnualSalary(baseSalary);

        assertEquals(expectedAnnualSalary, actualAnnualSalary, "El salario anual debería ser baseSalary * 12 para valores grandes");
    }
}
