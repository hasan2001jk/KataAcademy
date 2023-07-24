import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите выражение для калькулятора(a *-+/ b): ");
        String res = input.nextLine();
        System.out.println(res+" = "+calc(res));
//        System.out.println(calc("4 * -5"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int previousValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = map.get(s.charAt(i));
            if (currentValue < previousValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            previousValue = currentValue;
        }

        return result;
    }

    public static String intToRoman(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];
    }


    public static String calc(String input) throws Exception {
        // Проверяем есть ли числа совпадающие данному шаблону "5 + 9" соблюдая все пробелы и огранечения!
//        System.out.println(input.matches("^\\b(\\d|10)\\s[+\\/\\-*]\\s\\b(\\d|10)"));
        // Есть ли есть тогда переходим к проверке римских цифр
//        System.out.println(input.matches("^[IVXLCDM]+\\s[+-\\/*]\\s[IVXLCDM]+"));
        // Но данная проверка не дает нам полностью проверить римские цифры на огранечения по значению!

        boolean isArabicNumbers = input.matches("^\\b(\\d|10)\\s[+\\/\\-*]\\s\\b(\\d|10)");
        boolean isRomainNumbers = input.matches("^[IVXLCDM]+\\s[+-\\/*]\\s[IVXLCDM]+");
        String result="";

        if(isArabicNumbers==true){
            String[] operand = input.split(" ");
            switch (operand[1]){
                case "+":
                    result = String.valueOf(Integer.parseInt(operand[0]) + Integer.parseInt(operand[2]));
                    break;
                case "-":
                    result = String.valueOf(Integer.parseInt(operand[0]) - Integer.parseInt(operand[2]));
                    break;
                case "*":
                    result = String.valueOf(Integer.parseInt(operand[0]) * Integer.parseInt(operand[2]));
                    break;
                case "/":
                    result = String.valueOf(Integer.parseInt(operand[0]) / Integer.parseInt(operand[2]));
                    break;
                default:
                    System.out.println("There is an error with operands!");
            }
        }else if(isRomainNumbers){
            String[] numsOperand = input.split(" ");
            if(romanToInt(numsOperand[0])<=10 && romanToInt(numsOperand[2])<=10){
                switch (numsOperand[1]){
                    case "+":
                        result = intToRoman(romanToInt(numsOperand[0]) + romanToInt(numsOperand[2]));
                        break;
                    case "-":
                        result = intToRoman(romanToInt(numsOperand[0]) - romanToInt(numsOperand[2]));
                        break;
                    case "*":
                        result = intToRoman(romanToInt(numsOperand[0]) * romanToInt(numsOperand[2]));
                        break;
                    case "/":
                        result = intToRoman(romanToInt(numsOperand[0]) / romanToInt(numsOperand[2]));
                        break;
                    default:
                        System.out.println("There is an error with operands!");
                }

            }

        }else{
            throw new Exception("There is an error!");
        }


        return result;
    }

}