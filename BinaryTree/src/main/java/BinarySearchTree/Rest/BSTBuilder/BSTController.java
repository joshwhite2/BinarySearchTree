package BinarySearchTree.Rest.BSTBuilder;
import BinarySearchTree.Rest.NumberInput.NumberInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/binarySearchTree")
public class BSTController {
    @Autowired
    private BSTService binarySearchTreeService;

    @GetMapping("/getAllBinaryTrees")
    public List<BSTBuilder> getAllBinaryTrees() {
        return binarySearchTreeService.getAllBinaryTrees();
    }
    @PostMapping("/build-bst")
    public String buildBSTFromInput(@RequestBody NumberInput numberInput) {
        BSTBuilder bstBuilder = new BSTBuilder();
        bstBuilder.constructBSTFromNumberInput(numberInput);
        binarySearchTreeService.saveBSTBuilder(bstBuilder);
        return "Binary search tree built and saved successfully.";
    }
}

