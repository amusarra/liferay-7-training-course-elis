
package it.dontesta.labs.liferay.elis.portlet.horse.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.dontesta.labs.liferay.elis.portlet.horse.constants.HorsePortletKeys;

/**
 * @author amusarra
 */
@Component(immediate = true, 
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=portlet-horse",
		"com.liferay.portlet.display-category=category.community",
		"com.liferay.portlet.header-portlet-css=/horse/css/main.css",
		"com.liferay.portlet.icon=/horse/icons/horse.png",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.struts-path=horse",
		"javax.portlet.display-name=Bookmarks", 
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.mvc-command-names-default-views=/horse/view",
		"javax.portlet.init-param.portlet-title-based-navigation=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + HorsePortletKeys.HORSE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	}, 
	service = Portlet.class
)
public class HorseMVCPortlet extends MVCPortlet {
}
