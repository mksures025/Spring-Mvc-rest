package com.te.ems.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.dto.EmployeeDTO;
import com.te.ems.dto.RegisterationDTO;
import com.te.ems.service.EmployeeService;
import com.te.ems.success.SuccessResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/app/employee")
@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	// display the detail which we want to get from user

	@GetMapping(path = "/dummy", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public RegisterationDTO dummy() {
		return new RegisterationDTO();
	}

	// get the detail from user and store the datail in data base
	@PostMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<SuccessResponse> register(@RequestBody RegisterationDTO registerationDTO) {

		String employeeId = registerationDTO.getEmployeeId();
		employeeId = employeeService.registerData(registerationDTO);

		return ResponseEntity.ok().body(SuccessResponse.builder().message("A simple message").data(registerationDTO)
				.status(HttpStatus.CREATED).timestamp(LocalDateTime.now().toString()).build());
	}

	// get the employee detail from database
	@GetMapping(path = "/{EmployeeId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }

	)

	public ResponseEntity<SuccessResponse> getEmployee(@PathVariable String EmployeeId) {

		EmployeeDTO employee = employeeService.getEmployee(EmployeeId);
		ResponseEntity<SuccessResponse> responseEntity = ResponseEntity.ok()
				.body(SuccessResponse.builder().message("A get message").data(employee).status(HttpStatus.OK)
						.timestamp(LocalDateTime.now().toString()).build());

		return responseEntity;

	}

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<SuccessResponse> update(@RequestBody RegisterationDTO registerationDTO) {

		String update = employeeService.updateData(registerationDTO.getEmployeeId(),
				registerationDTO.getEmployeeName());

		return ResponseEntity.ok().body(SuccessResponse.builder().message("update successful").status(HttpStatus.OK)
				.data(registerationDTO).timestamp(LocalDateTime.now().toString()).build());

	}

	@DeleteMapping(path = "/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<SuccessResponse> delete(@PathVariable String employeeId) {

		String deleteID = employeeService.deleteDetail(employeeId);

		return ResponseEntity.ok().body(SuccessResponse.builder().message("Record deleted").status(HttpStatus.OK)
				.data(employeeId).timestamp(LocalDateTime.now().toString()).build());
	}

}
