public class ch6_9_PrimitiveParam3 {
    static void printArr(int[] arr) {
        System.out.print("array: [");
        for(int i : arr)  // 향상된 for 문
            System.out.print(i + ", " );

        System.out.println("]");
    }
    static int sumArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    static void sortArr(int[] arr) { // 오름차순 정렬
        // 큰 수를 차례로 젤 끝으로 보낸다 -> for(int j=0;i<arr.length-1-i;j++)
        for (int i = 0; i < arr.length - 1; i++) { // 비교 횟수
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int tmp = arr[j];
                if(arr[j] > arr[j+1]){
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            printArr(arr);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[] {3, 5, 2, 4, 6, 1};
        System.out.println("Array 원본 출력");
        printArr(array);
        System.out.println("배열 정렬 과정 출력");
        sortArr(array);
        System.out.println("정렬 후 결과 출력");
        printArr(array);
        System.out.println("배열 원소의 총 합 출력");
        System.out.println("sum: " + sumArr(array));
    }
}
