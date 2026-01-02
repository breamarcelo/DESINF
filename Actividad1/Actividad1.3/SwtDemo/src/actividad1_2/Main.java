package actividad1_2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Actividad 1.2 - SWT");
		Label label = new Label(shell, SWT.NONE);
		label.setText("Selecciona un puesto:");
		Combo combo = new Combo(shell, SWT.NONE);
		combo.add("C209-5");
		combo.add("C209-18");
		combo.add("C209-19");
		
		Listener seleccion = e -> {
			Shell dialog = new Shell(shell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			Label respuesta = new Label(dialog, SWT.NONE);
			respuesta.setText("Puesto seleccionado: " + combo.getText());
			
			Listener cerrarDialog = em -> {
				dialog.close();
			};
			Button ok = new Button(dialog, SWT.NONE);
			ok.setText("OK");
			ok.addListener(SWT.Selection, cerrarDialog);
			dialog.setDefaultButton(ok);
			
			dialog.setLayout(new RowLayout());
			dialog.pack();
			dialog.open();
		};
		
		Button boton = new Button(shell, SWT.NONE);
		boton.setText("ENVIAR");
		boton.addListener(SWT.Selection, seleccion);
		shell.setLayout(new RowLayout());
		//shell.pack();
		shell.setBounds(300, 300, 200, 150);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}

}
