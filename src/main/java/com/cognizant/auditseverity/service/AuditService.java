package com.cognizant.auditseverity.service;

import org.springframework.stereotype.Service;

import com.cognizant.auditseverity.model.AuditRequest;
import com.cognizant.auditseverity.model.AuditResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuditService {

	public AuditResponse validateAuditRequest(AuditRequest request) {
		AuditResponse auditResponse;
		if(request.getNoCount()<=3) {
			 auditResponse= new AuditResponse(request.getAuditId(),"GREEN","No Action Needed");
			 log.info("No action need to be taken");
		}
		else {
			auditResponse = new AuditResponse(request.getAuditId(),"RED","Action to be taken within 2 Weeks.");
			log.info("Action to be taken within 2 Weeks.");
		}
		return auditResponse;
	}
}
