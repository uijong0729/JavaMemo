package ocjp.gold;

public class Human {
    private int age;
    private String name;
    private Gender gender;

    public enum Gender {
        male, female
    }

   public Human(int age, String name, Gender gender) {
    this.age = age;
    this.name = name;
    this.gender = gender;
   }

   public int getAge() {
       return age;
   }

   public void setAge(int age) {
       this.age = age;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public Gender getGender() {
       return gender;
   }

   public void setGender(Gender gender) {
       this.gender = gender;
   }
}
