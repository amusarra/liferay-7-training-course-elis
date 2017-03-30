package it.dontesta.labs.liferay.elis.osgi.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloOsgiBundleActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("[Hello OSGi Service] Starting module...");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("[Hello OSGi Service] Stopping module...");
	}

}