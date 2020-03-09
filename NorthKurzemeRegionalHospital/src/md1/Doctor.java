package md1;

import enums.Gender;
import enums.Speciality;
import enums.Nationality;

public class Doctor extends Person {
	private short officeNum;
	private int doctorId;
	private static int doctorCounter = 0;
	private Speciality speciality;
	
	//Constructors 
	public Doctor(String name, String surname, int[] indentificator, Gender gender, Nationality nationality,
			Speciality speciality, short officeNum) {
		super(name, surname, indentificator, gender, nationality);
		this.officeNum = officeNum;
		this.speciality = speciality;
		setDoctorId();
	}
	// Getters and Setters
	public short getOfficeNum() {
		return officeNum;
	}
	public void setOfficeNum(short officeNum) {
		this.officeNum = officeNum;
	}
	public int getDocturId() {
		return doctorId;
	}
	public void setDoctorId() {
		doctorId = doctorCounter;
		doctorCounter++;
	}
	public Speciality getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	//To String
	@Override
	public String toString() {
		return "Doctor [officeNum=" + officeNum + ", doctorId=" + doctorId + ", speciality=" + speciality
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
