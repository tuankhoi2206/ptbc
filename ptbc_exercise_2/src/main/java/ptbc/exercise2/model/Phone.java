package ptbc.exercise2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column(length = 50)
   private String name;

   @Column(length = 30)
   private String phone;

   public Phone() {
   }

   public Phone(int id, String name, String phone) {
      this.id = id;
      this.name = name;
      this.phone = phone;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }
}
