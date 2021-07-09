package ptbc.exercise2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptbc.exercise2.model.Phone;
import ptbc.exercise2.repository.PhoneRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PhoneController {

   @Autowired
   private PhoneRepository phoneRepository;

   @GetMapping("/phones")
   public ResponseEntity<List<Phone>> getPhoneById() {
      Optional<List<Phone>> phoneData = Optional.of(phoneRepository.findAll());

      if (phoneData.isPresent()) {
         return new ResponseEntity<>(phoneData.get(), HttpStatus.OK);
      } else {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
   }

   @GetMapping("/phone/{id}")
   public ResponseEntity<Phone> getPhoneById(@PathVariable("id") int id) {
      Optional<Phone> phoneData = phoneRepository.findById(id);

      if (phoneData.isPresent()) {
         return new ResponseEntity<>(phoneData.get(), HttpStatus.OK);
      } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
   }

   @PostMapping("/phone")
   public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
      try {
         Phone createPhone = phoneRepository
                 .save(phone);
         return new ResponseEntity<>(createPhone, HttpStatus.CREATED);
      } catch (Exception e) {
         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

   @PutMapping("/phone/{id}")
   public ResponseEntity<Phone> updatePhone(@PathVariable("id") int id, @RequestBody Phone phone) {
      Optional<Phone> phoneData = phoneRepository.findById(id);

      if (phoneData.isPresent()) {
         Phone updatePhone = phoneData.get();
         updatePhone.setPhone(phone.getPhone());
         updatePhone.setName(phone.getName());
         return new ResponseEntity<>(phoneRepository.save(updatePhone), HttpStatus.OK);
      } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
   }

   @DeleteMapping("/phone/{id}")
   public ResponseEntity<HttpStatus> deletePhone(@PathVariable("id") int id) {
      try {
         phoneRepository.deleteById(id);
         return new ResponseEntity<>(HttpStatus.OK);
      } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }
}
