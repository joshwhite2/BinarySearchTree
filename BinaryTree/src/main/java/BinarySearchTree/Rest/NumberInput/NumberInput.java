package BinarySearchTree.Rest.NumberInput;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class NumberInput {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

    private List<Integer> numbersList;

    public NumberInput(List<Integer> numbersList) {

        this.numbersList = numbersList;
    }
    public NumberInput(){}



    public List<Integer> getNumbersList() {
        return numbersList;
    }

    public void setNumbersList(List<Integer> numbersList) {
        this.numbersList = numbersList;
    }}


