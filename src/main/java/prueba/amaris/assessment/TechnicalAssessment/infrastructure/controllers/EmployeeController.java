package prueba.amaris.assessment.TechnicalAssessment.infrastructure.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prueba.amaris.assessment.TechnicalAssessment.application.dtos.EmployeeInfoDTO;
import prueba.amaris.assessment.TechnicalAssessment.application.service.EmployeeService;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @CrossOrigin
    @GetMapping("/employeesInformation")
    public ResponseEntity<List<EmployeeInfoDTO>> getEmployees(@RequestHeader(value = "Cookie", required = false)String cookie) {
        if(Objects.isNull(cookie) || cookie.trim().isEmpty()){
            cookie = "humans_21909=1";
        }
        final var result = employeeService.getEmployees(cookie);
       return ResponseEntity.ok(result);
    }

    @CrossOrigin
    @GetMapping("/{employeeId}/info")
    public ResponseEntity<EmployeeInfoDTO> getEmployeeInfo(@RequestHeader(value = "Cookie", required = false) String apiCookie,
                                        @PathVariable(value = "employeeId") final Long employeeId) {
        if(Objects.isNull(apiCookie) || apiCookie.trim().isEmpty()){
            apiCookie = "humans_21909=1";
        }
        final var result = employeeService.getEmployeeInfo(apiCookie, employeeId);
        return ResponseEntity.ok(result);
    }
}
