package Property.Property.service;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Property.Property.entity.Property;
import Property.Property.jpa.ProperyRepository;

@Service
public class serviceIMPL {

    @Autowired
    private ProperyRepository repo;

    public List<Property> getAllProperties() {
        return repo.findAll();
    }

    public Property getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteProperty(int id) {
        repo.deleteById(id);
    }

    public Property saveProperty(Property property) {
        return repo.save(property);
    }
}