package linde.solventTracker.ui;

import linde.solventTracker.objects.User;
import linde.solventTracker.objects.UserListModel;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;

public class Start {
	public static final int nOfCols = 3;
	private static Display mainDisplay = new Display();
	public static final Color RED   = new Color(mainDisplay, new RGB(255, 0, 0));
	public static final Color GREEN = new Color(mainDisplay, new RGB(0, 255, 0));
	public static final Color BLUE  = new Color(mainDisplay, new RGB(0, 0, 255));
	public static final Color PURPLE  = new Color(mainDisplay, new RGB(255, 0, 255));
	public static final Color CYAN  = new Color(mainDisplay, new RGB(0, 255, 255));
	public static final Color BLACK  = new Color(mainDisplay, new RGB(0, 0, 0));
	public static final Color WHITE  = new Color(mainDisplay, new RGB(255, 255, 255));
	
	public static void main(String[] args) {
		new Start();
	}

	static User henrik = new User("NTNU562290", "Henrik Linde");
	private Shell window;
	private Composite leftParent;
	private Composite rightParent;
	private Text inputField;
	private UserModel user;
	private Label rightLabel;

	// private Label topText;

	private Start() {
		initMainWindow();
		initLeftHalfWindow();
		initRightHalfWindow();
		
		runEventLoop();
	}

	private void initLeftHalfWindow() {
		leftParent = new Composite(window, SWT.NONE);
		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.fill=true;
		leftParent.setLayout(layout);
		leftParent.setBackground(GREEN);

		inputField = new Text(leftParent, SWT.NONE);
		inputField.setMessage("solvent / user-ID");
		FontData fd = inputField.getFont().getFontData()[0];
		fd.setHeight(15);
		inputField.setFont(new Font(mainDisplay, fd));
		inputField.setLayoutData(new RowData(200,20));

		user = new UserModel(leftParent);
		genToggleButton(leftParent);
	}
	private void initRightHalfWindow() {
		rightParent = new Composite(window, SWT.NONE);
		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.fill=true;
		rightParent.setLayout(layout);
		rightParent.setBackground(CYAN);

		rightLabel = new Label(rightParent, SWT.NONE);
		rightLabel.setText("SCHNØDIFLØDI");
		FontData fd = rightLabel.getFont().getFontData()[0];
		fd.setHeight(15);
		rightLabel.setFont(new Font(mainDisplay, fd));
		rightLabel.setLayoutData(new RowData(200,20));
		UserListModel uList = new UserListModel(rightParent);
		uList.addUser(henrik);
		uList.addUser(User.BLANK);
		genExitButton(rightParent);
	}

	private void initMainWindow() {

		window = new Shell(mainDisplay);
		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		layout.fill=true;
		window.setLayout(layout);
		window.setText("Linde's solvent tracer");
		window.setBackground(RED);


	}

	private void genToggleButton(Composite p) {
		Button toggleUser = new Button(p, SWT.PUSH);
		toggleUser.setText("Toggle");
//		toggleUser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		toggleUser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (user.isBlank()){
					user.setCurrent(henrik);
				} else 
				user.setCurrent(User.BLANK);
			}
		});
	}

	private void genExitButton(Composite p) {
		Button exitButton = new Button(p, SWT.PUSH);
		exitButton.setText("Exit!");
//		exitButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				exit();
				return;
//				MessageBox mb = new MessageBox(topShell, SWT.ICON_WARNING
//						| SWT.YES | SWT.NO);
//				mb.setText("Avslutte");
//				mb.setMessage("Er du sikker på at du vil avslutte?");
//				int reply = mb.open();
//				if (reply == SWT.YES) {
//					exit();
//				}
			}
		});
	}

	private void runEventLoop() {
		window.pack();
		window.open();
		window.setFocus();
		while (!window.isDisposed()) {
			if (!mainDisplay.readAndDispatch())
				mainDisplay.sleep();
		}
		mainDisplay.dispose();
	}

	void exit() {
		window.dispose();
	}
}