package leecode.tree_;

import java.util.*;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public void postorder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    public int postordedepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftdepth = postordedepth(root.left);
        int rightdepth = postordedepth(root.right);
        return Math.max(leftdepth, rightdepth) + 1;
    }

    public void preorder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.empty()) {
            TreeNode tem = stack.pop();
            res.add(tem.val);
            if (tem.right != null) {
                stack.push(tem.right);
            }
            if (tem.left != null) {
                stack.push(tem.left);
            }

        }
        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;

            }
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            root = tmp.right;

        }
        return res;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        Deque<Integer> deque = new LinkedList();
        //前序 中左右，后序 左右中。中左右->中右左，中右左.reverse->左右中
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode tem = stack.pop();
            deque.add(tem.val);
            if (tem.left != null) {
                stack.push(tem.left);
            }
            if (tem.right != null) {
                stack.push(tem.right);
            }
        }
        int len = deque.size();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            res.add(deque.pollLast());
        }
        //Collections.reverse(res);
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            ArrayList<Integer> leveres = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode tem = queue.poll();
                leveres.add(tem.val);
                if (tem.left != null) {
                    queue.add(tem.left);
                }
                if (tem.right != null) {
                    queue.add(tem.right);
                }
            }
            res.add(leveres);
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            ArrayList<Integer> levelres = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tem = queue.poll();
                levelres.add(tem.val);
                if (tem.left != null) {
                    queue.add(tem.left);
                }
                if (tem.right != null) {
                    queue.add(tem.right);
                }
            }
            res.add(levelres);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tem = queue.poll();
                if (tem.left != null) {
                    queue.add(tem.left);
                }
                if (tem.right != null) {
                    queue.add(tem.right);
                }
                if (i == len - 1) {
                    res.add(tem.val);
                }
            }
        }
        return res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            double sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode tem = queue.poll();
                sum += tem.val;
                if (tem.left != null) {
                    queue.add(tem.left);
                }
                if (tem.right != null) {
                    queue.add(tem.right);
                }
            }
            double x = sum / len;
            res.add(x);
        }
        return res;
    }

    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node tem = queue.poll();
                list.add(tem.val);
                int len2 = tem.children.size();
                for (int j = 0; j < len2; j++) {
                    queue.add(tem.children.get(j));
                }
            }
            res.add(list);
        }
        return res;
    }

    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }

    public void swap(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;
        swap(root.left);
        swap(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            ArrayList<TreeNode> list = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tem = queue.poll();
                list.add(tem);
                if (tem == null) {
                    continue;
                }
                queue.add(tem.left);
                queue.add(tem.right);

            }
            for (int i = 0; i < len; i++) {
                if (list.get(i) == null && list.get(len - i - 1) == null) {
                    continue;
                }
                if (list.get(i) == null && list.get(len - i - 1) != null) {
                    return false;
                }
                if (list.get(i) != null && list.get(len - i - 1) == null) {
                    return false;
                }
                if (list.get(i).val != list.get(len - i - 1).val) {
                    return false;
                }
            }
        }
        return true;
    }

    public int maxDepth(TreeNode root) {
        return postordedepth(root);
    }

    public int maxDepth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.add(child);
                    }
                }
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                depth = Math.max(depth, maxDepth(child));
            }
        }
        return depth + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            int rightdepth = minDepth(root.right);
            return 1 + rightdepth;
        }
        if (root.left != null && root.right == null) {
            int leftdepth = minDepth(root.left);
            return 1 + leftdepth;
        }
        int leftdepth = minDepth(root.left);
        int rightdepth = minDepth(root.right);
        int min = 1 + Math.min(leftdepth, rightdepth);
        return min;
    }

    int result = 0;

    public void getminDepth(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            result = Math.min(result, depth);
            return;
        }
        if (node.left != null) {
            getminDepth(node.left, depth + 1);
        }
        if (node.right != null) {
            getminDepth(node.right, depth + 1);
        }
        return;
    }

    public void getmaxDepth(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            result = Math.max(result, depth);
            return;
        }
        if (node.left != null) {
            getmaxDepth(node.left, depth + 1);
        }
        if (node.right != null) {
            getmaxDepth(node.right, depth + 1);
        }
        return;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftcount = countNodes(root.left);
        int rightcount = countNodes(root.right);
        return leftcount + rightcount + 1;
    }

    public int fullBTcountNodes(TreeNode root) {
        if (root == null) return 0;
        int leftcount = 0;
        int rightcount = 0;
        TreeNode left = root.left;
        while (left != null) {
            leftcount++;
            left = left.left;
        }
        TreeNode right = root.right;
        while (right != null) {
            rightcount++;
            right = right.right;
        }
        if (leftcount == rightcount) {
            System.out.println(leftcount);
            return 2 << leftcount - 1;
        }
        return fullBTcountNodes(root.left) + fullBTcountNodes(root.right) + 1;
        //不能写left因为上面的循环已经移动至最后
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftdepth = 0;
        int rightdepth = 0;
        leftdepth = postordedepth(root.left);
        rightdepth = postordedepth(root.right);
        if (Math.abs(leftdepth - rightdepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        String path = "";
        if (root == null) return res;
        binaryPath(root, path, res);
        return res;
    }

    public void binaryPath(TreeNode cur, String path, List res) {
        path += cur.val;
        if (cur.left == null && cur.right == null) {
            res.add(path);
            return;
        }
        if (cur.left != null) binaryPath(cur.left, path + "->", res);
        if (cur.right != null) binaryPath(cur.right, path + "->", res);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tem = queue.poll();
                if (tem.left != null) {
                    if (tem.left.left == null && tem.left.right == null) {
                        sum += tem.left.val;
                    }
                    queue.add(tem.left);
                }
                if (tem.right != null) {
                    queue.add(tem.right);
                }

            }
        }
        return sum;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        int leftValue = sumOfLeftLeaves2(root.left);
        int rightValue = sumOfLeftLeaves2(root.right);
        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        return midValue + leftValue + rightValue;
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        int lastleft = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tem = queue.poll();
                if (i == 0) lastleft = tem.val;
                if (tem.left != null) {
                    queue.add(tem.left);
                }
                if (tem.right != null) {
                    queue.add(tem.right);
                }
            }
        }
        return lastleft;
    }

    int maxDepth = -1;
    int res;

    public int findBottomLeftValue2(TreeNode root) {
        findBottomLeft(root, 0);
        return res;
    }

    public void findBottomLeft(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            }
            return;
        }
        findBottomLeft(root.left, depth + 1);
        findBottomLeft(root.right, depth + 1);
        return;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumqueue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            sumqueue.add(root.val);
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tem = queue.poll();
                int stem = sumqueue.poll();
                if (stem == targetSum && tem.right == null && tem.left == null) {
                    return true;
                }
                if (tem.left != null) {
                    queue.add(tem.left);
                    sumqueue.add(stem + tem.left.val);
                }
                if (tem.right != null) {
                    queue.add(tem.right);
                    sumqueue.add(stem + tem.right.val);
                }
            }
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum3(TreeNode root, int sum, int pathSum) {
        if (root == null) {
            return false;
        }
        pathSum += root.val;
        if (root.left == null && root.right == null) {
            System.out.println(pathSum);
            return pathSum == sum;
        }
        boolean res = hasPathSum3(root.left, sum, pathSum) || hasPathSum3(root.right, sum, pathSum);
        return res;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        findPath(root, path, res, targetSum);
        return res;
    }

    public void findPath(TreeNode root, Deque<Integer> path, List<List<Integer>> res, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (path.size() != 0) {
                int sum = 0;
                for (Integer integer : path) {
                    sum += integer;
                }
                if (sum == target) {
                    res.add(new LinkedList<Integer>(path));
                }
            }
        }
        if (root.left != null) findPath(root.left, path, res, target);
        if (root.right != null) findPath(root.right, path, res, target);
        path.pollLast();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        int postOrderLen = postorder.length;
        int x = postorder[postOrderLen - 1];
        TreeNode root = new TreeNode(x);
        if (postorder.length == 1) return root;
        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == x) {
                break;
            }
        }
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInOrder = Arrays.copyOfRange(inorder, index + 1, postOrderLen);
        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftInOrder.length);
        int[] rightPostOrder = Arrays.copyOfRange(postorder, leftInOrder.length, leftInOrder.length + rightInOrder.length);
        root.left = buildTree(leftInOrder, leftPostOrder);//左中，左后
        root.right = buildTree(rightInOrder, rightPostOrder);//右中，右后
        return root;
    }

    int post_idx;
    int pre_idx;
    int[] preorder;
    int[] postorder;
    int[] inorder;
    int[] nums;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        post_idx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            idx_map.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        int root_val = postorder[post_idx];
        post_idx--;
        TreeNode root = new TreeNode(root_val);
        int index = idx_map.get(root_val);
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        pre_idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            idx_map.put(inorder[i], i);
        }
        return helper2(0, inorder.length - 1);
    }

    public TreeNode helper2(int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        int index = idx_map.get(preorder[pre_idx]);
        TreeNode root = new TreeNode(inorder[index]);
        pre_idx++;

        root.left = helper2(in_left, index - 1);
        root.right = helper2(index + 1, in_right);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        int[] leftArray = Arrays.copyOfRange(nums, 0, maxIndex);
        int[] rightArray = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
        root.left = constructMaximumBinaryTree(leftArray);
        root.right = constructMaximumBinaryTree(rightArray);
        return root;
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        this.nums = nums;
        return helper3(0, nums.length - 1);
    }

    public TreeNode helper3(int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int index = 0;
        int max = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
            System.out.println(index);
        }
        TreeNode root = new TreeNode(max);
        root.left = helper3(left, index - 1);
        root.right = helper3(index + 1, right);
        return root;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            System.out.println(root.val);
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    long pre = Long.MIN_VALUE;
    TreeNode pre1 = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (pre1 != null && pre1.val >= root.val) return false;
        pre1 = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }

    public boolean inorderIsBST(TreeNode root) {
        if (root == null) return true;
        boolean l = inorderIsBST(root.left);
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        boolean r = inorderIsBST(root.right);
        return l && r;
    }

    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        findmin(root);
        return min;
    }

    public void findmin(TreeNode root) {
        if (root == null) return;
        findmin(root.left);
        if (pre1 != null) {
            int tem = Math.abs(pre1.val - root.val);
            System.out.println(tem);
            if (min > tem) {
                min = tem;
            }
        }
        pre1 = root;
        findmin(root.right);
    }

    int count = 0;
    int maxCount;
    int base;
    ArrayList<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorderFind(root);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void inorderFind(TreeNode root) {
        if (root == null) return;
        inorderFind(root.left);
        update(root.val);
        inorderFind(root.right);
    }

    public void update(int val) {
        if (base == val) count++;
        else {
            count = 1;
        }
        if (count == maxCount) {
            list.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(val);
        }
        base = val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    public TreeNode postFather(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = postFather(root.left, p, q);
        TreeNode right = postFather(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } /*else if (right != null && root == q||root==q) {
            return root;
        } else if (left != null && root == q||root==q) {
            return root;
        }*/ else {
            return null;
        }

    }

    //二叉搜索树
    boolean flag = true;

    public TreeNode postFather2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int max, min;
        if (p.val > q.val) {
            max = p.val;
            min = q.val;
        } else {
            max = q.val;
            min = p.val;
        }
        if (root.val > min && root.val < max && flag) {
            System.out.println(root.val);
            flag = false;
            return root;
        }
        TreeNode left = postFather2(root.left, p, q);
        if (left != null) {
            return left;
        }
        TreeNode right = postFather2(root.right, p, q);
        if (right != null) {
            return right;
        }
        return null;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        TreeNode pre = root;
        while (cur != null) {
            if (val > cur.val) {
                pre = cur;
                cur = cur.right;
            } else {
                pre = cur;
                cur = cur.left;
            }
        }
        if (val > pre.val) {
            TreeNode treeNode = new TreeNode(val);
            pre.right = treeNode;
        } else {
            TreeNode treeNode = new TreeNode(val);
            pre.left = treeNode;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = root;
        while (cur != null) {
            if (key == cur.val) {
                break;
            } else if (key > cur.val) {
                pre = cur;
                cur = cur.right;
            } else {
                pre = cur;
                cur = cur.left;
            }
        }
        if (cur.right == null && cur.left == null) {


        }
        return root;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            // 该节点=key，左右都为空
            if (root.right == null && root.left != null) {
                return root.left;
            }
            // 右为空，左不空
            if (root.left == null & root.right != null) {
                return root.right;
            }
            // 左为空，右不空
            else {
                TreeNode cur = root.left;
                while (cur.right != null) {
                    cur = cur.right;
                }
                cur.right = root.right;
                return root.left;
            }
            // 左右都不为空
        }
        if (key > root.val) {
            root.right = deleteNode2(root.right, key);
        }
        if (key < root.val) {
            root.left = deleteNode2(root.left, key);
        }
        return root;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }
        if (root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        int index = len / 2;
        System.out.println(index);
        TreeNode treeNode = new TreeNode(nums[index]);
        treeNode.left = buildBST(nums, 0, index - 1);
        treeNode.right = buildBST(nums, index + 1, len - 1);
        return treeNode;
    }

    public TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int index = left + ((right - left) / 2);
        TreeNode treeNode = new TreeNode(nums[index]);
        treeNode.left = buildBST(nums, 0, index - 1);
        treeNode.right = buildBST(nums, index + 1, nums.length - 1);
        return treeNode;
    }

    public TreeNode convertBST(TreeNode root) {
        TreeNode treeNode = new TreeNode(0);
        convert(root,treeNode);
        return root;
    }
    public void convert(TreeNode root,TreeNode pre){
        if(root==null) return;
        convert(root.right,pre);
        root.val=root.val+pre.val;
        pre.val=root.val;
        convert(root.left,pre);
    }
}












