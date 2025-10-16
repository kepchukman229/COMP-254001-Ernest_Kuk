package ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check if it is palindrome: ");
        String ans = sc.nextLine();

        if (palindrome(ans)) {
            System.out.println("String \"" + ans + "\" is a palindrome");
        }
        else {
            System.out.println("String \"" + ans + "\" is NOT a palindrome");
        }
    }

    public static boolean palindrome(String str){
        //base case
        if(str.length() <= 1){
            return true;
        }

        if(str.charAt(0) != str.charAt(str.length()-1)){
            return false;
        }

        return palindrome(str.substring(1, str.length()-1));
    }
}
