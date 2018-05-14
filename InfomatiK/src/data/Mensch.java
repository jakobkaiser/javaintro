package data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Mensch {

	private static ArrayList<Mensch> personenListe = new ArrayList<>();

	public static ArrayList<Mensch> getPersonenListe() {
		return personenListe;
	}

	private String vorname;
	private String nachname;
	private String ort;
    private int plz;
	private String adresse;
    
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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


	@Override
	public String toString() {
		return getVorname() + " " + getNachname() + ", " + getAdresse() + ", " + getOrt() + ",  " + "Plz: " + getPlz();
	}

	public static void write2JSON() {
		try {
			Writer writer = new FileWriter("C:\\temp\\output.json");
			Gson gson = new GsonBuilder().serializeNulls().create();
			gson.toJson(Mensch.getPersonenListe(), writer);

			writer.flush();
			writer.close();

		} catch (IOException e1) {
			e1.printStackTrace();

		}
	}

}
