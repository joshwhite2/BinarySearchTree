package BinarySearchTree.Rest.BSTBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BSTService {

    @Autowired
    private BSTBuilderRepository bstBuilderRepository;

    // Method to create and save a new BSTBuilder instance
    public void saveBSTBuilder(BSTBuilder bstBuilder) {
        bstBuilderRepository.save(bstBuilder);
    }

    public void operateOnBinarySearchTree(int inputId) {
    }

    public List<BSTBuilder> getAllBinaryTrees() {
        return bstBuilderRepository.findAll();
    }
}
