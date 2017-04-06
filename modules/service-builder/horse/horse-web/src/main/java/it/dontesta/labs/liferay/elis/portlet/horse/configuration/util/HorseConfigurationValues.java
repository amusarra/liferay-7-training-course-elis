/**
 * 
 */
package it.dontesta.labs.liferay.elis.portlet.horse.configuration.util;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author amusarra
 *
 */
public class HorseConfigurationValues {
	public static final int HORSE_SEARCH_CONTAINER_PAGE_DEFAULT_DELTA = 
			GetterUtil.getInteger(
				HorseConfigurationUtil.get(
					HorseConfigurationKeys.HORSE_SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
}
