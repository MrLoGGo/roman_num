import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        //I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000;
        String[] num_roman = {"I", "V", "X", "L", "C", "D", "M"};
        System.out.print("enter num: ");
        Scanner str = new Scanner(System.in);
        String num = str.next();
        String roman_num = "";
        for (int i = 0; i < num.length();i++){
            if (num.length() - i == 1){
                roman_num += count_roman_digit(num.charAt(i) - '0', "I", "V", "X");
            }
            else if (num.length() - i == 2) {
                roman_num += count_roman_digit(num.charAt(i) - '0', "X", "L" , "C");
                /*System.out.println(roman_num + '1');*/
            }
            else if (num.length() - i == 3 ) {
                roman_num += count_roman_digit(num.charAt(i) - '0', "C", "D" , "M");
            }
            else if (num.length() - i == 4 ) {
                roman_num = "M".repeat(num.charAt(i) - '0') ;
            }
            else return;
        }
        System.out.println(roman_num);
    }
    public static String count_roman_digit(int num, String first_roman_digit, String second_roman_digit, String third_roman_digit){
        String end_roman_digit = "";
        if(num < 4){
            end_roman_digit = first_roman_digit.repeat(num);
        } else if (num == 4) {
            end_roman_digit = first_roman_digit + second_roman_digit;
        }else if(num == 5){
            end_roman_digit = second_roman_digit;
        } else if (num > 5 && num < 9) {
            end_roman_digit = second_roman_digit + first_roman_digit.repeat(num - 5);
        } else if (num == 9) {
            end_roman_digit = first_roman_digit + third_roman_digit;
        }/*
        System.out.print(end_roman_digit + '2' + first_roman_digit);*/
        return end_roman_digit;
    }

}