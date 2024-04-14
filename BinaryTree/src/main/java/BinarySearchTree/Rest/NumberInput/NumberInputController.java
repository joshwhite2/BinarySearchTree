package BinarySearchTree.Rest.NumberInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NumberInputController {
    @Autowired
    private NumberInputRepository repository;

    @PostMapping("/submit-numbers")
    public ResponseEntity<String> submitNumbers(@RequestBody List<Integer> numbersList) {
        if (numbersList == null || numbersList.isEmpty()) {
            return ResponseEntity.badRequest().body("Numbers list is empty");
        }

        try {
            NumberInput tree = new NumberInput();
            tree.setNumbersList(numbersList);
            repository.save(tree);
            return ResponseEntity.ok("Numbers submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting numbers: " + e.getMessage());
        }
    }


    @GetMapping("/previous-numbers")
    public List<NumberInput> getPreviousNumbers() {
        return repository.findAll();
    }
}
