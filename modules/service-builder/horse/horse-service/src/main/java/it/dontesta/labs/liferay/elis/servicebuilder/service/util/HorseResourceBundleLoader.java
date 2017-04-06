/**
 * 
 */

package it.dontesta.labs.liferay.elis.servicebuilder.service.util;

import com.liferay.portal.kernel.util.ClassResourceBundleLoader;

/**
 * @author amusarra
 */
public class HorseResourceBundleLoader extends ClassResourceBundleLoader {

	public static final HorseResourceBundleLoader INSTANCE =
		new HorseResourceBundleLoader();

	protected HorseResourceBundleLoader() {
		super("content.Language", HorseResourceBundleLoader.class);
	}

}
