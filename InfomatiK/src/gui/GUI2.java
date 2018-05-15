package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import data.Mensch;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GUI2 {
	private DataBindingContext m_bindingContext;

	protected Shell shell;
	private Text vorname;
	private Text nachname;
	private Button btnProceed;
	private Label lblAdresse;
	private Text adresse;
	private Label lblNewLabel;
	private Text ort;
	private Label lblPlz;
	private Text plz;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		shell.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\Jakob\\Pictures\\iwas\\1.jpg"));
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\Jakob\\Pictures\\iwas\\1.jpg"));
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		shell.setSize(585, 300);
		shell.setText("SWT Application");

		Label lblVorname = new Label(shell, SWT.NONE);
		lblVorname.setAlignment(SWT.CENTER);
		lblVorname.setBounds(10, 10, 76, 15);
		lblVorname.setText("Vorname");

		vorname = new Text(shell, SWT.BORDER);
		vorname.setBounds(10, 31, 76, 21);

		Label lblNachname = new Label(shell, SWT.NONE);
		lblNachname.setAlignment(SWT.CENTER);
		lblNachname.setBounds(117, 10, 76, 15);
		lblNachname.setText("Nachname");

		nachname = new Text(shell, SWT.BORDER);
		nachname.setBounds(117, 31, 76, 21);

		btnProceed = new Button(shell, SWT.NONE);
		btnProceed.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Mensch m = new Mensch();
				m.setVorname(getVorname().getText());
				m.setNachname(getNachname().getText());
				m.setOrt(getOrt().getText());
				m.setAdresse(getAdresse().getText());
				m.setPlz(Integer.parseInt(getPlz().getText()));

				Mensch.getPersonenListe().add(m);
				System.out.println(Mensch.getPersonenListe());

			}
		});
		btnProceed.setBounds(11, 194, 75, 25);
		btnProceed.setText("Proceed");

		lblAdresse = new Label(shell, SWT.NONE);
		lblAdresse.setAlignment(SWT.CENTER);
		lblAdresse.setBounds(220, 10, 76, 15);
		lblAdresse.setText("Adresse");

		adresse = new Text(shell, SWT.BORDER);
		adresse.setBounds(220, 31, 76, 21);

		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(318, 10, 76, 15);
		lblNewLabel.setText("Ort");

		ort = new Text(shell, SWT.BORDER);
		ort.setBounds(318, 31, 76, 21);

		lblPlz = new Label(shell, SWT.NONE);
		lblPlz.setAlignment(SWT.CENTER);
		lblPlz.setBounds(418, 10, 76, 15);
		lblPlz.setText("PLZ");

		plz = new Text(shell, SWT.BORDER);
		plz.setBounds(418, 31, 76, 21);

		Mensch m = new Mensch();
		m.setVorname(getVorname().getText());
		m.setNachname(getNachname().getText());

	}

	public Text getVorname() {
		return vorname;
	}

	public Text getNachname() {
		return nachname;
	}

	public Text getAdresse() {
		return adresse;
	}

	public Text getOrt() {
		return ort;
	}

	public Text getPlz() {
		return plz;
	}
}
