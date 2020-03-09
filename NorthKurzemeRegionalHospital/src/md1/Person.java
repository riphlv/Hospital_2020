package md1;
import java.util.Arrays;

import enums.Gender;
import enums.Nationality;

public class Person {
	private String name;
	private String surname;
	private int[] indentificator;
	private Gender gender;
	private Nationality nationality;
	
	//Constructors
	public Person() {
		name = null;
		surname = null;
		indentificator = null;
		gender = null;
		nationality = null;
	}
	public Person(String name,String surname,int[] indentificator) {
		this.name = name;
		this.surname = surname;
		this.indentificator = indentificator;
		this.gender = null;
		this.nationality = null;
	}
	public Person(String name, String surname, int[] indentificator, Gender gender, Nationality nationality) {
		this.name = name;
		this.surname = surname;
		this.indentificator = indentificator;
		this.gender = gender;
		this.nationality = nationality;
	}
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int[] getIndentificator() {
		return indentificator;
	}
	public void setIndentificator(int[] indentificator) {
		this.indentificator = indentificator;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	//To String
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", indentificator=" + Arrays.toString(indentificator)
				+ ", gender=" + gender + ", nationality=" + nationality + "]";
	}
	
	
}
