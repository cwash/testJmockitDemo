/**
 * 
 */
package org.cwash.jmockitexample.mvc;

import static mockit.Mockit.newEmptyProxy;

import javax.servlet.http.HttpServletRequest;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class ControllerTest {

    @Mocked
    HttpServletRequest mockHttpServletRequest = newEmptyProxy(HttpServletRequest.class);
    @Mocked
    ServiceRemote mockServiceRemote = newEmptyProxy(ServiceRemote.class);

    @Test
    public void test_execute_expectations() {

	/* strict expectations - will throw exception if all expectations are not met */
	new Expectations() {
	    {
		final Model m = new Model();
		m.setId(12345l);

		mockHttpServletRequest.getParameter("modelId"); returns("12345");
		mockServiceRemote.getModel(12345l); returns(m);
		mockHttpServletRequest.setAttribute("model", m);
	    }
	}.endRecording();

	Controller c = new Controller();
	c.setHttpServletRequest(mockHttpServletRequest);
	c.setServiceRemote(mockServiceRemote);

	c.execute();

    }
}
