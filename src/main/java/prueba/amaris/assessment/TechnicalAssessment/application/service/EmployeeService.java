package prueba.amaris.assessment.TechnicalAssessment.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import prueba.amaris.assessment.TechnicalAssessment.application.dtos.EmployeeInfoDTO;
import prueba.amaris.assessment.TechnicalAssessment.application.mappers.EmployeeMapper;
import prueba.amaris.assessment.TechnicalAssessment.infrastructure.restclients.EmployeeClient;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeClient employeeClient;

    private final EmployeeMapper employeeMapper;

    public List<EmployeeInfoDTO> getEmployees(String apiCookie) {
        final var result = employeeClient.getEmployees(apiCookie);
        if(Objects.isNull(result) || CollectionUtils.isEmpty(result.data())) {
            return Collections.emptyList();
        }
        return result.data().stream().map(employeeMapper::mapEmployeeToDTO).toList();
    }

    public EmployeeInfoDTO getEmployeeInfo(final String apiCookie, final Long employeeId) {
        final var employeeInfo = employeeClient.getEmployeeInfo(apiCookie, employeeId).data();
        return employeeMapper.mapEmployeeToDTO(employeeInfo);
    }

}
