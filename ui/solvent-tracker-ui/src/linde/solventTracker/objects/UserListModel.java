package linde.solventTracker.objects;

import java.util.HashMap;

import org.eclipse.swt.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

public class UserListModel {
	private HashMap<String, User> map;
	private Composite parent;
	private List list;

	public UserListModel(Composite parent) {
		this.parent = parent;
		list = new List(parent, SWT.NONE);
		this.map = new HashMap<String, User>();
		addSelectionListener();
	}

	private void addSelectionListener() {
		list.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				System.out.println(e.toString());
			}
			
		});
	}

	public void addUser(User user) {
		if (user.isValidUser()) {
			map.put(user.code, user);
			list.add(user.name);
		}
	}

	public User getUser(String code) {
		return map.get(code);
	}

	public boolean hasUser(String code) {
		return map.containsKey(code);
	}
}
