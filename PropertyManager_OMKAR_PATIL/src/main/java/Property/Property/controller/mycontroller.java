package Property.Property.controller;
import Property.Property.entity.Property;
import Property.Property.routes.PropertyRoutes;
import Property.Property.service.serviceIMPL;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(PropertyRoutes.BASE_ROUTE)
@RequiredArgsConstructor
public class mycontroller {

    private final serviceIMPL ps;

    @GetMapping(PropertyRoutes.GET_ALL)
    public String getAllProperties(Model model) {
        model.addAttribute("propertyList", ps.getAllProperties());
        return "propertyHome";
    }

    @GetMapping(PropertyRoutes.NEW_PROPERTY)
    public String getAllData(Model model) {
        model.addAttribute("property", new Property());
        return "addproperty";
    }

    @PostMapping(PropertyRoutes.SAVE_PROPERTY)
    public String saveNewProperty(@Valid @ModelAttribute Property property, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addproperty"; 
        }
        ps.saveProperty(property);
        return "redirect:" + PropertyRoutes.BASE_ROUTE + PropertyRoutes.GET_ALL;
    }

    @GetMapping(PropertyRoutes.UPDATE_PROPERTY)
    public String updateProperty(@PathVariable int id, Model model) {
        Property property = ps.getById(id);
        if (property != null) {
            model.addAttribute("property", property);
            return "editproperty";
        } else {
            return "redirect:" + PropertyRoutes.BASE_ROUTE + PropertyRoutes.GET_ALL;
        }
    }

    @PostMapping(PropertyRoutes.UPDATE_PROPERTY)
    public String updateProperty(@PathVariable int id, @Valid @ModelAttribute Property property, BindingResult result) {
        if (result.hasErrors()) {
            return "editproperty"; 
        }
        property.setId(id);
        ps.saveProperty(property);
        return "redirect:" + PropertyRoutes.BASE_ROUTE + PropertyRoutes.GET_ALL;
    }

    @PostMapping(PropertyRoutes.DELETE_PROPERTY)
    public String deleteProperty(@PathVariable int id) {
        ps.deleteProperty(id);
        return "redirect:" + PropertyRoutes.BASE_ROUTE + PropertyRoutes.GET_ALL;
    }

    @GetMapping(PropertyRoutes.ABOUT_PAGE)
    public String about() {
        return "aboutpage"; 
    }
    
    @GetMapping(PropertyRoutes.SEARCH_BAR)
    public String searchProperties(@RequestParam("keyword") String keyword, Model model) {
        List<Property> properties = ps.searchProperties(keyword);
        model.addAttribute("propertyList", properties);
        model.addAttribute("keyword", keyword);
        return "propertyHome";
    }
    
	/*
	 * @GetMapping("/home") public String home(Model model) { List<Property>
	 * allProperties = ps.getAllProperties(); model.addAttribute("propertyList",
	 * allProperties); model.addAttribute("keyword", ""); return "propertyHome"; }
	 */
    
}
