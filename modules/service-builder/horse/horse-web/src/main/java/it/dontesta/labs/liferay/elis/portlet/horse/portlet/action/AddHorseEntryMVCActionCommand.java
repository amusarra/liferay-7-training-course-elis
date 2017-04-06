/**
 * 
 */
package it.dontesta.labs.liferay.elis.portlet.horse.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import it.dontesta.labs.liferay.elis.portlet.horse.constants.HorsePortletKeys;


/**
 * @author amusarra
 *
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + HorsePortletKeys.HORSE,
		"mvc.command.name=/horse/add"
	}, 
	service = MVCActionCommand.class
)
public class AddHorseEntryMVCActionCommand extends BaseMVCActionCommand {

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand#doProcessAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		// TODO Auto-generated method stub

	}

}
