package data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

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

	public static void readFromJSON(){
		try {
			Writer writer = new FileWriter("C:\\temp\\output.json");
			Gson gson = new GsonBuilder().serializeNulls().create();

			ArrayList<Person> personen = new ArrayList<>();
			//
			gson.toJson(personen, writer);
			//
			writer.flush();
			writer.close();
			//
			Reader r = new FileReader("C:\\temp\\output.json");
			ArrayList<Person> personenRead = new ArrayList<>();
			Type listType = new TypeToken<ArrayList<Person>>() {
			}.getType();
			personenRead = gson.fromJson(r, listType);
			for (Person p2 : personenRead)
				System.out.println(p2);
			System.out.println("---------------");
			for (Person p2 : personenRead)
				System.out.println(p2);

		} catch (IOException e) {
			e.printStackTrace();
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
// java runterladen JAVA8 oder so
// eclipse download packages eclipse.org
// windowbuilder bei eclipse 4.7 Oxygen
// HELP install new softwear enter drücken
// gson jar download V2.8.1 Jar datei
// new other swt/jface java project gui2 finish
// source package gui und data package
// in gui new other application window GUI2
//// variablen name vorname
// in data new class Person
//// private String vorname;
//// private String nachname;
//// Für beide source -> create getter and setters
// Private static arrayliste<Person> personenListe = new Arraylist
// nur getter method
// in gui2 Person p = new Person();
// p.setNachname(getNachname().getText();
// gson datei in src ordner ziehen . rechte maustast build path add to build
// path
// public static void write2JSON
///
// ArrayList<Person>
// Reader r = new FileReader(_.._);
// personenRead = gson.fromJson(json, idk dog Arraylist<Person>>(){}.getType();
// AL<Person> personenRead=new AL<>();
// for (P p2 : personenR)
// syso p2
// public static void readFromJSON(){
// personenListe = readFromJSON
// }
// button machen aus Datei lesen
//private List GuiListe
//get GuiListe()