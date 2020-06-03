package edu.miu.cs425.eRegistrar.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table (name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@NotBlank(message = "StudentNumber is required")
	@Column ( name = "studentNumbers", nullable = false, unique = true)
	private String studentNumber;
	
	@NotBlank
	private String fName;

	@NotBlank
	private String isInternational;
	
	
	private String middleName;
	
	@NotBlank
	private String lastName;
	
	private Double cGpa;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfEnrollment;
	

	
	
	public Student(Long studentId, String studentNumber, String fName, String middleName, String lastName, Double cGpa,
			LocalDate dateOfEnrollment, String isInternational) {
		super();
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.fName = fName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cGpa = cGpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.isInternational = isInternational;

	}


	public Student() {
		super();
	}

	

	
	public Student(@NotBlank(message = "StudentNumber is required") String studentNumber, @NotBlank String fName,
			@NotBlank String lastName, LocalDate dateOfEnrollment, String isInternational) {
		super();
		this.studentNumber = studentNumber;
		this.fName = fName;
		this.lastName = lastName;
		this.dateOfEnrollment = dateOfEnrollment;
		this.isInternational = isInternational;

	}


	public Student(@NotBlank String studentNumber, @NotBlank String fName, String middleName, @NotBlank String lastName,
			Double cGpa, @NotBlank LocalDate dateOfEnrollment, String isInternational) {
		super();
		this.studentNumber = studentNumber;
		this.fName = fName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cGpa = cGpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.isInternational = isInternational;

	}


	public Student(Long studentId, String studentNumber, String fName, String middleName, String lastName, String isInternational) {
		super();
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.fName = fName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.isInternational = isInternational;

	}


	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public String getStudentNumber() {
		return studentNumber;
	}


	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Double getcGpa() {
		return cGpa;
	}


	public void setcGpa(Double cGpa) {
		this.cGpa = cGpa;
	}


	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}


	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public String getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(String isInternational) {
		this.isInternational = isInternational;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentNumber='" + studentNumber + '\'' +
				", fName='" + fName + '\'' +
				", isInternational='" + isInternational + '\'' +
				", middleName='" + middleName + '\'' +
				", lastName='" + lastName + '\'' +
				", cGpa=" + cGpa +
				", dateOfEnrollment=" + dateOfEnrollment +
				'}';
	}
}
