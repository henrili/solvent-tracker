package linde.solventTracker.ui;

import org.eclipse.swt.widgets.Composite;

public abstract class Model {
	Composite modelParent;
	public Model(Composite parent) {
		this.modelParent=parent;
	}
}
