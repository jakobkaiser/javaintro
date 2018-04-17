package data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Person {

	private static ArrayList<Person> personenListe = new ArrayList<>();

	public static ArrayList<Person> getPersonenListe() {
		return personenListe;
	}
	public static void write2JSON() {
		try {
			Writer writer = new FileWriter("C:\\temp\\output.json");
			Gson gson = new GsonBuilder().serializeNulls().create();
			gson.toJson(Person.getPersonenListe(), writer);
			
			writer.flush();
			writer.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
			
		}
	}

	public Person() {

	}

		// rechtsclick -> source -> getter setter 
	private String vorname;
	private String nachname;
	private String strasse;
    private String ort;
    private int plz;
    
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}


	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}


	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	// Person p = new Person();
	// p.setVorname(getVorname().getText());
	// System.out.println(p);

	// integer.parseInt
	@Override
	public String toString() {
		return getVorname() + " " + getNachname() + ", " + getStrasse() + ", " + getOrt() + ",  " + "Plz: " + getPlz();
	}
	
}
// java.com
//java runterladen JAVA8 oder so
//eclipse download packages  eclipse.org
//windowbuilder bei eclipse  4.7 Oxygen 
// HELP install new softwear enter drücken
// gson jar download V2.8.1 Jar datei
//new other swt/jface java project gui2 finish
//source package gui und data package
// in gui  new other application window GUI2
//// variablen name vorname
// in data new class Person
//// private String vorname;
//// private String nachname;
//// Für beide source -> create getter and setters
// Private static arrayliste<Person> personenListe = new Arraylist
// nur getter method
// in gui2 Person p = new Person();
//p.setNachname(getNachname().getText();
//gson datei in src ordner ziehen . rechte maustast build path add to build path
//public static void write2JSON
///