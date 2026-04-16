import java.util.*;
class Solution {
        public TreeNode recoverFromPreorder(String traversal) {
                List<int[]> list = new ArrayList<>();
                int level = 1;
                String[] arr = traversal.split("-");
                for (String c : arr) {
                        if (c.equals("")) {
                                level++;
                        } else {
                                int ele = Integer.parseInt(c);
                                list.add(new int[] { ele, level });
                                level = 1;
                        }
                }
                list.get(0)[1]--;
                Map<Integer, TreeNode> levelMap = new HashMap<>();
                TreeNode root = new TreeNode(list.get(0)[0]);
                levelMap.put(0, root);
                for (int i = 1; i < list.size(); i++) {
                        int val = list.get(i)[0];
                        int lvl = list.get(i)[1];
                        TreeNode node = new TreeNode(val);
                        TreeNode parent = levelMap.get(lvl - 1);
                        if (parent.left == null) {
                                parent.left = node;
                        } else {
                                parent.right = node;
                        }
                        levelMap.put(lvl, node);
                }
                return root;
        }
}