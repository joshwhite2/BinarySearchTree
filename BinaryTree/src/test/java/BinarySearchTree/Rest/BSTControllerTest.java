package BinarySearchTree.Rest;
import BinarySearchTree.Rest.BSTBuilder.BSTBuilder;
import BinarySearchTree.Rest.BSTBuilder.BSTController;
import BinarySearchTree.Rest.BSTBuilder.BSTService;
import BinarySearchTree.Rest.NumberInput.NumberInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BSTControllerTest {

    @Mock
    private BSTService binarySearchTreeService;

    @InjectMocks
    private BSTController bstController;

    @Test
    public void testGetAllBinaryTrees() {
        // Create some dummy data
        List<BSTBuilder> binaryTrees = Arrays.asList(
                new BSTBuilder(/* pass constructor arguments if needed */),
                new BSTBuilder(/* pass constructor arguments if needed */)
        );

        // Mock the service method to return the dummy data
        when(binarySearchTreeService.getAllBinaryTrees()).thenReturn(binaryTrees);

        // Call the controller method
        List<BSTBuilder> result = bstController.getAllBinaryTrees();

        // Verify that the service method was called
        verify(binarySearchTreeService, times(1)).getAllBinaryTrees();

        // Verify that the result matches the dummy data
        assertEquals(binaryTrees, result);
    }

    @Test
    public void testBuildBSTFromInput() {
        // Create a dummy NumberInput object
        NumberInput numberInput = new NumberInput(/* pass constructor arguments if needed */);

        // Mock the service method
        doNothing().when(binarySearchTreeService).saveBSTBuilder(any(BSTBuilder.class));

        // Call the controller method
        String response = bstController.buildBSTFromInput(numberInput);

        // Verify that the service method was called with the correct arguments
        verify(binarySearchTreeService, times(1)).saveBSTBuilder(any(BSTBuilder.class));

        // Optionally, assert on the response message if needed
        assertEquals("Binary search tree built and saved successfully.", response);
    }
}
