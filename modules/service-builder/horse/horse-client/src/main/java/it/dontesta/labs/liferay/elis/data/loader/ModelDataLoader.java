package it.dontesta.labs.liferay.elis.data.loader;

import com.liferay.portal.kernel.exception.PortalException;

import java.io.IOException;

/**
 * @author amusarra
 */
public interface ModelDataLoader {
	public void loadModelData() throws IOException, PortalException;
}
