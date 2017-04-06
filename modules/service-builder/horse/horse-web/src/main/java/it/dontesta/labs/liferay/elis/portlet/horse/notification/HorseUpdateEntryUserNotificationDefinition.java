/**
 * 
 */
package it.dontesta.labs.liferay.elis.portlet.horse.notification;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationDeliveryType;

import it.dontesta.labs.liferay.elis.portlet.horse.constants.HorsePortletKeys;


/**
 * @author amusarra
 *
 */
@Component(
	immediate = true,
	property = {"javax.portlet.name=" + HorsePortletKeys.HORSE},
	service = UserNotificationDefinition.class
)
public class HorseUpdateEntryUserNotificationDefinition
	extends UserNotificationDefinition {

	public HorseUpdateEntryUserNotificationDefinition() {
		super(
			HorsePortletKeys.HORSE, 0,
			UserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY,
			"receive-a-notification-when-someone-updates-a-bookmark-you-are-" +
				"subscribed-to");

		addUserNotificationDeliveryType(
			new UserNotificationDeliveryType(
				"email", UserNotificationDeliveryConstants.TYPE_EMAIL, true,
				true));
		addUserNotificationDeliveryType(
			new UserNotificationDeliveryType(
				"website", UserNotificationDeliveryConstants.TYPE_WEBSITE, true,
				true));
	}
}
