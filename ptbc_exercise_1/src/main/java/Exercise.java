import java.util.Scanner;

public class Exercise {
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.print("Enter Staircase Size: ");

      int staircaseSize = sc.nextInt();

      if (staircaseSize <= 0 || staircaseSize > 100) {
         throw new IllegalArgumentException("Value must be from 0 to 100");
      }

      for (int i = 0; i < staircaseSize; i++) {
         for (int j = 0; j < staircaseSize - i - 1; j++) {
            System.out.print(" ");
         }
         for (int j = staircaseSize - i; j <= staircaseSize; j++) {
            System.out.print("#");
         }
         System.out.println();
      }
   }
}
