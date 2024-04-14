package BinarySearchTree.Rest;

import BinarySearchTree.Rest.BSTBuilder.BSTBuilder;
import BinarySearchTree.Rest.BSTBuilder.BSTBuilderRepository;

import BinarySearchTree.Rest.BSTBuilder.BSTService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BSTServiceTest {

    @Mock
    private BSTBuilderRepository repository;

    @InjectMocks
    private BSTService service;

    @Test
    public void testSaveBSTBuilder() {
        // Prepare a BSTBuilder object
        BSTBuilder bstBuilder = new BSTBuilder(/* pass constructor arguments if needed */);

        // Call the service method
        service.saveBSTBuilder(bstBuilder);

        // Verify that the repository save method was called with the BSTBuilder object
        verify(repository, times(1)).save(bstBuilder);
    }

    @Test
    public void testGetAllBinaryTrees() {
        // Prepare dummy data
        List<BSTBuilder> binaryTrees = Arrays.asList(
                new BSTBuilder(/* pass constructor arguments if needed */),
                new BSTBuilder(/* pass constructor arguments if needed */)
        );

        // Mock the repository findAll method
        when(repository.findAll()).thenReturn(binaryTrees);

        // Call the service method
        List<BSTBuilder> result = service.getAllBinaryTrees();

        // Verify that the repository findAll method was called
        verify(repository, times(1)).findAll();

        // Check the result
        assertEquals(binaryTrees, result);
    }

    // You can write more tests for different scenarios as needed
}

