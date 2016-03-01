/* @author Leo Gardiner
 * 
 * A multiple base calculator, it can do simple addition on numbers of any base between 2 and 16 (binary
 * to hexadecimal)
 * 
 */ 

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.math.*;

public class bases{
   public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      int base = 0;
      String a = "";
      String b = "";
      int answer = 0;
      String limit = "";
      
      System.out.println("Enter a base between 2 and 16");
      while(scanner.hasNextLine()){

         base = 0;
         a = "";
         b = "";
         answer = 0;
         limit = "";
         
         while(!(2 <= base && base <= 16)){
            base = scanner.nextInt();
            scanner.nextLine();
            if(!(2 <= base && base <= 16)){
               System.out.println("Your base was not between 2 and 16");
            }
         }
 
         if(base <= 10){
            limit = "[^0-"+ (base-1) + "]";
         } else if(base == 11){
            limit = "[^0-9A]";
         } else if(base == 12){
            limit = "[^0-9A-B]";
         } else if(base == 13){
            limit = "[^0-9A-C]";
         } else if(base == 14){
            limit = "[^0-9A-D]";
         } else if(base == 15){
            limit = "[^0-9A-E]";
         } else if(base == 16){
            limit = "[^0-9A-F]";
         }

         //System.out.println(limit);
         Pattern p = Pattern.compile(limit);
 
         while( a.equals("")){
            System.out.println("Enter a number in base " + base + ":");
            a = scanner.nextLine();
            System.out.println("A = " + a);
            if(p.matcher(a).find()){
               a = "";
               System.out.println("Your number was not in the base you specified earlier");
            }
            if(a.length() > 100){
               a = "";
               System.out.println("Your number was too large, numbers may only be 100 digits long");
            }
         }

         while( b.equals("")){
            System.out.println("Enter another number in base " + base + ":");
            b = scanner.nextLine();
            if(p.matcher(b).find()){
               b = "";
               System.out.println("Your number was not in the base you specified earlier");
            }
            if(b.length() > 100){
               b = "";
               System.out.println("Your number was too large, numbers may only be 100 digits long");
            }
         }
         //System.out.println("A = " + a);
         //System.out.println("B = " + b);
         System.out.println("The sum of the entered numbers is\n" + add(base, a, b));
         //System.out.println(add(base, a, b));
         System.out.println("Enter a base between 2 and 16");
      }
      
   }

   public static String add(int base, String a, String b){
      String answer = "";
      int carry = 0, j = 0, k = 0;
      int[] added = new int[101];
      char[] array = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

      for(int i = 0; i < 101; i++){
         added[i] = -1;
      }

      j = a.length()-1;
      for(int i = 100; j >= 0; i--){
         if(added[i] == -1) added[i] = 0;
      
         if (a.charAt(j) == '0'){
            added[i] += 0;
         } else if(a.charAt(j) == '1'){
            added[i] += 1;
         } else if(a.charAt(j) == '2'){
            added[i] += 2;
         } else if(a.charAt(j) == '3'){
            added[i] += 3;
         } else if(a.charAt(j) == '4'){
            added[i] += 4;
         } else if(a.charAt(j) == '5'){
            added[i] += 5;
         } else if(a.charAt(j) == '6'){
            added[i] += 6;
         } else if(a.charAt(j) == '7'){
            added[i] += 7;
         } else if(a.charAt(j) == '8'){
            added[i] += 8;
         } else if(a.charAt(j) == '9'){
            added[i] += 9;
         } else if(a.charAt(j) == 'A'){
            added[i] += 10;
         } else if(a.charAt(j) == 'B'){
            added[i] += 11;
         } else if(a.charAt(j) == 'C'){
            added[i] += 12;
         } else if(a.charAt(j) == 'D'){
            added[i] += 13;
         } else if(a.charAt(j) == 'E'){
            added[i] += 14;
         } else if(a.charAt(j) == 'F'){
            added[i] += 15;
         }
         if(added[i] >= base){
            added[i] -= base;
            carry = 1;
            k = 1;
            while(carry == 1){
               if(added[i-k] == -1) added[i-k] = 0;
               if(added[i-k]+1 >= base){
                  added[i-k] -= base-1;
                  k++;
               } else {
                  added[i-k] += 1;
                  carry = 0;
               }
            }
         }
         j--;
      }
      
      //System.out.println(Arrays.toString(added));
      carry = 0;

      j = b.length()-1;
      for(int i = 100; j >= 0; i--){
         if(added[i] == -1) added[i] = 0;
      
         if (b.charAt(j) == '0'){
            added[i] += 0;
         } else if(b.charAt(j) == '1'){
            added[i] += 1;
         } else if(b.charAt(j) == '2'){
            added[i] += 2;
         } else if(b.charAt(j) == '3'){
            added[i] += 3;
         } else if(b.charAt(j) == '4'){
            added[i] += 4;
         } else if(b.charAt(j) == '5'){
            added[i] += 5;
         } else if(b.charAt(j) == '6'){
            added[i] += 6;
         } else if(b.charAt(j) == '7'){
            added[i] += 7;
         } else if(b.charAt(j) == '8'){
            added[i] += 8;
         } else if(b.charAt(j) == '9'){
            added[i] += 9;
         } else if(b.charAt(j) == 'A'){
            added[i] += 10;
         } else if(b.charAt(j) == 'B'){
            added[i] += 11;
         } else if(b.charAt(j) == 'C'){
            added[i] += 12;
         } else if(b.charAt(j) == 'D'){
            added[i] += 13;
         } else if(b.charAt(j) == 'E'){
            added[i] += 14;
         } else if(b.charAt(j) == 'F'){
            added[i] += 15;
         }
         if(added[i] >= base){
            added[i] -= base;
            carry = 1;
            k = 1;
            while(carry == 1){
               if(added[i-k] == -1) added[i-k] = 0;
               if(added[i-k]+1 >= base){
                  added[i-k] -= base-1;
                  k++;
               } else {
                  added[i-k] += 1;
                  carry = 0;
               }
            }
         }
         //System.out.println("Adding " + b.charAt(j) + " at position " + j);
         j--;
      }
      //System.out.println(Arrays.toString(added));
      //put the numbers into the return string
      for (int i = 0; i < 101; i++) {
         if(added[i] != -1) answer += array[added[i]];
         //System.out.println(i);
      }
      //System.out.println(Arrays.toString(added));
      return answer;
   }
}
