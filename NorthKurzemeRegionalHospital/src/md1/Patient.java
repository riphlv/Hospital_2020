package md1;

import enums.Gender;
import enums.Nationality;

public class Patient extends Person {
	private int patientId;
	private static int patientCounter = 0;
	private boolean isHospitalised;
	
	//Constructors
	public Patient(String name, String surname, int[] indentificator, Gender gender, Nationality nationality, boolean isHospitalised) {
		super(name, surname, indentificator, gender, nationality);
		setPatientId();
		this.isHospitalised = isHospitalised;
	}

	//Getters and setters
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId() {
		patientId = patientCounter;
		patientCounter++;
	}
	public boolean isHospitalised() {
		return isHospitalised;
	}
	public void setHospitalised(boolean isHospitalised) {
		this.isHospitalised = isHospitalised;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", isHospitalised=" + isHospitalised + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
