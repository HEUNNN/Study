package ch9;

import java.util.Scanner;

public class ScannerEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = null;
        int a = 1;
        while (a > 0) {
            String prompt = ">>";
            System.out.print(prompt);

            // 화면으로부터 라인단위로 입력 받음
            String input = sc.nextLine();

            input = input.trim(); // 입력받은 값에서 불필요한 앞뒤 공백을 제거
            strArr = input.split(" +"); // 공백을 구분자로 잘라서 String[]으로 반환한다. (입력받은 라인의 공백이 여러 개 일 수 있으므로 정규식을 " +"로 하였다. 이 정규식의 의미는 하나 이상의 공백을 의미한다.)

            String command = strArr[0].trim(); // 공백이 들어올 경우 continue 시키거나(continue 특별한 조건이 들어오면 다음 반복으로 넘어가라.), Q or q가 들어오면 while문을 끝내기 위한 command
            if (command.equals("")) continue;
            if (command.toLowerCase().equals("q")) {
                System.exit(0);
            } else {
                for (int i = 0; i < strArr.length; i++) {
                    System.out.println(strArr[i]);
                }
            }




        }
    }
}
