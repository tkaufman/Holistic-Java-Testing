package com.pillartechnology.speakerrate.view;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;

import com.pillartechnology.speakerrate.model.Presentation;

public class ShowPresentationTest extends JspTestBase {
	@Test
	public void verifyContent() throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException, IOException {
		String expectedTitle = "MY TITLE";
		Presentation presentation = new Presentation();
		presentation.setTitle(expectedTitle);
		req.setAttribute("presentation", presentation);

		servlet.service(req, res);

		assertThat(res.getContentAsString(), containsString(expectedTitle));
	}

	@Test
	public void verifyMock() throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException, IOException {
		Presentation presentation = mock(Presentation.class);
		req.setAttribute("presentation", presentation);

		servlet.service(req, res);

		verify(presentation).getTitle();
	}

	@Override
	protected String getJspFile() {
		return "/WEB-INF/views/presentations/show.jsp";
	}
}
