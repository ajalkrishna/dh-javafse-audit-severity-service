package com.cognizant.auditseverity.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.cognizant.auditseverity.model.AuditRequest;
import com.cognizant.auditseverity.model.AuditResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuditRequestData {

	@Id
	@GeneratedValue
	private long auditId;
	
	private String projectName;
	private String projectManagerName;
	private String applicationOwnerName;
	private String auditType;
	private String auditDate;
	private int yesCount;
	private int noCount;
	private String projectExcecutionStatus;
	private String remedialActionDuration;
	
	public AuditRequestData(AuditRequest request,AuditResponse response) {
		this.auditId=request.getAuditId();
		this.projectName = request.getProjectName();
		this.applicationOwnerName=request.getApplicationOwnerName();
		this.projectManagerName = request.getProjectManagerName();
		this.applicationOwnerName=request.getApplicationOwnerName();
		this.auditType=request.getAuditType();
		this.auditDate=request.getAuditDate();
		this.yesCount=request.getYesCount();
		this.noCount=request.getNoCount();
		this.projectExcecutionStatus=response.getProjectExcecutionStatus();
		this.remedialActionDuration=response.getRemedialActionDuration();
		
	}
}
