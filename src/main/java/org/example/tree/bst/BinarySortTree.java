package org.example.tree.bst;

/**
 * @author Castle
 * @Date 2021/6/7 16:11
 */
public class BinarySortTree {
    private int[] arr;

    public BinarySortTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 创建二叉排序树
     *
     * @param arr
     */
    public Node createTree(int[] arr) {
        Node root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            createTree(root, new Node(arr[i]));
        }
        System.out.println(root.height());
        System.out.println(root.leftHeight());
        System.out.println(root.rightHeight());
        //当右子树的高度-左子树的高度>1时，左旋
        if (root.rightHeight() - root.leftHeight() > 1) {
            if (root.getRight() != null && root.getRight().leftHeight() > root.getRight().rightHeight()) {
                rightRotate(root.getRight());
            }
            leftRotate(root);
        } else if (root.leftHeight() - root.rightHeight() > 1) {
            if (root.getLeft() != null & root.getLeft().rightHeight() > root.getLeft().leftHeight()) {
                leftRotate(root.getLeft());
            }
            rightRotate(root);
        }
        return root;
    }

    /**
     * 创建二叉排序树
     *
     * @param root
     * @param node
     */
    private void createTree(Node root, Node node) {
        if (node == null) {
            return;
        }
        if (root == null) {
            root = node;
        }
        if (node.getValue() < root.getValue()) {
            if (root.getLeft() == null) {
                root.setLeft(node);
            } else {
                createTree(root.getLeft(), node);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(node);
            } else {
                createTree(root.getRight(), node);
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void infixOrder(Node root) {
        if (root.getLeft() != null) {
            infixOrder(root.getLeft());
        }
        System.out.println(root);
        if (root.getRight() != null) {
            infixOrder(root.getRight());
        }
    }

    /**
     * 查找节点
     *
     * @param root
     * @param value
     * @return
     */
    public Node search(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (root.getValue() == value) {
            return root;
        } else if (root.getValue() > value) {
            return search(root.getLeft(), value);
        } else {
            return search(root.getRight(), value);
        }
    }

    /**
     * 查找父节点
     *
     * @param root
     * @param value
     * @return
     */
    public Node searchParent(Node root, int value) {
        boolean flag = (root.getLeft() != null && root.getLeft().getValue() == value) || (root.getRight() != null && root.getRight().getValue() == value);
        if (flag) {
            return root;
        }
        if (root.getLeft() != null && root.getValue() > value) {
            return searchParent(root.getLeft(), value);
        }
        if (root.getRight() != null && root.getValue() < value) {
            return searchParent(root.getRight(), value);
        }
        return null;
    }

    /**
     * 删除节点
     *
     * @param root
     * @param value
     */
    public void deleteNode(Node root, int value) {
        Node targetNode = search(root, value);
        if (targetNode == null) {
            return;
        }
        Node parentNode = searchParent(root, value);
        if (parentNode == null) {
            root = null;
            return;
        }
        //如果是叶子节点
        if (targetNode.getLeft() == null && targetNode.getRight() == null) {
            if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == value) {
                parentNode.setLeft(null);
                return;
            }
            if (parentNode.getRight() != null && parentNode.getRight().getValue() == value) {
                parentNode.setRight(null);
                return;
            }
        }

        //如果是有左右两个子节点的节点
        if (targetNode.getLeft() != null && targetNode.getRight() != null) {
            int nodeValue = deleteRightChildMinNode(targetNode);
            targetNode.setValue(nodeValue);
            return;
        }

        //只有左子节点
        if (targetNode.getLeft() != null) {
            //当前节点是父节点的左子节点
            if (parentNode.getLeft().getValue() == value) {
                parentNode.setLeft(targetNode.getLeft());
            } else {
                //当前节点是父节点的右子节点
                parentNode.setRight(targetNode.getLeft());
            }
            return;
        }

        //只有右子节点
        if (targetNode.getRight() != null) {
            //当前节点是父节点的左子节点
            if (parentNode.getLeft().getValue() == value) {
                parentNode.setLeft(targetNode.getRight());
            } else {
                parentNode.setRight(targetNode.getRight());
            }
        }
    }

    /**
     * 删除右子节点下的最小子节点
     *
     * @param node
     */
    private int deleteRightChildMinNode(Node node) {
        Node temp = node;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        deleteNode(node, temp.getValue());
        return temp.getValue();
    }

    /**
     * 左旋转：
     * 1。 以当前根节点的值，创建一个新的节点；
     * 2。 将当前根节点的左子树，设置为新节点的左子树
     * 3。 将当前根节点的右子树的左子树，设置为新节点的右子树
     * 4。 把当前根结点的值，替换为其右子节点的值
     * 5。 把当前根节点的右子树的右子树，设置为当前根结点的右子树
     * 6。 把新的节点，设置为当前根节点的左子树
     *
     * @param root
     */
    private void leftRotate(Node root) {
        Node temp = new Node(root.getValue());
        temp.setLeft(root.getLeft());
        temp.setRight(root.getRight().getLeft());
        root.setValue(root.getRight().getValue());
        root.setRight(root.getRight().getRight());
        root.setLeft(temp);
    }

    /**
     * 右旋：
     * 1。 以当前根节点的值，创建一个新的节点；
     * 2。 将当前根节点的右子树，设置为新节点的右子树
     * 3。 将当前根节点的左子树的右子树，设置为新节点的左子树
     * 4。 把当前根结点的值，替换为其左子节点的值
     * 5。 把当前根节点的左子树的左子树，设置为当前根结点的左子树
     * 6。 把新的节点，设置为当前根节点的右子树
     *
     * @param root
     */
    private void rightRotate(Node root) {
        Node temp = new Node(root.getValue());
        temp.setRight(root.getRight());
        temp.setLeft(root.getLeft().getRight());
        root.setValue(root.getLeft().getValue());
        root.setLeft(root.getLeft().getLeft());
        root.setRight(temp);
    }
}
