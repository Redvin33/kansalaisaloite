package fi.om.initiative.web;

import com.google.common.base.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Locale;

import static fi.om.initiative.web.Urls.*;
import static fi.om.initiative.web.Views.INDEX_VIEW;

@Controller
public class StaticPageController extends BaseController {
    
    public StaticPageController(boolean optimizeResources, String resourcesVersion, Optional<Integer> omPiwicId) {
        super(optimizeResources, resourcesVersion, omPiwicId);
    }
    
    /*
     * Front page
     */
    @RequestMapping(FRONT)
    public RedirectView frontpage() {
        RedirectView redirectView = new RedirectView(Urls.FRONT_FI, true, true, false);
        redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        return redirectView;
    }
    
    @RequestMapping({ FRONT_FI, FRONT_SV })
    public String frontpage(Model model, Locale locale) {
        Urls urls = Urls.get(locale);

        model.addAttribute(ALT_URI_ATTR, urls.alt().frontpage());
        addPiwicIdIfNotAuthenticated(model);

        return INDEX_VIEW;
    }

    @RequestMapping(API)
    public String api() {
        return Views.API_VIEW;
    }
}
