package cz.herain.diplomathesis;

import com.liferay.portal.kernel.util.ReleaseInfo;
import cz.herain.diplomathesis.entity.Foo;
import cz.herain.diplomathesis.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.EventMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {

	@Autowired
	private FooService fooService;

	@RenderMapping
	public String primaryView(Model model) {
		model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());
		return "view";
	}

	@RenderMapping(params = "render=moreSpecificView")
	public String moreSpecificView(Model model) {
		model.addAttribute("info", "This is more specific view!");
		return "moreSpecificView";
	}

	@ActionMapping(value = "submitFoo")
	public void submitFoo(@ModelAttribute(value = "foo") Foo foo, BindingResult result,
							  ActionRequest actionRequest, ActionResponse actionResponse) {

		actionResponse.setRenderParameter("render", "moreSpecificView");
	}

	@ResourceMapping(value = "bar")
	public void getBar(ResourceRequest request, ResourceResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		out.print("this is bar!");
	}

	@EventMapping(value ="{http://liferay.com/events}foo.bar.event")
	public void receiveFooBarEvent(EventRequest request, EventResponse response, Model model) {
		Event event = request.getEvent();
		String pitch = (String)event.getValue();

		response.setRenderParameter("render", "moreSpecificView");
	}
}