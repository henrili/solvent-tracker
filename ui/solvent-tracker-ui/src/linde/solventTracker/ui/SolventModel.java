package linde.solventTracker.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import linde.solventTracker.objects.Solvent;

public class SolventModel {
	private Composite parent;
	private Solvent current = null;
	private Label descID;
	private Label descName;
	private Label userID;
	private Label userName;

	SolventModel(Composite p) {
		parent = new Composite(p, SWT.NONE);
		parent.setLayoutData(new GridData(SWT.NONE, SWT.NONE, true, false,
				Start.nOfCols, 1));
		parent.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Composite nameColumn = new Composite(parent, SWT.NONE);
		nameColumn.setLayout(new RowLayout(SWT.VERTICAL));
		descName = new Label(nameColumn, SWT.HORIZONTAL);
		descName.setText("Navn");
		userName = new Label(nameColumn, SWT.HORIZONTAL);
		userName.setText("");
		Composite sepColumn = new Composite(parent, SWT.NONE);
		sepColumn.setLayout(new RowLayout(SWT.VERTICAL));
		RowData rowData = new RowData();
		rowData.height = descName.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;
		new Label(sepColumn, SWT.SEPARATOR).setLayoutData(rowData);
		new Label(sepColumn, SWT.SEPARATOR).setLayoutData(rowData);
		Composite idColumn = new Composite(parent, SWT.NONE);
		idColumn.setLayout(new RowLayout(SWT.VERTICAL));
		descID = new Label(idColumn, SWT.HORIZONTAL);
		descID.setText("BrukerID");
		userID = new Label(idColumn, SWT.HORIZONTAL);
		userID.setText("");
	}

	public Solvent getCurrent() {
		return current;
	}

	public void setCurrent(Solvent current) {
		if (current == null) {
			setCurrentHidden(Solvent.BLANK);
		} else {
			setCurrentHidden(current);
		}
	}

	private void setCurrentHidden(Solvent current) {
		this.current = current;
		this.userID.setText(current.code);
		this.userName.setText(current.name);
	}

	public boolean isBlank() {
		return current == Solvent.BLANK;
	}

	Composite getComposite() {
		return parent;
	}

}
