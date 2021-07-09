package ptbc.exercise2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptbc.exercise2.model.Phone;
import ptbc.exercise2.repository.PhoneRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ImplPhoneService implements PhoneService {

   @Autowired
   private PhoneRepository phoneRepository;

   @Override
   public Optional<Phone> findById(int id) {
      return phoneRepository.findById(id);
   }

   @Override
   public List<Phone> findAll() {
      return phoneRepository.findAll();
   }

   @Override
   public Phone save(Phone phone) {
      return phoneRepository.save(phone);
   }

   @Override
   public void deleteById(int id) {
      phoneRepository.deleteById(id);
   }
}
