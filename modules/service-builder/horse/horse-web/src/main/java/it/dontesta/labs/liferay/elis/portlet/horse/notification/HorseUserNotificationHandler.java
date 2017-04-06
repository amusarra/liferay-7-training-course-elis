/**
 * 
 */
package it.dontesta.labs.liferay.elis.portlet.horse.notification;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.notifications.BaseModelUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;

import it.dontesta.labs.liferay.elis.portlet.horse.constants.HorsePortletKeys;


/**
 * @author amusarra
 *
 */
@Component(
	immediate = true,
	property = {"javax.portlet.name=" + HorsePortletKeys.HORSE},
	service = UserNotificationHandler.class
)
public class HorseUserNotificationHandler
	extends BaseModelUserNotificationHandler {

	public HorseUserNotificationHandler() {
		setPortletId(HorsePortletKeys.HORSE);
	}
}
