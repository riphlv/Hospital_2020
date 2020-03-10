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
		if(!patientsInHospital.contains(patient) || patient.isHospitalised() == true) {
			patient.setHospitalised(true);
			patientsInHospital.add(patient);
			System.out.println("Success - Patient "+patient.getName()+" "+patient.getSurname() +" successfuly added!");
			return true;
		}
		System.out.println("Failed - Patient already exists in hospital!");
		return false;
	}
	public static boolean deleteExistingPatientInHospitalByID(int id) {
		for(int i = 0; i < patientsInHospital.size();i++) {
			if(patientsInHospital.get(i).getPatientId() == id) {
				String tempName = patientsInHospital.get(id).getName();
				String tempSurname = patientsInHospital.get(id).getSurname();
				patientsInHospital.remove(i);
				System.out.println("Success - Patient "+ tempName+" "+ tempSurname +" successfuly removed!");
				return true;
			}
		}
		System.out.println("Failed - No such patient with ID found!");
		return false;
	}
	public static boolean deleteExistingPatientInHospitalByObject(Patient patient) {
		try{
			patientsInHospital.remove(patient);
			System.out.println("Success - " + patient.getName() + " " + patient.getSurname() + " successfuly removed!");
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
		System.out.println("Success - Doctor "+doctor.getName()+ " " +doctor.getSurname() +" successfuly added!");
		return true;
	}
	public static boolean deleteExistingDoctorInHospitalByID(int id) {
		for(int i = 0; i < doctorsInHospital.size();i++) {
			if(doctorsInHospital.get(i).getDoctorId() == id) {
				String tempName = doctorsInHospital.get(id).getName();
				String tempSurname = doctorsInHospital.get(id).getSurname();
				doctorsInHospital.remove(i);
				System.out.println("Success - Doctor "+tempName +" "+ tempSurname +" successfuly removed!");
				return true;
			}
		}
		System.out.println("Failed - No such patient with ID found!");
		return false;
	}
	public static boolean deleteExistingDoctorInHospitalByObject(Doctor doctor) {
		try{
			doctorsInHospital.remove(doctor);
			System.out.println("Success - Doctor " + doctor.getName() + " " + doctor.getSurname() + " successfuly removed!");
			return true;
		}
		catch(Exception e) {
			System.out.println("Failed - No such doctor found!");
			return false;
		}
	}
	public static void generateDoctorsInHospital() {
		Doctor d1 = new Doctor("Janis", "Berzins",new int[1], Gender.male,Nationality.Latvian,Speciality.Heart,(short)1);
		Doctor d2 = new Doctor("Evelin", "Eha",new int[1], Gender.female,Nationality.Estonian,Speciality.Heart,(short)2);
		Doctor d3 = new Doctor("Girts", "Ozolins",new int[1], Gender.male,Nationality.Latvian,Speciality.Heart,(short)3);
		Doctor d4 = new Doctor("Marija", "Eglite",new int[1], Gender.female,Nationality.Latvian,Speciality.Kid,(short)4);
		Doctor d5 = new Doctor("Oliver", "Aavik",new int[1], Gender.male,Nationality.Estonian,Speciality.Kid,(short)5);
		Doctor d6 = new Doctor("Dagnija", "Krumina",new int[1], Gender.female,Nationality.Latvian,Speciality.Kid,(short)6);
		addNewDoctorInHospital(d1);
		addNewDoctorInHospital(d2);
		addNewDoctorInHospital(d3);
		addNewDoctorInHospital(d4);
		addNewDoctorInHospital(d5);
		addNewDoctorInHospital(d6);
	}
	public static boolean makeNewAppointment(Patient patient, Date date, String description, ArrayList<Doctor>doctors) {
		try {
			appointmentsInHospital.add(new Appointment(date, description, patient, doctors));
			System.out.println("Appointment created!");
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
				System.out.println("Appointment deleted!");
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
		generateDoctorsInHospital();
		addNewPatientInHospital(new Patient("Zuzanna", "Ozola", new int[1], Gender.female, Nationality.Latvian, false));
		addNewPatientInHospital(new Patient("Liga", "Kalnina", new int[1], Gender.female, Nationality.Latvian, false));
		addNewPatientInHospital(new Patient("Kriss", "Berzins", new int[1], Gender.male, Nationality.Latvian, false));
		addNewPatientInHospital(new Patient("Linda", "Eglite", new int[1], Gender.female, Nationality.Latvian, false));
		//printAllDoctorsInHospital();
		//printAllPatientsInHospital();
		deleteExistingDoctorInHospitalByID(5);
		deleteExistingPatientInHospitalByID(3);
		
		Patient tempPatient = new Patient("Linda", "Eglite", new int[1], Gender.female, Nationality.Latvian, false);
		addNewPatientInHospital(tempPatient);
		Doctor tempDoctor = new Doctor("Dagnija", "Krumina",new int[1], Gender.female,Nationality.Latvian,Speciality.Kid,(short)6);
		addNewDoctorInHospital(tempDoctor);
		
		deleteExistingPatientInHospitalByObject(tempPatient);
		deleteExistingDoctorInHospitalByObject(tempDoctor);
		
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		doctorList.add(getDoctorsInHospital().get(1));
		doctorList.add(getDoctorsInHospital().get(2));
		Date tempDate = new Date();
		makeNewAppointment(getPatientsInHospital().get(1),tempDate, "medical checkup", doctorList);
		makeNewAppointment(getPatientsInHospital().get(2),tempDate, "medical checkup", doctorList);
		makeNewAppointment(getPatientsInHospital().get(0),tempDate, "medical checkup", doctorList);
		printAllAppointmentsInHospital();
		deleteExistingAppointment(getPatientsInHospital().get(1),tempDate );
		
		printAllDoctorsInHospital();
		printAllPatientsInHospital();
		printAllAppointmentsInHospital();
		
	}
}
