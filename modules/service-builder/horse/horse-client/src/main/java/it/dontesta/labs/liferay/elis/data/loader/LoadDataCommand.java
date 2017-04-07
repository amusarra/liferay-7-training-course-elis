package it.dontesta.labs.liferay.elis.data.loader;

import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.util.tracker.ServiceTracker;

import java.util.Arrays;

/**
 * @author amusarra
 */
@Component(
		immediate = true,
		property = {
				"osgi.command.scope=elis",
				"osgi.command.function=loadData"
		},
		service = Object.class
)
public class LoadDataCommand {
	public void loadData() {
		ServiceReference<ModelDataLoader>[] references =
				serviceTracker.getServiceReferences();

		System.out.println(
				"Call the command  \n\tloadData <type> \nwhere type if one of:");

		if (references.length > 0) {
			System.out.println("\t- all");
		}

		Arrays.stream(serviceTracker.getServiceReferences())
				.sorted(
						(l1, l2) -> Integer.compare(
								Integer.valueOf((String)l1.getProperty("priority")),
								Integer.valueOf((String)l2.getProperty("priority"))
						)
				).forEach(l -> System.out.println(
				"\t- [" + l.getProperty("priority") + "] " + l.getProperty("key")));
	}

	public void loadData(String type) throws PortalException, Exception {

		if (type.equalsIgnoreCase("all")) {
			ServiceReference<ModelDataLoader>[] references =
					serviceTracker.getServiceReferences();

			Arrays.stream(references)
					.sorted(
							(l1, l2) -> Integer.compare(
									Integer.valueOf((String)l1.getProperty("priority")),
									Integer.valueOf((String)l2.getProperty("priority"))
							)
					).sequential().forEach(l -> doLoadData((String)l.getProperty("key")));
		}
		else {
			doLoadData(type);
		}
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		serviceTracker =
				ServiceTrackerFactory.open(ModelDataLoader.class);
	}

	protected ModelDataLoader findService(String keyName) {

		for (ServiceReference<ModelDataLoader> serviceReference :
				serviceTracker.getServiceReferences()) {

			if (serviceReference.getProperty("key").equals(keyName)) {
				return serviceTracker.getService(serviceReference);
			}
		}

		return null;
	}

	protected void doLoadData(String type) {
		ModelDataLoader dataLoader = findService(type);

		if (dataLoader == null) {
			System.out.println("No loader found for key " + type);

			return;
		}

		try {
			System.out.println("Loading data for " + type);
			dataLoader.loadModelData();
			System.out.println("Data for " + type + " loaded");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	ServiceTracker<ModelDataLoader, ModelDataLoader> serviceTracker;
}
