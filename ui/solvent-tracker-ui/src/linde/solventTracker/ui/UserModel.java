package linde.solventTracker.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import linde.solventTracker.objects.User;

public class UserModel {
	private Composite userParent;
	private User current;
	private Label descID;
	private Label descName;
	private Label userID;
	private Label userName;

	UserModel(Composite p) {
		userParent = new Composite(p, SWT.NONE);
		// userParent.setLayoutData(new GridData(SWT.NONE, SWT.NONE, true,
		// false,
		// Start.nOfCols, 1));
		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		layout.pack = false;
		layout.justify = true;
		userParent.setLayout(layout);
		userParent.setBackground(Start.BLUE);
		// userParent.setBackgroundMode(SWT.INHERIT_FORCE);

		Composite nameColumn = new Composite(userParent, SWT.NONE);
		RowLayout verticalLayout = new RowLayout(SWT.VERTICAL);
		verticalLayout.justify = true;
		verticalLayout.fill = true;
		verticalLayout.pack = false;
		nameColumn.setLayout(verticalLayout);
		descName = new Label(nameColumn, SWT.HORIZONTAL);
		descName.setText("Navn");
		userName = new Label(nameColumn, SWT.HORIZONTAL);
		userName.setSize(100, 15);
		userName.setText("");
		// Composite sepColumn = new Composite(userParent, SWT.NONE);
		// sepColumn.setLayout(verticalLayout);
		// RowData rowData = new RowData();
		// rowData.height = nameColumn.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;
		// new Label(sepColumn, SWT.SEPARATOR).setLayoutData(rowData);
		// new Label(sepColumn, SWT.SEPARATOR).setLayoutData(rowData);
		Composite idColumn = new Composite(userParent, SWT.NONE);
		idColumn.setLayout(verticalLayout);
		descID = new Label(idColumn, SWT.HORIZONTAL);
		descID.setText("BrukerID");
		userID = new Label(idColumn, SWT.HORIZONTAL);
		userID.setText("");

		setCurrent(null);
	}

	public User getCurrent() {
		return current;
	}

	public void setCurrent(User current) {
		if (current == null) {
			setCurrentHidden(User.BLANK);
		} else {
			setCurrentHidden(current);
		}
	}

	private void setCurrentHidden(User current) {
		this.current = current;
		this.userID.setText(current.code);
		this.userName.setText(current.name);
	}

	public boolean isBlank() {
		return current == User.BLANK;
	}

	Composite getComposite() {
		return userParent;
	}

}
