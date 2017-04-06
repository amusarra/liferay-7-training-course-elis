/**
 * 
 */

package it.dontesta.labs.liferay.elis.servicebuilder.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import it.dontesta.labs.liferay.elis.portlet.horse.constants.HorsePortletKeys;
import it.dontesta.labs.liferay.elis.servicebuilder.model.Horse;
import it.dontesta.labs.liferay.elis.servicebuilder.service.HorseLocalService;

/**
 * @author amusarra
 */
@Component(
	immediate = true,
	property = {"model.class.name=it.dontesta.labs.liferay.elis.servicebuilder.model.Horse"}
)
public class HorsePermissionChecker implements BaseModelPermissionChecker {

	public static void check(
		PermissionChecker permissionChecker, Horse entry,
		String actionId)
		throws PortalException {

		if (!contains(permissionChecker, entry, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, Horse.class.getName(),
				entry.getHorseId(), actionId);
		}
	}

	public static void check(
		PermissionChecker permissionChecker, long entryId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, entryId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, Horse.class.getName(), entryId,
				actionId);
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, Horse entry,
		String actionId)
		throws PortalException {

		Boolean hasPermission = StagingPermissionUtil.hasPermission(
			permissionChecker, entry.getGroupId(),
			Horse.class.getName(), entry.getHorseId(),
			HorsePortletKeys.HORSE, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		if (permissionChecker.hasOwnerPermission(
			entry.getCompanyId(), Horse.class.getName(),
			entry.getHorseId(), entry.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			entry.getGroupId(), Horse.class.getName(),
			entry.getHorseId(), actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long entryId, String actionId)
		throws PortalException {

		Horse entry = _HorseLocalService.getHorse(entryId);

		return contains(permissionChecker, entry, actionId);
	}

	@Override
	public void checkBaseModel(
		PermissionChecker permissionChecker, long groupId, long primaryKey,
		String actionId)
		throws PortalException {

		check(permissionChecker, primaryKey, actionId);
	}

	@Reference(unbind = "-")
	protected void setHorseLocalService(
		HorseLocalService HorseLocalService) {

		_HorseLocalService = HorseLocalService;
	}
	private static HorseLocalService _HorseLocalService;
}
