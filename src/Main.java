import java.util.Scanner;

public class Main {
    static char operation;
    static String firstArgument;
    static String secondArgument;
    static String result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] myList = new String[10];
        if (input.contains("+")){
            myList = input.split(" \\+ ");
            operation = '+';
        }else if (input.contains("-")){
            myList = input.split(" - ");
            operation = '-';
        }else if (input.contains("/")){
            myList = input.split(" / ");
            operation = '/';
        }else if (input.contains("*")){
            myList = input.split(" \\* ");
            operation = '*';
        }
        firstArgument = myList[0].trim();
        secondArgument = myList[1].trim();

        if(myList.length == 2){
            if (operation == '+' || operation == '-'){
                if ((firstArgument.contains("\"")) && (secondArgument.contains("\""))){
                    firstArgument = firstArgument.replaceAll("\"", "");
                    secondArgument = secondArgument.replaceAll("\"", "");
                    if (firstArgument.length() <= 10 && secondArgument.length() <= 10){
                        System.out.println("\"" + getResult() + "\"");
                    }else throw new RuntimeException("Длина строк превышает допустимое значение, длина строк не должна превышать 10 символов!");
                }else throw new RuntimeException("Для сложения нужны строки в кавычках!");
            }
            else if(operation =='/' && !(secondArgument.contains("\"")) && (firstArgument.contains("\""))||
            operation == '*' && !(secondArgument.contains("\"")) && (firstArgument.contains("\""))){
                firstArgument = firstArgument.replaceAll("\"", "");
                secondArgument = secondArgument.replaceAll("\"", "");
                if (firstArgument.length() <= 10 && isParsable(secondArgument)) {
                    if (Integer.parseInt(secondArgument) >= 1 && Integer.parseInt(secondArgument) <= 10) {
                        if (getResult().length() > 40) {
                            result = getResult().substring(0, 40);
                            System.out.println("\"" + result + "\"");
                        }
                        else {
                            System.out.println("\"" + getResult() + "\"");
                        }
                    }else throw new RuntimeException("Число не может быть меньше 0 и больше 10!");
                }else throw new RuntimeException("Строка не можешт превышать 10 символов. Строку нужно умножать или делить только на целое число!");
            }else throw new RuntimeException("Не допустимое значение операции!");
        }else throw new RuntimeException("Выражения должно быть два");
    }
    public static boolean isParsable(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (final NumberFormatException e){
            return false;
        }
    }
    public static String getResult(){
        return result = calc(firstArgument, secondArgument, operation);
    }

    public static String calc(String arg1, String arg2, char operation){
        return switch (operation){
            case '+' -> arg1.concat(arg2);
            case '-' -> arg1.replaceFirst(arg2, "");
            case '/' -> arg1.substring(0, (int)(arg1.length()/Integer.parseInt(arg2)));
            case '*' -> arg1.repeat(Integer.parseInt(arg2));
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }
}
//Написать метод, который будет принимать строку и символ. А затем выведет на экран число, равное тому, сколько
//раз этот символ встречается в строке. Затем в main считать из консоли строку, потом символ, и вызвать этот метод.
//Проверять длину символа для поиска не надо, предполагается что там всегда вводится одиночный символ. Пробел - тоже символ,
//метод должен уметь считать кол-во пробелов в введенной строке.

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        String ch =  scanner.nextLine();
//        char ch1 = ch.charAt(0);
//        int result = sum(input, ch1);
//        System.out.println(result);
//
//    }
//    public static int sum(String x, char y){
//        char[] forOperationArray = new char[20];
//        int count = 0;
//        for (int i = 0; i<x.length(); i++){
//            if (x.charAt(i) == y){
//                count += 1;
//            }
//
//
//        }
//        return count;
//    }
//}