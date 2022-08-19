package com.cognizant.auditseverity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.auditseverity.entity.AuditRequestData;
import com.cognizant.auditseverity.model.AuditRequest;
import com.cognizant.auditseverity.model.AuditResponse;
import com.cognizant.auditseverity.repository.AuditRequestRepository;
import com.cognizant.auditseverity.service.AuditService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/audit-severity")
@Slf4j
public class AuditSeverityController {
	
	@Autowired
	private AuditRequestRepository repo;
	
	@Autowired
	private AuditService auditService;

	@PostMapping("/ProjectExcecutionStatus")
	public ResponseEntity<AuditResponse> getProjectExcecutionStatus(@RequestBody AuditRequest request) {
		if(request==null) {
			log.info("invalid audit request");
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		else {
			AuditResponse auditResponse = auditService.validateAuditRequest(request);
			try {
				AuditRequestData save = repo.save(new AuditRequestData(request,auditResponse));
				auditResponse.setAuditId(save.getAuditId());
				}
			catch(Exception ex) {
				log.info("Couldn't save the request");
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
			log.info("Audit response generated");
			return new ResponseEntity<AuditResponse>(auditResponse, HttpStatus.OK);
		}
	}
	
	@GetMapping("/PastAuditRequests")
	public ResponseEntity<List<AuditRequestData>> getPastAuditRequest() {
		List<AuditRequestData> auditRequests;
		try {
			auditRequests = repo.findAll();
			log.info("past audit requests available");
		}
		catch(Exception ex) {
			log.info("Could't find audit requests");
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
		return new ResponseEntity<List<AuditRequestData>>(auditRequests,HttpStatus.OK);
	}
}
