package gui;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import data.Person;

public class JSONTest {

	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("C:\\temp\\output.json");
			Gson gson = new GsonBuilder().serializeNulls().create();

			ArrayList<Person> personen = new ArrayList<>();
			Person p = new Person();
			p.setVorname("Cementer");
			p.setNachname("Fenster Runter");
			p.setPlz(1180);
			p.setStrasse("Haselnussstrasse");
			p.setOrt("Albanien");

			personen.add(p);
			p = new Person();
			p.setVorname("Cementer1");
			p.setNachname("Fenster Runter");
			p.setPlz(1180);
			p.setStrasse("Haselnussstrasse");
			p.setOrt("Albanien");
			
			personen.add(p);
			p = new Person();
			p.setVorname("Cementer2");
			p.setNachname("Fenster Runter");
			p.setPlz(1180);
			p.setStrasse("Haselnussstrasse");
			p.setOrt("Albanien");
			personen.add(p);

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

}
