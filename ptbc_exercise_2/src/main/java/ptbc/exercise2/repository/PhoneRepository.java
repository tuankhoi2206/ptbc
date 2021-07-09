package ptbc.exercise2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ptbc.exercise2.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}
