package ptbc.exercise2.service;

import ptbc.exercise2.model.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneService {

   Optional<Phone> findById(int id);

   List<Phone> findAll();

   Phone save(Phone phone);

   void deleteById(int id);

}
