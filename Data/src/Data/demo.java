package Data;
public class demo {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 10;

        // Loop through each pair of numbers and check if their sum equals the target
       for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
               int c=numbers[i]+numbers[j];
               System.out.println("sum is :" +c);
                }
            }
        }
        
    }