package md1;

import java.util.ArrayList;
import java.util.Date;

import enums.Gender;
import enums.Nationality;
import enums.Speciality;

public class Hospital {
	private String hospitalName;
	public static ArrayList<Patient> patientsInHospital = new ArrayList<Patient>();
	public static ArrayList<Doctor> doctorsInHospital = new ArrayList<Doctor>();
	public static ArrayList<Appointment> appointmentsInHospital = new ArrayList<Appointment>();
	
	//Constructor
	Hospital(String hospitalName){
		this.hospitalName = hospitalName;
	}
	//Getters and Setters
	public String getHospitalName() {
		return hospitalName;
	}


	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}


	public static ArrayList<Patient> getPatientsInHospital() {
		return patientsInHospital;
	}


	public static void setPatientsInHospital(ArrayList<Patient> patientsInHospital) {
		Hospital.patientsInHospital = patientsInHospital;
	}


	public static ArrayList<Doctor> getDoctorsInHospital() {
		return doctorsInHospital;
	}


	public static void setDoctorsInHospital(ArrayList<Doctor> doctorsInHospital) {
		Hospital.doctorsInHospital = doctorsInHospital;
	}


	public static ArrayList<Appointment> getAppointmentsInHospital() {
		return appointmentsInHospital;
	}


	public static void setAppointmentsInHospital(ArrayList<Appointment> appointmentsInHospital) {
		Hospital.appointmentsInHospital = appointmentsInHospital;
	}
	
	//Functions
	public static boolean addNewPatientInHospital(Patient patient) {
		if(!patientsInHospital.contains(patient)) {
			patientsInHospital.add(patient);
			return true;
		}
		System.out.println("Failed - Patient already exists in hospital!");
		return false;
	}
	public static boolean deleteExistingPatientInHospitalByID(int id) {
		try {
			patientsInHospital.remove(id);
			System.out.println("Success - patient successfuly removed!");
			return true;
		}catch(Exception e) {
			System.out.println("Failed - No such patient with ID found!");
			return false;
		}
	}
	public static boolean deleteExistingPatientInHospitalByObject(Patient patient) {
		try{
			patientsInHospital.remove(patient);
			System.out.println("Success - " + patient.getName() + " " + patient.getSurname() + "successfuly removed!");
			return true;
		}
		catch(Exception e) {
			System.out.println("Failed - No such patient found!");
			return false;
		}
	}
	public static boolean addNewDoctorInHospital(Doctor doctor) {
		if(doctorsInHospital.contains(doctor)) {
			System.out.println("Failed - Doctor already exists!");
			return false;
		}
		doctorsInHospital.add(doctor);
		System.out.println("Success - Doctor successfuly added!");
		return true;
	}
	public static boolean deleteExistingDoctorInHospitalByID(int id) {
		try{
			doctorsInHospital.remove(id);
			System.out.println("Success - " + doctorsInHospital.get(id).getName() + " " + doctorsInHospital.get(id).getSurname() + "successfuly removed!");
			return true;
		}
		catch(Exception e) {
			System.out.println("Failed - No such doctor found!");
			return false;
		}
	}
	public static boolean deleteExistingDoctorInHospitalByObject(Doctor doctor) {
		try{
			doctorsInHospital.remove(doctor);
			System.out.println("Success - " + doctor.getName() + " " + doctor.getSurname() + "successfuly removed!");
			return true;
		}
		catch(Exception e) {
			System.out.println("Failed - No such doctor found!");
			return false;
		}
	}
	public static void generateDoctorsInHospital() {
		//TODO finish adding stuff
		//Doctor d1 = new Doctor("Janis", "Berzins",null, Gender.female,Nationality.Latvian,Speciality.Heart,(short)1);
	}
	public static boolean makeNewAppointment(Patient patient, Date date, String description, ArrayList<Doctor>doctors) {
		try {
			appointmentsInHospital.add(new Appointment(date, description, patient, doctors));
			return true;
		}catch(Exception e) {
			System.out.println("Failed - Incorrect appointment data!");
			return false;
		}
	}
	public static boolean deleteExistingAppointment(Patient patient, Date date) {
		for(int i = 0 ; i < appointmentsInHospital.size(); i++) {
			if(appointmentsInHospital.get(i).getPatient().equals(patient) && appointmentsInHospital.get(i).getDate().equals(date)) {
				appointmentsInHospital.remove(i);
				return true;
			}
		}
		System.out.println("Failed - No related appointments found!");
		return false;
	}
	public static void printAllPatientsInHospital() {
		for(Patient patient : patientsInHospital) {
			System.out.println(patient);
		}
	}
	public static void printAllDoctorsInHospital() {
		for(Doctor doctors : doctorsInHospital) {
			System.out.println(doctors);
		}
	}
	public static void printAllAppointmentsInHospital() {
		for(Appointment appointment : appointmentsInHospital) {
			System.out.println(appointment);
		}
	}
	public static void printAllPatientForDate(Date date) {
		for(Appointment appointment : appointmentsInHospital) {
			if(appointment.getDate().equals(date)) {
				System.out.println(appointment);
			}
		}
	}
	public static void printAllAppointmentsForPatient(Patient patient) {
		for(Appointment appointment : appointmentsInHospital) {
			if(appointment.getPatient().equals(patient)) {
				System.out.println(appointment);
			}
		}
	}
	//public static void generateAndPrintDayPlanForDoctor(Doctor,Date) {
	//	
	//}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
