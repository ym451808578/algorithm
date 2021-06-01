package org.example.tree.base;


/**
 * @author Castle
 * @Date 2021/6/1 16:38
 */
public class BinaryTree {
    private PersonNode root;

    public BinaryTree(PersonNode root) {
        this.root = root;
    }

    /**
     * 前序遍历：
     * 1.输出当前节点；
     * 2.递归前序遍历左子节点（若不为空）
     * 3.递归前序遍历右子节点（若不为空）
     */
    public void preOrderList() {
        preOrderList(this.root);
    }

    private void preOrderList(PersonNode personNode) {
        System.out.println(personNode);
        if (personNode.getLeft() != null) {
            preOrderList(personNode.getLeft());
        }
        if (personNode.getRight() != null) {
            preOrderList(personNode.getRight());
        }
    }

    /**
     * 中序遍历：
     * 1.递归前序遍历左子节点（若不为空）
     * 2.输出当前节点；
     * 3.递归前序遍历右子节点（若不为空）
     */
    public void idxOrderList() {
        idxOrderList(this.root);
    }

    private void idxOrderList(PersonNode personNode) {
        if (personNode.getLeft() != null) {
            idxOrderList(personNode.getLeft());
        }
        System.out.println(personNode);

        if (personNode.getRight() != null) {
            idxOrderList(personNode.getRight());
        }
    }

    /**
     * 后序遍历：
     * 1.递归前序遍历左子节点（若不为空）
     * 2.递归前序遍历右子节点（若不为空）
     * 3.输出当前节点；
     */
    public void postOrderList() {
        postOrderList(this.root);
    }

    private void postOrderList(PersonNode personNode) {
        if (personNode.getLeft() != null) {
            postOrderList(personNode.getLeft());
        }
        if (personNode.getRight() != null) {
            postOrderList(personNode.getRight());
        }
        System.out.println(personNode);
    }

    /**
     * 前序查找
     *
     * @param id
     * @return
     */
    public PersonNode preOrderSearch(int id) {
        return preOrderSearch(this.root, id);
    }

    private PersonNode preOrderSearch(PersonNode personNode, int id) {
        System.out.println("前序查找");
        if (personNode.getId() == id) {
            return personNode;
        }
        PersonNode result = null;
        if (personNode.getLeft() != null) {
            result = preOrderSearch(personNode.getLeft(), id);
        }
        if (result != null) {
            return result;
        }
        if (personNode.getRight() != null) {
            result = preOrderSearch(personNode.getRight(), id);
        }
        return result;
    }

    /**
     * 中序查找
     *
     * @param id
     * @return
     */
    public PersonNode infixOrderSearch(int id) {
        return infixOrderSearch(this.root, id);
    }

    private PersonNode infixOrderSearch(PersonNode personNode, int id) {
        PersonNode result = null;
        if (personNode.getLeft() != null) {
            result = infixOrderSearch(personNode.getLeft(), id);
        }
        if (result != null) {
            return result;
        }
        System.out.println("中序查找");
        if (personNode.getId() == id) {
            return personNode;
        }
        if (personNode.getRight() != null) {
            result = infixOrderSearch(personNode.getRight(), id);
        }
        return result;
    }

    /**
     * 后续查找
     *
     * @param id
     * @return
     */
    public PersonNode postOrderSearch(int id) {
        return postOrderSearch(this.root, id);
    }

    private PersonNode postOrderSearch(PersonNode personNode, int id) {
        PersonNode result = null;
        if (personNode.getLeft() != null) {
            result = postOrderSearch(personNode.getLeft(), id);
        }
        if (result != null) {
            return result;
        }
        if (personNode.getRight() != null) {
            result = postOrderSearch(personNode.getRight(), id);
        }
        if (result != null) {
            return result;
        }
        System.out.println("后序查找");
        if (personNode.getId() == id) {
            return personNode;
        }
        return null;
    }

    public void deleteNode(int id) {
        deleteNode(this.root, id);
    }

    /**
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点是非叶子节点，则删除该子树
     *
     * @param personNode
     * @param id
     */
    private void deleteNode(PersonNode personNode, int id) {
        if (personNode.getId() == id) {
            personNode = null;
            return;
        }
        if (personNode.getLeft() != null && personNode.getLeft().getId() == id) {
            personNode.setLeft(null);
            return;
        }
        if (personNode.getRight() != null && personNode.getRight().getId() == id) {
            personNode.setRight(null);
            return;
        }
        if (personNode.getLeft() != null) {
            deleteNode(personNode.getLeft(), id);
        }
        if (personNode.getRight() != null) {
            deleteNode(personNode.getRight(), id);
        }
    }
}
