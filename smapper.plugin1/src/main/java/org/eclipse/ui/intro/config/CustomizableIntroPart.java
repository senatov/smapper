/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 8, 2016 - 12:46:37 AM
 * @project smapper.plugin1
 * @package org.eclipse.ui.intro.config
 * @file CustomizableIntroPart.java / CustomizableIntroPart
 ***********************************************************************************/
package org.eclipse.ui.intro.config;



import org.apache.log4j.Logger;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.intro.IIntroSite;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomizableIntroPart.
 */
public class CustomizableIntroPart implements IIntroPart {
	private static final Logger LOG = Logger.getLogger(CustomizableIntroPart.class);



	/**
	 * Gets the adapter.
	 *
	 * @param <T> the generic type
	 * @param adapter the adapter
	 * @return the adapter
	 */
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		LOG.debug("getAdapter() - not implemented yet");
		return null;
	}



	/**
	 * Gets the intro site.
	 *
	 * @return the intro site
	 */
	@Override
	public IIntroSite getIntroSite() {
		LOG.debug("getIntroSite()  - not implemented yet");
		return null;
	}



	/**
	 * Inits the.
	 *
	 * @param site the site
	 * @param memento the memento
	 * @throws PartInitException the part init exception
	 */
	@Override
	public void init(IIntroSite site, IMemento memento) throws PartInitException {
		LOG.debug("init()  - not implemented yet");
	}



	/**
	 * Standby state changed.
	 *
	 * @param standby the standby
	 */
	@Override
	public void standbyStateChanged(boolean standby) {
		LOG.debug("standbyStateChanged()");

	}



	/**
	 * Save state.
	 *
	 * @param memento the memento
	 */
	@Override
	public void saveState(IMemento memento) {
		LOG.debug("saveState() - not implemented yet");
	}



	/**
	 * Adds the property listener.
	 *
	 * @param listener the listener
	 */
	@Override
	public void addPropertyListener(IPropertyListener listener) {
		LOG.debug("addPropertyListener() - not implemented yet");
	}



	/**
	 * Creates the part control.
	 *
	 * @param parent the parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		LOG.debug("createPartControl() - not implemented yet");

	}



	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		LOG.debug("dispose() - not implemented yet");

	}



	/**
	 * Gets the title image.
	 *
	 * @return the title image
	 */
	@Override
	public Image getTitleImage() {
		LOG.debug("getTitleImage() - not implemented yet");
		return null;
	}



	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@Override
	public String getTitle() {
		LOG.debug("getTitle() - not implemented yet");
		return null;
	}



	/**
	 * Removes the property listener.
	 *
	 * @param listener the listener
	 */
	@Override
	public void removePropertyListener(IPropertyListener listener) {
		LOG.debug("removePropertyListener() - not implemented yet");
	}



	/**
	 * Sets the focus.
	 */
	@Override
	public void setFocus() {
		LOG.debug("setFocus() - not implemented yet");
	}
}
