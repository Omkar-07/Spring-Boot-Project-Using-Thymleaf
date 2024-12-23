package Property.Property.controller;

import Property.Property.entity.Property;
import Property.Property.service.serviceIMPL;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/properties")
public class mycontroller {

	@Autowired
	private serviceIMPL ps;

	@GetMapping("/")
	public String getAllProperties(Model model) {
		model.addAttribute("propertyList", ps.getAllProperties());
		return "propertyHome";
	}

	@GetMapping("/new")
	public String getAllData(Model model) {
		model.addAttribute("property", new Property());
		return "addproperty";
	}

	@PostMapping("/save")
	public String saveNewProperty(@Valid @ModelAttribute Property property, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addproperty"; 
		}
		ps.saveProperty(property);
		return "redirect:/properties/";
	}

	@GetMapping("/update/{id}")
	public String updateProperty(@PathVariable int id, Model model) {
		Property property = ps.getById(id);
		if (property != null) {
			model.addAttribute("property", property);
			return "editproperty";
		} else {
			return "redirect:/properties/";
		}
	}

	@PostMapping("/update/{id}")
	public String updateProperty(@PathVariable int id, @Valid @ModelAttribute Property property, BindingResult result) {
		if (result.hasErrors()) {
			return "editproperty"; 
		}
		property.setId(id);
		ps.saveProperty(property);
		return "redirect:/properties/";
	}

	@PostMapping("/delete/{id}")
	public String deleteProperty(@PathVariable int id) {
		ps.deleteProperty(id);
		return "redirect:/properties/";
	}
	


	    @GetMapping("/aboutpage")
	    public String about() {
	        return "aboutpage"; 
	    }

}

/*
 * @PostMapping("/save") public String saveNewProperty(@RequestParam("image")
 * MultipartFile image, @ModelAttribute Property property) throws IOException {
 * // Save the uploaded file in the `images` directory in the project root
 * String fileName = System.currentTimeMillis() + "_" +
 * image.getOriginalFilename(); Path filePath = Paths.get("images/" + fileName);
 * Files.createDirectories(filePath.getParent()); Files.write(filePath,
 * image.getBytes());
 * 
 * // Save the relative path of the image in the database
 * property.setImageUrl("/images/" + fileName);
 * 
 * // Save the property object ps.saveProperty(property);
 * 
 * return "redirect:/properties"; }
 * 
 * @PostMapping("/update/{id}") public String updateProperty(@PathVariable int
 * id, @RequestParam("image") MultipartFile image, @ModelAttribute Property
 * property) throws IOException { if (!image.isEmpty()) { // Save the new
 * uploaded file in the `images` directory String fileName =
 * System.currentTimeMillis() + "_" + image.getOriginalFilename(); Path filePath
 * = Paths.get("images/" + fileName);
 * Files.createDirectories(filePath.getParent()); Files.write(filePath,
 * image.getBytes());
 * 
 * // Update the image URL property.setImageUrl("/images/" + fileName); }
 * 
 * // Ensure the ID is set correctly property.setId(id);
 * ps.saveProperty(property);
 * 
 * return "redirect:/properties"; }
 */

/*
 * @PostMapping("/save") public String saveNewProperty(@ModelAttribute Property
 * property) { ps.saveProperty(property); return "redirect:/properties/"; }
 * 
 * @PostMapping("/update/{id}") public String updateProperty(@PathVariable int
 * id, @ModelAttribute Property property) { property.setId(id);
 * ps.saveProperty(property); return "redirect:/properties/"; }
 * 
 * @GetMapping("/update/{id}") public String updateProperty(@PathVariable int
 * id, Model model) { Property property = ps.getById(id); if (property != null)
 * { model.addAttribute("property", property); return "editproperty"; } else {
 * return "redirect:/properties/"; } }
 */
