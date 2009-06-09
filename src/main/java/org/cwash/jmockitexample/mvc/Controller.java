package org.cwash.jmockitexample.mvc;

import javax.servlet.http.HttpServletRequest;

public class Controller {

    public HttpServletRequest getHttpServletRequest() {
	return request;
    }

    public void setHttpServletRequest(HttpServletRequest request) {
	this.request = request;
    }

    /* EJB3 SLSB remote interface */
    ServiceRemote serviceRemote;

    HttpServletRequest request;

    public ServiceRemote getServiceRemote() {
	return this.serviceRemote;
    }

    public void setServiceRemote(ServiceRemote serviceRemote) {
	this.serviceRemote = serviceRemote;
    }

    public void execute() {

	String claimIdString = request.getParameter("modelId");

	Long id = Long.parseLong(claimIdString);
	
	Model claim = serviceRemote.getModel(id);
	
	request.setAttribute("model", claim);
	
    }

}