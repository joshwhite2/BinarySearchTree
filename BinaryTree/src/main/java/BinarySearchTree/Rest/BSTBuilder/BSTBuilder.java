package BinarySearchTree.Rest.BSTBuilder;

import BinarySearchTree.Rest.Node.Node;
import BinarySearchTree.Rest.NumberInput.NumberInput;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BSTBuilder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "root_id")
    private Node rootNode;

    // Constructor
    public BSTBuilder() {
        rootNode = null;
    }

    // Method to insert a new node with given data
    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.getData()) {
            root.setLeft(insertRec(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(insertRec(root.getRight(), data));
        }

        return root;
    }

    // Method to construct BST from NumberInput
    public void constructBSTFromNumberInput(NumberInput numberInput) {
        List<Integer> numbersList = numberInput.getNumbersList();
        for (int num : numbersList) {
            rootNode = insertRec(rootNode, num);
        }
    }

    // Getters and setters
    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }
}
