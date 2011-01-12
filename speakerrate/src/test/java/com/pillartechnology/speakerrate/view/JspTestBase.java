package com.pillartechnology.speakerrate.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.jsp.JspFactory;

import org.apache.jasper.runtime.JspFactoryImpl;
import org.junit.After;
import org.junit.Before;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;

public abstract class JspTestBase {
	private JspFactory oldFactory;
	protected HttpServlet servlet;
	protected MockHttpServletRequest req;
	protected MockHttpServletResponse res;

	@Before 
	public void beforeJsptests() throws Exception {
		oldFactory = JspFactory.getDefaultFactory();
		JspFactory.setDefaultFactory(new JspFactoryImpl());
		Class<?> servletClass = Thread.currentThread().getContextClassLoader().loadClass(convertJspToServletClass());
		servlet = (HttpServlet) servletClass.newInstance();
		MockServletConfig config = new MockServletConfig();
		servlet.init(config);
		req = new MockHttpServletRequest();
		res = new MockHttpServletResponse();
	}

	@After
	public void afterJspTests() {
		JspFactory.setDefaultFactory(oldFactory);
	}

	private String convertJspToServletClass() {
		return "jsp" + getJspFile().replace('.', '_').replace('/', '.').replace("-", "_002d");
	}

	protected abstract String getJspFile();
}
