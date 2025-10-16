package ex1;

public class Main {

    //test
    public static void main(String[] args) {
        System.out.println("5 * 8 = " + multiply(5,8));
    }


    public static int multiply(int m, int n){
        //base case
        if (n == 1){
            return m;
        }

        //recursion
        return m + multiply(m, n-1);
    }
}
