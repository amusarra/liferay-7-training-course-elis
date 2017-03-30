package it.dontesta.labs.liferay.elis.webservice.crm.api;

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import it.dontesta.labs.liferay.elis.webservice.crm.exception.CRMServiceException;
import it.dontesta.labs.liferay.elis.webservice.crm.model.Customer;

/**
 * 
 * @author amusarra
 *
 */
@ProviderType
public interface CRMService {
	
	/**
	 * 
	 * @return
	 */
	public Customer createCustomer(Customer customer) throws CRMServiceException;
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public Customer getCustomer(String customerId) throws CRMServiceException;;
	
	/**
	 * 
	 * @return
	 */
	public List<Customer> getCustomers() throws CRMServiceException;;
}