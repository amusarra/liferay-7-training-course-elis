/**
 * 
 */

package it.dontesta.labs.liferay.elis.portlet.horse.configuration.util;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;

/**
 * @author amusarra
 */
public class HorseConfigurationUtil {

	public static String get(String key) {

		return _configuration.get(key);
	}

	private static final Configuration _configuration =
		ConfigurationFactoryUtil.getConfiguration(
			HorseConfigurationUtil.class.getClassLoader(), "portlet");
}
