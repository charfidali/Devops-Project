package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StockServiceImplTest {
    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testAddStock() {
        Stock stock = new Stock();
        when(stockRepository.save(stock)).thenReturn(stock);

        Stock savedStock = stockService.addStock(stock);

        assertNotNull(savedStock);
        assertEquals(stock, savedStock);
    }

    @Test
    public void testRetrieveStock() {
        Long stockId = 1L;
        Stock stock = new Stock();
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));

        Stock retrievedStock = stockService.retrieveStock(stockId);

        assertNotNull(retrievedStock);


    }

    @Test
    public void testRetrieveAllStock() {
        Stock stock1 = new Stock();
        Stock stock2 = new Stock();
        List<Stock> stockList = Arrays.asList(stock1, stock2);
        when(stockRepository.findAll()).thenReturn(stockList);

        List<Stock> retrievedStockList = stockService.retrieveAllStock();

        assertEquals(2, retrievedStockList.size());

    }
  
}