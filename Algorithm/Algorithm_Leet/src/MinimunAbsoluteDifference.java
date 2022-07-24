public class MinimunAbsoluteDifference {
    // LC 530
    // 이진검색트리의 기본 성질
    // 이진검색트리 란?
    // self 를 기준으로 왼쪽(left) subtree 는 본인보다 모두 작다. 오른쪽 subtree는 본인보다 모두 크다.

    // 트리 순회 종류 ⭐️ 재귀 사용
    // preorder: self → left → right
    // inorder: left → self → right
    // postorder: left → right → self
    // 이진 검색 트리 성질
    // inorder 순회를 하면 오름차순 정렬된 리스트가 나온다.
    boolean init; // 노드를 발견한적이 있는지를 표시
    int min;
    int prev; // 차이값을 구하기 위해 직전에 발견한 노드 값 저장

    public int getMinimumDifference(TreeNode root) {
        init = false;
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        // self 처리
        if (!init) {
            init = true;
        } else {
            int tmp = Math.abs(root.val - prev);
            // 꼭 abs 안해줘도 된다.
            min = Math.min(min, tmp);
        }
        prev = root.val;

        inorder(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
