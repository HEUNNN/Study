package ch9;

public class StringConstructorMethod {
    public static void main(String[] args) {
        // String 클래스의 생성자와 메서드
        // 생성자
        String s1 = new String("Hello");
        System.out.println(s1);

        char[] c1 = {'H', 'e', 'l', 'l', 'o'};
        String s2 = new String(c1); // char[] 배열의 원소를 합쳐 만든 문자열을 갖는 String 인스턴스를 생성한다.
        System.out.println(s2);

        StringBuffer sb = new StringBuffer("Hello");
        String s3 = new String(sb); // StringBuffer 인스턴스가 갖고있는 문자열과 같은 내용의 String 인스턴스를 생성한다.
        System.out.println(s3);

        // 메서드
        String str1 = "Hello";
        char c2 = str1.charAt(1); // 지정된 위치에 있는 문자열을 알려준다. (0부터 시작)
        System.out.println(c2); // e

        int num1 = "aaa".compareTo("aaa"); // 파라미터로 전달된 문자열과 사전순서를 바탕으로 비교한다. 같으면 0, 전달된 문자열이 이전이면 양수, 전달된 문자열이 이후이면 음수이다.
        int num2 = "bbb".compareTo("aaa");
        int num3 = "bbb".compareTo("ccc");
        System.out.println("num1: " + num1 + ", num2: " + num2 + ", num3: " + num3); // 0 1 -1

        String str2 = "Hel";
        String str3 = "lo";
        String res1 = str2.concat(str3); // str2에 문자열 str3을 덧붙인다.
        System.out.println(res1);

        String str4 = "strawberry";
        boolean res2 = str4.contains("st");
        System.out.println("문자열에 'st'가 포함되어 있나? " + res2); // 지정된 문자열이 test 할 문자열에 포함되어있는지 boolean 값을 반환하는 메서드이다.

        String str5 = "Hello";
        boolean res3 = str5.endsWith("llo"); // test 대상 문자가 지정된 문자열로 끝나느지 검사하고, boolean 결과를 반환하는 메서드이다.
        System.out.println("문자열이 'llo'로 끝나는가? " + res3);

        String  str6 = "apple";
        String str7 = "apple";
        boolean res4 = str6.equals(str7); // 매개변수로 받은 문자열(obj)와 String 인스턴스의 문자열을 비교한다. 파라미터로 전달된 것이 String 인스턴스가 아니거나 문자열이 다른 경우 false를 반환하는 메서드이다. (대소문자를 구분)
        System.out.println("비교할 두 개의 문자열이 대소문자 구분 하여 같은가? " + str6 + " vs " + str7 + ": " + res4);

        String str8 = "Apple";
        boolean res5 = str7.equalsIgnoreCase(str8);
        System.out.println("비교할 두 개의 문자열이 대소문자 구분 없이 같은가? " + str7 + " vs " + str8 + ": " + res5);

        int res6 = str4.indexOf('r');
        System.out.println("주어진 문자 r이 문자열 " + str4 + "에 존재하는가? (존재하면 해당 문자의 index를 반환하고, 존재하지 않으면 -1을 반환) " + res6);
        int res7 = str4.indexOf("str");
        System.out.println("주어진 문자열 str이 문자열 " + str4 + "에 존재하는가? (존재하면 해당 문자열의 시작부분 index를 반환하고, 존재하지 않으면 -1을 반환) " + res7);
        int res8 = str4.lastIndexOf('r');
        System.out.println("주어진 문자 r이 문자열 " + str4 + "의 오른쪽 끝에서부터 탐색했을 때 먼저 찾아지는 위치의 index를 반환: " + res8); // 8
        int res9 = str4.lastIndexOf("er");
        System.out.println("주어진 문자 er이 문자열 " + str4 + "의 오른쪽 끝에서부터 탐색했을 때 먼저 찾아지는 위치의 index를 반환: " + res9); // 6

        int res10 = str4.length();
        System.out.println(str4 + "의 길이 " + res10);

        String res11 = str5.replace('H', 'C'); // 대문자 구별
        System.out.println("문자열 중의 문자를 새로운 문자로 바꾼 문자열을 반환: " + res11);
        String res12 = str1.replace("He", "hE");
        System.out.println("문자열 중의 문자열을 새로운 문자열로 바꾼 문자열을 반환: " + res12);
        String str9 = "aaAAbbabaaba";
        String res13 = str9.replaceAll("aa", "xx");
        System.out.println("문자열 중에서 지정된 문자열과 일치하는 것을 새로운 문자열로 모두 바꾼 문자열을 반환: " + res13); // 대문자를 구분한다.
        String res14 = str9.replaceFirst("aa", "xx");
        System.out.println("문자열 중에서 지정된 문자열과 일치 하는 것 중, 첫 번째 것만 새로운 문자열로 변경하여 반환: " + res14);

        String animals = "dog,cat,bear";
        String[] arr1 = animals.split(",");
        System.out.println("문자열을 지정된 분리자로 나누어 문자열 배열에 담아 반환: " + arr1[0] + " / " + arr1[1] + " / " + arr1[2]);
        String[] arr2 = animals.split(",", 2);
        System.out.println("문자열을 지정된 분리자로 나누어 문자열 배열에 담아 반환하지만, 문자열 전체를 지정된 수(limit)로 자른 배열을 반환: " + arr2[0] + " / " + arr2[1]);

        boolean res15 = str9.startsWith("aa");
        System.out.println("주어진 문자열로 시작하는지 검사하여 boolean 값 반환: " + res15);

        String res16 = str1.substring(0,3);
        System.out.println("주어진 시작위치를 포함하여 끝 위치 바로 앞 위치의 범위에 포함된 문자열을 반환: " +res16);

        String str10 = "   Hello World   ";
        String res17 = str10.trim();
        System.out.println("문자열의 왼쪽 끝과 오른쪽 끝에 있는 공백을 없앤 문자열을 반환: " + res17);

        String res18 = String.valueOf(100);
        String res19 = String.valueOf('a');
        System.out.println("지정된 값을 문자열로 변환하여 반환: " + res18 + ", " + res19);
    }
}
