package tn.esprit.devops.services;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OperatorServiceImplTest {
//mockito howa test dynamique w juinit statique
    @InjectMocks
    private OperatorServiceImpl operatorService;

    @Mock
    private OperatorRepository operatorRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllOperators() {
        // Créez une liste factice d'opérateurs que vous attendez de recevoir depuis le repository
        List<Operator> expectedOperators = Arrays.asList(
                new Operator(1, "yossr", " boushih"),
                new Operator(2, "yassmine", "boushih")
        );

        Mockito.when(operatorRepository.findAll()).thenReturn(expectedOperators);
        List<Operator> actualOperators = operatorService.retrieveAllOperators();
        assertEquals(expectedOperators, actualOperators);
    }
    @Test
    public void testAddOperator() {
        Operator newOperator = new Operator(1, "yossr", "boushih");
        Mockito.when(operatorRepository.save(newOperator)).thenReturn(newOperator);
        Operator addedOperator = operatorService.addOperator(newOperator);
        assertEquals(newOperator, addedOperator);
    }
    @Test
    public void testDeleteOperator() {
        Long operatorIdToDelete = 1L;
        Mockito.doNothing().when(operatorRepository).deleteById(operatorIdToDelete);
        operatorService.deleteOperator(operatorIdToDelete);
        Mockito.verify(operatorRepository).deleteById(operatorIdToDelete);
    }
    @Test
    public void testUpdateOperator() {
        Operator operatorToUpdate = new Operator(1, "Opérateur à mettre à jour", "Ancienne adresse");
        Mockito.when(operatorRepository.save(operatorToUpdate)).thenReturn(operatorToUpdate);
        Operator updatedOperator = operatorService.updateOperator(operatorToUpdate);
        assertEquals(operatorToUpdate, updatedOperator);
    }

    @Test
    public void testRetrieveOperator() {
        Long operatorIdToRetrieve = 1L; //
        Operator expectedOperator = new Operator(operatorIdToRetrieve.intValue(), "yossr", "boushih");
        Mockito.when(operatorRepository.findById(operatorIdToRetrieve)).thenReturn(Optional.of(expectedOperator));
        Operator retrievedOperator = operatorService.retrieveOperator(operatorIdToRetrieve);
        assertEquals(expectedOperator, retrievedOperator);
    }
}




