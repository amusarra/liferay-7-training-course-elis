/**
 * 
 */

package it.dontesta.labs.liferay.elis.portal.events;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.liferay.message.boards.kernel.service.MBMessageServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;

/**
 * @author Antonio Musarra
 */
@Component(immediate = true, property = {
	"key=" + PropsKeys.LOGIN_EVENTS_POST
}, service = LifecycleAction.class)
public class LoginPostAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		if (_log.isInfoEnabled()) {
			_log.info("login.event.post=" + lifecycleEvent);
		}

		try {
			User user = _portal.getUser(lifecycleEvent.getRequest());

			if (_log.isInfoEnabled()) {
				_log.info("UserId:" + user.getUserId());
				_log.info("Full Name:" + user.getFullName());
			}
			
			//PermissionThreadLocal.getPermissionChecker().
			
			_messageServiceUtil.addMessage(
				30875, "Messaggio di benvenuto",
				"Ciao " + user.getFullName() + "benvenuto sul mio portale :-)",
				ServiceContextThreadLocal.getServiceContext());
		}
		catch (Exception e) {
			throw new ActionException(e);
		}
	}

	@Reference(unbind = "-")
	protected void setPortal(Portal portal) {

		_portal = portal;
	}

	@Reference(policy = ReferencePolicy.DYNAMIC, cardinality = ReferenceCardinality.OPTIONAL)
	protected void setMBMessageServiceUtil(
		MBMessageServiceUtil mbMessageServiceUtil) {
		_messageServiceUtil = mbMessageServiceUtil;
	}

	protected void unsetMBMessageServiceUtil(
		MBMessageServiceUtil mbMessageServiceUtil) {
		_messageServiceUtil = null;
	}

	private static MBMessageServiceUtil _messageServiceUtil;
	private Portal _portal;
	private static final Log _log =
		LogFactoryUtil.getLog(LoginPostAction.class);

}
