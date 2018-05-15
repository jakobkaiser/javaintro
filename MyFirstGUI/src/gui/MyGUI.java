package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import data.Person;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.wb.swt.SWTResourceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyGUI {

	protected Shell shell;
	private Text vorname;
	private Text nachname;
	private Text strasse;
	private Text ort;
	private Text plz;
	private Label lblPlz;
	private Button btnNewButton_1;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyGUI window = new MyGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackgroundImage(SWTResourceManager
				.getImage("\\\\ams-gym-pfs\\schuelerprofiledata\\jakobkaiser\\Downloads\\Waiter2.jpg"));
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		shell.setSize(624, 528);
		shell.setText("SWT Application");

		Label lblVorname = new Label(shell, SWT.NONE);
		lblVorname.setBounds(10, 7, 91, 15);
		lblVorname.setText("Vorname");

		vorname = new Text(shell, SWT.BORDER);
		vorname.setBounds(148, 7, 76, 21);

		Label lblNachname = new Label(shell, SWT.NONE);
		lblNachname.setBounds(10, 47, 91, 15);
		lblNachname.setText("Nachname");

		nachname = new Text(shell, SWT.BORDER);
		nachname.setBounds(148, 47, 76, 21);

		Label lblStrasse = new Label(shell, SWT.NONE);
		lblStrasse.setBounds(10, 87, 91, 15);
		lblStrasse.setText("Strasse");

		strasse = new Text(shell, SWT.BORDER);
		strasse.setBounds(148, 87, 76, 21);

		lblPlz = new Label(shell, SWT.NONE);
		lblPlz.setBounds(10, 127, 91, 15);
		lblPlz.setText("Plz");

		plz = new Text(shell, SWT.BORDER);
		plz.setBounds(148, 127, 76, 21);

		Label lblOrt = new Label(shell, SWT.NONE);
		lblOrt.setBounds(10, 167, 91, 15);
		lblOrt.setText("Ort");

		ort = new Text(shell, SWT.BORDER);
		ort.setBounds(148, 167, 76, 21);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// System.out.println("Steckbrief von Norbert:");
				// System.out.println(getVorname().getText());
				// System.out.println(getNachname().getText());
				// System.out.println(getAdresse().getText());
				Person p = new Person();
				p.setVorname(getVorname().getText());
				p.setNachname(getNachname().getText());
				p.setStrasse(getStrasse().getText());
				p.setOrt(getOrt().getText());
				try {
					p.setPlz(Integer.parseInt(getPlz().getText()));
					// System.out.println(p);
				} catch (NumberFormatException nfe) {
					System.out.println("Fehler bei Plz");

					MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
					mb.setText("Fehler");
					mb.setMessage("PLZ im falschen Format");
					mb.open();
					System.out.println("mb closed");
				}
				Person.getPersonenListe().add(p);
				clearMask();
				//

				for (Person p1 : Person.getPersonenListe())
					System.out.println(p1);

			}

			protected void clearMask() {
				getVorname().setText("");
				getNachname().setText("");
				getStrasse().setText("");
				getOrt().setText("");
				getPlz().setText("");
			}

		});
		btnNewButton.setBounds(215, 378, 142, 25);
		btnNewButton.setText("Good Morning");

		btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Person.write2JSON();

				MessageBox mb = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
				mb.setText("Gesendet");
				mb.setMessage("Datei wurde zu JSON gesendet");
				mb.open();

			}
		});

		btnNewButton_1.setBounds(215, 347, 142, 25);
		btnNewButton_1.setText("write 2 jason");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (Person p2 : personenRead)
					System.out.println(p2);
			}
		});
		btnNewButton_2.setBounds(215, 316, 142, 25);
		btnNewButton_2.setText("Write from JSON");

	}

	protected Text getVorname() {
		return vorname;
	}

	public Text getNachname() {
		return nachname;
	}

	public Text getStrasse() {
		return strasse;
	}

	public Text getOrt() {
		return ort;
	}

	public Text getPlz() {
		return plz;

	}

	public Label getLblPlz() {
		return lblPlz;
	}

	public Button getBtnNewButton_1() {
		return btnNewButton_1;
	}
}
//test