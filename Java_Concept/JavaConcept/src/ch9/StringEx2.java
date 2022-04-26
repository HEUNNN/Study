package ch9;

public class StringEx2 {
    public static void main(String[] args) {
        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(String.join("-", arr)); // arr 배열을 "-"로 구분하여 합친 문자열을 반환
    }
}
