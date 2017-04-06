/**
 * 
 */

package it.dontesta.labs.liferay.elis.servicebuilder.permission;

import java.util.Date;

import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.security.permission.PermissionUpdateHandler;
import com.liferay.portal.kernel.util.GetterUtil;

import it.dontesta.labs.liferay.elis.servicebuilder.model.Horse;
import it.dontesta.labs.liferay.elis.servicebuilder.service.HorseLocalService;

/**
 * @author amusarra
 */
public class HorsePermissionUpdateHandler implements PermissionUpdateHandler {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.liferay.portal.kernel.security.permission.PermissionUpdateHandler#
	 * updatedPermission(java.lang.String)
	 */
	@Override
	public void updatedPermission(String primKey) {

		Horse Horse =
			_HorseLocalService.fetchHorse(
				GetterUtil.getLong(primKey));

		if (Horse == null) {
			return;
		}

		Horse.setModifiedDate(new Date());

		_HorseLocalService.updateHorse(Horse);
	}

	@Reference(unbind = "-")
	protected void setHorseLocalService(
		HorseLocalService HorseLocalService) {

		_HorseLocalService = HorseLocalService;
	}

	private HorseLocalService _HorseLocalService;

}
