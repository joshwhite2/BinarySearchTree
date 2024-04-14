package BinarySearchTree.Rest.NumberInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberInputService {
    @Autowired
    private NumberInputRepository repository;


    public void saveNumbersList(List<Integer> numbersList) {
        NumberInput tree = new NumberInput();
        tree.setNumbersList(numbersList);
        repository.save(tree);
    }


    public List<NumberInput> getAllBinarySearchTrees() {
        return repository.findAll();
    }
}

