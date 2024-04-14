package BinarySearchTree.Rest.Node;

import jakarta.persistence.*;

@Entity
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "left_child_id")
    private Node left;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "right_child_id")
    private Node right;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}