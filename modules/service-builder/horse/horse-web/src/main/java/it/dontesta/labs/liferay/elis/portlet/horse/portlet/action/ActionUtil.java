/**
 * 
 */

package it.dontesta.labs.liferay.elis.portlet.horse.portlet.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import it.dontesta.labs.liferay.elis.servicebuilder.model.Horse;
import it.dontesta.labs.liferay.elis.servicebuilder.service.HorseServiceUtil;

/**
 * @author amusarra
 */
public class ActionUtil {

	public static List<Horse> getEntries(HttpServletRequest request)
		throws Exception {

		long[] entryIds = ParamUtil.getLongValues(request, "rowIdsHorse");

		List<Horse> entries = new ArrayList<Horse>();

		for (long entryId : entryIds) {
			Horse entry = HorseServiceUtil.getHorse(entryId);

			entries.add(entry);
		}

		return entries;
	}

	public static List<Horse> getEntries(PortletRequest portletRequest)
		throws Exception {

		HttpServletRequest request =
			PortalUtil.getHttpServletRequest(portletRequest);

		return getEntries(request);
	}

	public static Horse getEntry(HttpServletRequest request)
		throws Exception {

		long entryId = ParamUtil.getLong(request, "entryId");

		Horse entry = null;

		if (entryId > 0) {
			entry = HorseServiceUtil.getHorse(entryId);
		}

		return entry;
	}

	public static Horse getEntry(PortletRequest portletRequest)
		throws Exception {

		HttpServletRequest request =
			PortalUtil.getHttpServletRequest(portletRequest);

		return getEntry(request);
	}
}
