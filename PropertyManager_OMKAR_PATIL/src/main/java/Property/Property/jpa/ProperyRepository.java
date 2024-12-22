package Property.Property.jpa;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Property.Property.entity.Property;


@Repository
public interface ProperyRepository extends JpaRepository<Property, Integer> {
}
