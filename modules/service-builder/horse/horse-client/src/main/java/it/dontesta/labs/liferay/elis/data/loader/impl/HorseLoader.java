package it.dontesta.labs.liferay.elis.data.loader.impl;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.*;
import it.dontesta.labs.liferay.elis.data.loader.AbstractBaseModelDataLoader;
import it.dontesta.labs.liferay.elis.data.loader.ModelDataLoader;
import it.dontesta.labs.liferay.elis.servicebuilder.model.Horse;
import it.dontesta.labs.liferay.elis.servicebuilder.service.HorseLocalService;
import org.apache.commons.csv.CSVRecord;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author amusarra
 */
@Component(
		immediate = true,
		property = {
				"key=horse",
				"priority=1"
		},
		service = ModelDataLoader.class
)
public class HorseLoader extends AbstractBaseModelDataLoader {

	public static final String HORSE_FILE_NAME = "data/horse.csv";
	public static final String HORSE_FOLDER_RESOURCES = "data/horse_resources";

	@Override
	public void loadModelData() throws IOException, PortalException {
		List<CSVRecord> csvData = loadCSV(HORSE_FILE_NAME);

		for (CSVRecord data : csvData) {
			try {
				String name =
						getCSVFieldValue(data, "name");
				String mantle =
						getCSVFieldValue(data, "mantle");
				String kind =
						getCSVFieldValue(data, "kind");
				String gender =
						getCSVFieldValue(data, "gender");
				String age =
						getCSVFieldValue(data, "age");
				String photo =
						getCSVFieldValue(data, "photo");
				String dateOfBirth =
						getCSVFieldValue(data, "dateOfBirth");

				if (Validator.isNull(name)) {
					System.out.println(
							"Unable to load horse because name is empty: " +
									data);
					return;
				}
				if (Validator.isNull(name)) {
					System.out.println(
							"Unable to load horse because name is empty: " +
									data);
					return;
				}
				if (Validator.isNull(mantle)) {
					System.out.println(
							"Unable to load horse because mantle is empty: " +
									data);
					return;
				}
				if (Validator.isNull(kind)) {
					System.out.println(
							"Unable to load horse because kind is empty: " +
									data);
					return;
				}
				if (Validator.isNull(gender)) {
					System.out.println(
							"Unable to load horse because gender is empty: " +
									data);
					return;
				}
				if (Validator.isNull(photo)) {
					System.out.println(
							"Unable to load horse because photo is empty: " +
									data);
					return;
				}
				if (Validator.isNull(dateOfBirth)) {
					System.out.println(
							"Unable to load horse because dateOfBirth is empty: " +
									data);
					return;
				}

				byte[] photoIs = getResource(HORSE_FOLDER_RESOURCES
					+ StringPool.SLASH
					+ photo);

				if (log.isInfoEnabled()) {
					log.info(getDefaultUserId(PortalUtil.getDefaultCompanyId()));
					log.info(getDefaultUserGroupId(PortalUtil.getDefaultCompanyId()));
					log.info(photo);
					//log.info(MimeTypesUtil.getContentType(photoIs, photo));
				}

				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setAddGuestPermissions(true);
				serviceContext.setAddGroupPermissions(true);
				serviceContext.setUserId(getDefaultUserId(PortalUtil.getDefaultCompanyId()));

				FileEntry photoFileEntry = dlAppLocalService.addFileEntry(getDefaultUserId(PortalUtil.getDefaultCompanyId()),
						getDefaultUserGroupId(PortalUtil.getDefaultCompanyId()),
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
						DLUtil.getUniqueFileName(getDefaultUserGroupId(
								PortalUtil.getDefaultCompanyId()), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, photo
						),
						MimeTypesUtil.getContentType(photo),
						photoIs,
						serviceContext);

				long photoFileEntryId = photoFileEntry.getFileEntryId();
				Date dateOfBirthHorse = DateUtil.parseDate("dd-MM-yyyy", dateOfBirth, Locale.getDefault());

				Horse horse = horseLocalService.addHorse(name, kind, mantle, gender,
						GetterUtil.getInteger(age), dateOfBirthHorse, photoFileEntryId);

				System.out.println("The horse with the name "
					+ horse.getName()
					+ " it was added with horseId "
					+ horse.getHorseId());

			} catch (Exception ex) {
				System.out.println("Error creating horse from: " + data);
				ex.printStackTrace();
			}
		}
	}

	@Activate
	@Modified
	protected void activate(BundleContext bundleContext) {

		this.bundleContext = bundleContext;
	}

	@Override
	protected BundleContext getBundleContext() {

		return bundleContext;
	}

	@Reference
	protected void setHorseLocalService(HorseLocalService horseLocalService) {

		this.horseLocalService = horseLocalService;
	}

	@Reference
	protected void setDLAppLocalService(DLAppLocalService dlAppLocalService) {

		this.dlAppLocalService = dlAppLocalService;
	}

	protected DLAppLocalService dlAppLocalService;
	protected HorseLocalService horseLocalService;
	protected BundleContext bundleContext;

	private static Log log = LogFactoryUtil.getLog(HorseLoader.class);

}
