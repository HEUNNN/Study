package ch11;

import java.util.*;

public class BingoSet {
    public static void main(String[] args) {
        Set set1 = new HashSet();
        // Set set2 = new LinkedHashSet();
        int[][] board = new int[5][5];

        for (int i = 0; set1.size() < 25; i++) {
            set1.add((int)(Math.random() * 50) + 1 + "");
        }
        // Set에는 순서가 없기때문에 배열에서 index로 요소를 조회하거나, List에서 get(i)로 요소를 조회하는 것을 할 수 없다. iterator()를 사용해서 그냥 처음요소에서 다음 요소, 그 다음요소로 접근해야한다.
        Iterator it = set1.iterator();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt((String)it.next());
                System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
            }
            System.out.println();
        }

    }
}
