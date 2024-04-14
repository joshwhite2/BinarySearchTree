package BinarySearchTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class HTMLController {

    @GetMapping("/enter-numbers")
    public String showEnterNumbersPage() {
        return "enter-numbers";
    }
    @PostMapping("/process-numbers")
    @ResponseBody
    public String processNumbers(@RequestBody List<Integer> numbersList) {
        // Handle the list of numbers here
        return "Numbers processed successfully";
    }
}
