/**
 * 
 */
package it.dontesta.labs.liferay.elis.portlet.horse.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import it.dontesta.labs.liferay.elis.portlet.horse.constants.HorsePortletKeys;
import it.dontesta.labs.liferay.elis.portlet.horse.constants.HorseWebKeys;
import it.dontesta.labs.liferay.elis.servicebuilder.service.HorseServiceUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;


/**
 * @author amusarra
 *
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + HorsePortletKeys.HORSE,
		"mvc.command.name=/horse/delete"
	}, 
	service = MVCActionCommand.class
)
public class DeleteHorseEntryMVCActionCommand extends BaseMVCActionCommand {

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand#doProcessAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long horseEntryId = ParamUtil.getLong(actionRequest, HorseWebKeys.HORSE_ENTRY_ID);

		try {
			HorseServiceUtil.deleteHorse(horseEntryId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
