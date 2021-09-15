
public class Calculator {

    public static String parseCalculation(String calculation){
        String[] operators = {"+","-","x","/","^SQRT","^2"};
        String operator = "";
        for (String op : operators){
            if (calculation.contains(op)){
                operator = op;
            }
        }
        return operator;
    }

    public static String calculate(String calculation){
        String num = "";
        String result = "";
        String operator = parseCalculation(calculation);
        String[] parts = calculation.split("[" + operator + "]");
        try { if (parts[0] == ""){
            num = "0";
        } else { num = parts[0];}
            result = compute(num, parts[1], operator);
        } catch (ArrayIndexOutOfBoundsException e){
            result = compute(parts[0], "0" , operator);
        }
        return result;
    }

    public static String compute(String a, String b, String operator) {

        return switch (operator) {
            case "+" -> add(a, b);
            case "-" -> sub(a, b);
            case "x" -> mul(a, b);
            case "/" -> div(a, b);
            case "^SQRT" -> root(a);
            case "^2" -> square(a);
            default -> "error";
        };
    }

    public static String add(String quaternary1, String quaternary2) {
        int first = Integer.parseInt(quaternary1, 4);
        int second = Integer.parseInt(quaternary2, 4);
        return Integer.toString(first + second, 4);
    }
    public static String sub(String quaternary1, String quaternary2) {
        int first = Integer.parseInt(quaternary1, 4);
        int second = Integer.parseInt(quaternary2, 4);
        return Integer.toString(first - second, 4);
    }
    public static String mul(String quaternary1, String quaternary2) {
        int first = Integer.parseInt(quaternary1, 4);
        int second = Integer.parseInt(quaternary2, 4);
        return Integer.toString(first * second, 4);
    }
    public static String div(String quaternary1, String quaternary2) {
        int first = Integer.parseInt(quaternary1, 4);
        int second = Integer.parseInt(quaternary2, 4);
        return Integer.toString(first / second, 4);
    }

    public static String root(String quaternary) {
        int decimal = Integer.parseInt(quaternary, 4);
        return Integer.toString((int) Math.sqrt(decimal), 4);
    }

    public static String square(String quaternary) {
        int decimal = Integer.parseInt(quaternary, 4);
        return Integer.toString((int) Math.pow(decimal, 2), 4);
    }
}