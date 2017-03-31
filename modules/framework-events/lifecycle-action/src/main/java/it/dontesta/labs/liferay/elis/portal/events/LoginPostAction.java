/**
 * 
 */

package it.dontesta.labs.liferay.elis.portal.events;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.liferay.message.boards.kernel.model.MBMessageConstants;
import com.liferay.message.boards.kernel.service.MBMessageService;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Antonio Musarra
 */
@Component(
	immediate = true, 
	property = {
		"key=" + PropsKeys.LOGIN_EVENTS_POST
	}, 
	service = LifecycleAction.class
)
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
			}
			
			PrincipalThreadLocal.setName(user.getUserId());
			PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(permissionChecker);			
			PermissionThreadLocal.getPermissionChecker();
			
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			
			if (Validator.isNull(serviceContext)) {
				serviceContext = new ServiceContext();
			}
			
			serviceContext.setUserId(user.getUserId());
			serviceContext.setScopeGroupId(user.getGroupId());
			
			// #LPS-70492 - https://issues.liferay.com/browse/LPS-70492
			List<ObjectValuePair<String, InputStream>> inputStreamOVPs =
							Collections.emptyList();

/*			_messageService.addMessage(
				20147l, 30875l, "Messaggio di benvenuto",
				"Ciao benvenuto sul mio portale :-)",
				MBMessageConstants.DEFAULT_FORMAT, inputStreamOVPs, false, 0.0,
				false, serviceContext);
*/		}
		catch (Exception e) {
			throw new ActionException(e);
		}
	}

	@Reference(unbind = "-")
	protected void setPortal(Portal portal) {

		_portal = portal;
	}

	@Reference(policy = ReferencePolicy.DYNAMIC, cardinality = ReferenceCardinality.OPTIONAL)
	protected void setMBMessageService(
		MBMessageService mbMessageService) {
		_messageService = mbMessageService;
	}

	protected void unsetMBMessageService(
		MBMessageService mbMessageServiceUtil) {
		_messageService = null;
	}

	private MBMessageService _messageService;
	private Portal _portal;
	
	private static final Log _log =
		LogFactoryUtil.getLog(LoginPostAction.class);

}
