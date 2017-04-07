package it.dontesta.labs.liferay.elis.data.loader;

import com.liferay.osgi.util.BundleUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringPool;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.osgi.framework.BundleContext;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author amusarra
 */
public abstract class AbstractBaseModelDataLoader implements ModelDataLoader {

	protected long getDefaultUserId (long companyId) throws PortalException {
		return UserLocalServiceUtil.getUserByScreenName(companyId, "test").getUserId();
	}

	protected long getDefaultUserGroupId (long companyId) throws PortalException {
		return UserLocalServiceUtil.getUserByScreenName(companyId, "test").getGroupId();
	}

	protected String getCSVFieldValue(CSVRecord record, String fieldName) {
		String value = record.get(fieldName).trim();

		if (value.equalsIgnoreCase("null")) {
			return StringPool.BLANK;
		}

		return value;
	}

	protected byte[] getResource(String resourceName) throws IOException {
		URL url = getResourceURL(resourceName);

		if (url == null) {
			log.warn(
					"Unable to load file " + resourceName + " from bundle " +
							getBundleContext().getBundle().getSymbolicName());

			return null;
		}
		return FileUtil.getBytes(url.openStream());

	}

	protected URL getResourceURL(String resourceName) {
		URL url = BundleUtil.getResourceInBundleOrFragments(
				getBundleContext().getBundle(), resourceName);

		return url;
	}

	protected List<CSVRecord> loadCSV(String resourceName) throws IOException {
		URL url = getResourceURL(resourceName);

		if (url == null) {
			log.warn(
					"Unable to load file " + resourceName + " from bundle " +
							getBundleContext().getBundle().getSymbolicName());

			return new ArrayList<CSVRecord>();
		}

		CSVParser parser = CSVParser.parse(
				url, Charset.forName("UTF-8"),
				CSVFormat.EXCEL.withDelimiter(';')
						.withFirstRecordAsHeader()
						.withRecordSeparator('\n'));

		return parser.getRecords();
	}

	protected abstract BundleContext getBundleContext();

	private static Log log = LogFactoryUtil.getLog(AbstractBaseModelDataLoader.class);

}
