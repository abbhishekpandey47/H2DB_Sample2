package com.sample.service.format;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Schooldata {
	
	@Id
	@GeneratedValue
	private Long schoolId;
	private String schoolName;
	private int standard;
	private int studentCount;
	private int year;
	/**
	 * @return the schoolId
	 */
	public Long getSchoolId() {
		return schoolId;
	}
	/**
	 * @param schoolId the schoolId to set
	 */
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}
	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	/**
	 * @return the standard
	 */
	public int getStandard() {
		return standard;
	}
	/**
	 * @param standard the standard to set
	 */
	public void setStandard(int standard) {
		this.standard = standard;
	}
	/**
	 * @return the studentCount
	 */
	public int getStudentCount() {
		return studentCount;
	}
	/**
	 * @param studentCount the studentCount to set
	 */
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SchoolData [schoolId=" + schoolId + ", schoolName=" + schoolName + ", standard=" + standard
				+ ", studentCount=" + studentCount + ", year=" + year + "]";
	}
	/**
	 * @param schoolId
	 * @param schoolName
	 * @param standard
	 * @param studentCount
	 * @param year
	 */
	public Schooldata(Long schoolId, String schoolName, int standard, int studentCount, int year) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.standard = standard;
		this.studentCount = studentCount;
		this.year = year;
	}
	/**
	 * 
	 */
	public Schooldata() {
		super();
		// TODO Auto-generated constructor stub
	}

}
