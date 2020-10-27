package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "applicants")
public class Visamodel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long passid;
	private String applicantName;
	private int phnnum;
	private String emailId;
	
	public Visamodel() {
		
	}
	
	public Visamodel(long passid, String applicantName, int phnnum, String emailId) {
		this.passid=passid;
		this.applicantName =applicantName;
		this.phnnum = phnnum;
		this.emailId = emailId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getpassId() {
		return passid;
	}
	public void setpassId(long passid) {
		this.passid = passid;
	}
	
	@Column(name = "applicant_name", nullable = false)
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	
	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column(name = "phnnum", nullable = false)
	public int getPhnnum() {
		return phnnum;
	}

	public void setPhnnum(int phnnum) {
		this.phnnum = phnnum;
	}

	@Override
	public String toString() {
		return "Applicants [passid=" + passid + ", applicantName=" + applicantName + ", phnnum=" + phnnum + "  emailId=" + emailId
				+ "]";
	}
	
}
