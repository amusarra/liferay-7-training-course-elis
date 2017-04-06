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
                "mvc.command.name=/horse/edit"
        },
        service = MVCRenderCommand.class
)
public class EditMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse) {

        return "/horse/edit_entry.jsp";
    }
}
