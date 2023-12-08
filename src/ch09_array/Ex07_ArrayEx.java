package ch09_array;

public class Ex07_ArrayEx {
    public static void main(String[] args) {
        int[] num = {3, 2, 1, 5, 4};
        for (int i=0; i < num.length; i++) {
           for (int j =i+1; j < num.length; j++) {
               if(num[i]>num[j]) {
                   int max = num[i];
                   num[i] = num[j];
                   num[j] = max;
               }
           }
           System.out.print(num[i]);
        }
    }
}
