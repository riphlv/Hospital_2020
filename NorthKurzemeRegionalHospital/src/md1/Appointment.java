package md1;

import java.util.ArrayList;
import java.util.Date;

public class Appointment {
	//public static ArrayList<Patient>allPatients = new ArrayList<Patient>();
	//public static Patient patient = new Patient();
	//public static ArrayList<Doctor>allDoctors = new ArrayList<Doctor>();
	
	private int appId;
	private static int appCounter = 0;
	private Date date;
	private String description;
	private Patient patient;
	private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	
	//Constructors
	public Appointment(Date date, String description, Patient patient, ArrayList<Doctor> doctors) {
		this.date = date;
		this.description = description;
		this.patient = patient;
		this.doctors = doctors;
		setAppId();
	}
	//Getters and Setters
	public int getAppId() {
		return appId;
	}
	public void setAppId() {
		appId = appCounter;
		appCounter++;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	//Functions
	public void printInvolvedDoctors() {
		for(Doctor doctor : doctors) {
			System.out.println(doctor);
		}
	}
	public boolean addNewDoctorToAppointment(Doctor doctor) {
		if(!this.doctors.contains(doctor)) {
			this.doctors.add(doctor);
			return true;
		}
		System.out.println("Failed - Doctor already is appointed!");
		return false;
	}
	public boolean removeExistingDoctorFromAppointment(Doctor doctor) {
		for(int i = 0 ; i < doctors.size(); i++) {
			if(doctors.get(i).equals(doctor)) {
				doctors.remove(i);
			}
			return true;
		}
		return false;
	}
	//To String
	@Override
	public String toString() {
		return "Appointment [appId=" + appId + ", date=" + date + ", description=" + description + ", patient="
				+ patient + ", doctors=" + doctors + "]";
	}

	
	
}
