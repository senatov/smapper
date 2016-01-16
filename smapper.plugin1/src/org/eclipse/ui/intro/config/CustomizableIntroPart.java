package org.eclipse.ui.intro.config;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.intro.IIntroSite;

public class CustomizableIntroPart implements IIntroPart {

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IIntroSite getIntroSite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(IIntroSite site, IMemento memento) throws PartInitException {
		// TODO Auto-generated method stub

	}

	@Override
	public void standbyStateChanged(boolean standby) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveState(IMemento memento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPropertyListener(IPropertyListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getTitleImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePropertyListener(IPropertyListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
