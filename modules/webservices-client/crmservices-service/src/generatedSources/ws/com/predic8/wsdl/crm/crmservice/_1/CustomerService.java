
package com.predic8.wsdl.crm.crmservice._1;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CustomerService", targetNamespace = "http://predic8.com/wsdl/crm/CRMService/1/", wsdlLocation = "WEB-INF/wsdl/CustomerService.wsdl")
public class CustomerService
    extends Service
{

    private final static URL CUSTOMERSERVICE_WSDL_LOCATION;
    private final static WebServiceException CUSTOMERSERVICE_EXCEPTION;
    private final static QName CUSTOMERSERVICE_QNAME = new QName("http://predic8.com/wsdl/crm/CRMService/1/", "CustomerService");

    static {
        CUSTOMERSERVICE_WSDL_LOCATION = com.predic8.wsdl.crm.crmservice._1.CustomerService.class.getResource("WEB-INF/wsdl/CustomerService.wsdl");
        WebServiceException e = null;
        if (CUSTOMERSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'WEB-INF/wsdl/CustomerService.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        CUSTOMERSERVICE_EXCEPTION = e;
    }

    public CustomerService() {
        super(__getWsdlLocation(), CUSTOMERSERVICE_QNAME);
    }

    public CustomerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CUSTOMERSERVICE_QNAME, features);
    }

    public CustomerService(URL wsdlLocation) {
        super(wsdlLocation, CUSTOMERSERVICE_QNAME);
    }

    public CustomerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CUSTOMERSERVICE_QNAME, features);
    }

    public CustomerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CRMServicePT
     */
    @WebEndpoint(name = "CRMServicePTPort")
    public CRMServicePT getCRMServicePTPort() {
        return super.getPort(new QName("http://predic8.com/wsdl/crm/CRMService/1/", "CRMServicePTPort"), CRMServicePT.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CRMServicePT
     */
    @WebEndpoint(name = "CRMServicePTPort")
    public CRMServicePT getCRMServicePTPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://predic8.com/wsdl/crm/CRMService/1/", "CRMServicePTPort"), CRMServicePT.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CUSTOMERSERVICE_EXCEPTION!= null) {
            throw CUSTOMERSERVICE_EXCEPTION;
        }
        return CUSTOMERSERVICE_WSDL_LOCATION;
    }

}