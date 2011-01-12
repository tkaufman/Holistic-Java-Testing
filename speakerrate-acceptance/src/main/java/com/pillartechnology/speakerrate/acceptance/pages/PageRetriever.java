package com.pillartechnology.speakerrate.acceptance.pages;

import org.apache.commons.lang.WordUtils;
import org.jbehave.web.selenium.WebDriverProvider;

public class PageRetriever {

	private WebDriverProvider driverProvider;

	public PageRetriever(WebDriverProvider driverProvider) {
		this.driverProvider = driverProvider;
	}

	public AbstractPage retrievePage(String pageName) {
		try {
			return retrievePage((Class<? extends AbstractPage>)Class.forName(getClass().getPackage().getName()+"."+WordUtils.capitalize(pageName).replaceAll("\\s", "")));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public <P extends AbstractPage> P retrievePage(Class<P> pageClass) {
		try {
			P page = (P) pageClass.getConstructor(WebDriverProvider.class).newInstance(driverProvider);
			return page; 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
