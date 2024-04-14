package BinarySearchTree.Rest;

import BinarySearchTree.Rest.BSTBuilder.BSTBuilder;
import BinarySearchTree.Rest.BSTBuilder.BSTController;
import BinarySearchTree.Rest.BSTBuilder.BSTService;
import BinarySearchTree.Rest.NumberInput.NumberInput;
import BinarySearchTree.Rest.NumberInput.NumberInputController;
import BinarySearchTree.Rest.NumberInput.NumberInputRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NumberInputControllerTest {

    @Mock
    private NumberInputRepository repository;

    @InjectMocks
    private NumberInputController controller;

    @Test
    public void testSubmitNumbers_Success() {

        when(repository.save(any(NumberInput.class))).thenReturn(new NumberInput());

        // Prepare test data
        List<Integer> numbersList = Arrays.asList(1, 2, 3);

        // Call the controller method
        ResponseEntity<String> responseEntity = controller.submitNumbers(numbersList);

        // Verify that the repository save method was called
        verify(repository, times(1)).save(any(NumberInput.class));

        // Check the response status
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Numbers submitted successfully", responseEntity.getBody());
    }

    @Test
    public void testSubmitNumbers_EmptyList() {
        // Prepare empty test data
        List<Integer> emptyList = Collections.emptyList();

        // Call the controller method with an empty list
        ResponseEntity<String> responseEntity = controller.submitNumbers(emptyList);

        // Verify that the repository save method was not called
        verify(repository, never()).save(any());

        // Check the response status
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Numbers list is empty", responseEntity.getBody());
    }

    // You can write more tests for different scenarios as needed

    @Test
    public void testGetPreviousNumbers() {
        // Prepare dummy data
        List<NumberInput> numberInputs = Arrays.asList(
                new NumberInput(/* pass constructor arguments if needed */),
                new NumberInput(/* pass constructor arguments if needed */)
        );

        // Mock the repository findAll method
        when(repository.findAll()).thenReturn(numberInputs);

        // Call the controller method
        List<NumberInput> result = controller.getPreviousNumbers();

        // Verify that the repository findAll method was called
        verify(repository, times(1)).findAll();

        // Check the result
        assertEquals(numberInputs, result);
    }
}
