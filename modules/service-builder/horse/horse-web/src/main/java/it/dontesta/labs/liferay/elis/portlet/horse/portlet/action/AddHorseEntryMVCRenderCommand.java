package it.dontesta.labs.liferay.elis.portlet.horse.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import it.dontesta.labs.liferay.elis.portlet.horse.constants.HorsePortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author amusarra
 */
@Component(
        property = {
                "javax.portlet.name=" + HorsePortletKeys.HORSE,
                "mvc.command.name=/horse/add"
        },
        service = MVCRenderCommand.class
)
public class AddHorseEntryMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse) {

        return "/horse/add_entry.jsp";
    }
}
