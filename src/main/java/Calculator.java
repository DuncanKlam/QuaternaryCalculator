
public class Calculator {

    static Boolean isBaseFour = true;

    public static String parseCalculation(String calculation){
        String[] operators = {"+","-","x","/"};
        String operator = "";
        for (String op : operators){
            if (calculation.contains(op)){
                operator = op;
            }
        }
        return operator;
    }

    public static String calculate(String calculation){
        String result = calculation;
        String operator = parseCalculation(calculation);
        if (operator != "" && isBaseFour){
            String[] parts = calculation.split("[" + operator + "]");
            try {
                if (parts[0] == ""){parts[0] = "0";}
                result = compute(parts[0], parts[1], operator);
            } catch (ArrayIndexOutOfBoundsException e){
                result = compute(parts[0], "0" , operator);
            }
        }
        return result;
    }

    public static String compute(String a, String b, String operator) {

        return switch (operator) {
            case "+" -> add(a, b);
            case "-" -> sub(a, b);
            case "x" -> mul(a, b);
            case "/" -> div(a, b);
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

    public static String toggle(String quaternary){
        String result = "";
        int parseRadix=10;
        int convertRadix=4;
        String operator = parseCalculation(quaternary);
        if(isBaseFour){
            parseRadix=4;
            convertRadix=10;
            isBaseFour=false;
        } else {
            isBaseFour=true;
        }
        if (operator != ""){
            String[] parts = quaternary.split("[" + operator + "]");
            try { if (parts[0] == ""){parts[0] = "0";}
                String part1 = Integer.toString(Integer.parseInt(parts[0],parseRadix),convertRadix);
                String part2 = Integer.toString(Integer.parseInt(parts[1],parseRadix),convertRadix);
                result = part1 + operator + part2;
            } catch (ArrayIndexOutOfBoundsException e){
                result = Integer.toString(Integer.parseInt(parts[0],parseRadix),convertRadix) + operator;
            }
        } else {
            result = Integer.toString(Integer.parseInt(quaternary,parseRadix),convertRadix);
        }
        return result;
    }
}