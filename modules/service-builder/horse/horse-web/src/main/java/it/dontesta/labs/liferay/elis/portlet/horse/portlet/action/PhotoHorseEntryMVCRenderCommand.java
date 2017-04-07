package it.dontesta.labs.liferay.elis.portlet.horse.portlet.action;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import it.dontesta.labs.liferay.elis.portlet.horse.constants.HorsePortletKeys;
import it.dontesta.labs.liferay.elis.portlet.horse.constants.HorseWebKeys;
import it.dontesta.labs.liferay.elis.servicebuilder.model.Horse;
import it.dontesta.labs.liferay.elis.servicebuilder.service.HorseServiceUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author amusarra
 */
@Component(
        property = {
                "javax.portlet.name=" + HorsePortletKeys.HORSE,
                "mvc.command.name=/horse/photo"
        },
        service = MVCRenderCommand.class
)
public class PhotoHorseEntryMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long horseEntryId = ParamUtil.getLong(renderRequest, HorseWebKeys.HORSE_ENTRY_ID);

        try {
            Horse horseEntry = HorseServiceUtil.getHorse(horseEntryId);

            FileEntry photoFileEntry = DLAppServiceUtil.getFileEntry(horseEntry.getPhotoId());
            String imageURL = DLUtil.getImagePreviewURL(photoFileEntry, photoFileEntry.getFileVersion(), themeDisplay);

            if (_log.isInfoEnabled()) {
                _log.info("Retrieve image URL for fileEntryId "
                    + horseEntry.getPhotoId()
                    + " {URL: "
                    + imageURL
                    + "}");
            }

            renderRequest.setAttribute(HorseWebKeys.HORSE_PHOTO_URL, imageURL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "/horse/view_entry_photo.jsp";
    }

    private static Log _log = LogFactoryUtil.getLog(PhotoHorseEntryMVCRenderCommand.class);
}