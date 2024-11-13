package prueba.amaris.assessment.TechnicalAssessment.infrastructure.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import prueba.amaris.assessment.TechnicalAssessment.domain.model.EmployeeInfoResponse;
import prueba.amaris.assessment.TechnicalAssessment.domain.model.EmployeeListResponse;

@FeignClient(name = "employeeClient", url = "https://dummy.restapiexample.com/api/v1")
public interface EmployeeClient {

    @GetMapping("/employees")
    EmployeeListResponse getEmployees(@RequestHeader("Cookie")String cookie);

    @GetMapping("/employee/{employeeId}")
    EmployeeInfoResponse getEmployeeInfo(@RequestHeader("Cookie")String cookie, @RequestParam final Long employeeId);
}
