package com.example.HostelManagmentSystem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="applicantRegistration")
public class StudentRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="applicantID")
	private Long applicantID;
	
	@Column(name="studentName",nullable = false)
	private String studentName;
	
	@Column(name="collegeName",nullable = false)
	private String collegeName;
	
	
	@Column(name="branch",nullable = false)
	private String branch;

	@Column(name="classYear",nullable = false)
	private String classYear;
	
	@Column(name="age",nullable = false)
	private Integer age;
	
	@Column(name="contactNo",nullable = false)
	private Long contactNo;
	
	@Column(name="nativeAddress",nullable = false)
	private String nativeAddress;
	
	@Column(name="parentsName",nullable = false)
	private String parentsName;
	
	@Column(name="pContact",nullable = false)
	private Long pContact;
	
	@Column(name = "photoPath")
	private String photoPath;
	
	@Column(name = "feesPath")
	private String feesPath;

	public Long getApplicantID() {
		return applicantID;
	}

	public void setApplicantID(Long applicantID) {
		this.applicantID = applicantID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getClassYear() {
		return classYear;
	}

	public void setClassYear(String classYear) {
		this.classYear = classYear;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getNativeAddress() {
		return nativeAddress;
	}

	public void setNativeAddress(String nativeAddress) {
		this.nativeAddress = nativeAddress;
	}

	public String getParentsName() {
		return parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public Long getpContact() {
		return pContact;
	}

	public Long setpContact(Long object) {
		return this.pContact = (Long) object;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getFeesPath() {
		return feesPath;
	}

	public void setFeesPath(String feesPath) {
		this.feesPath = feesPath;
	}


	
	
}
