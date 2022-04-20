public class ch6_15_VariableArguments {
    // 가변 인자
    public static void main(String[] args) {
        String[] strArr = {"100", "200", "300"};

        System.out.println(concatenate("", "100", "200", "300"));
        System.out.println(concatenate("-", strArr));
        System.out.println(concatenate(",", new String[]{"1", "2", "3"}));
        System.out.println("[" + concatenate("(", new String[0]) + "]");
        System.out.println("[" + concatenate(",") + "]");
    }
    public static String concatenate(String delim, String... args) { // 가변인자를 사용하는 메서드를 정의
        String result = "";
        for(String str : args) {
            result += str + delim;
        }
        return result;
    }
}
