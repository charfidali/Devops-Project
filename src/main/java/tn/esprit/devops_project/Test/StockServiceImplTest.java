package tn.esprit.devops_project.Test;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.Iservices.IStockService;
import tn.esprit.devops_project.services.StockServiceImpl;

import java.util.List;

@SpringBootTest
public class StockServiceImplTest {
    @Autowired
    private StockServiceImpl stockService;

    @Autowired
    private StockRepository stockRepository;

    @AfterEach
    public void cleanUp() {
        // Clean up the test database
        stockRepository.deleteAll();
    }

    @Test
    public void testAddStock() {
        // Create a Stock object to add
        Stock stock = new Stock();
        // Add it to the database using the service
        Stock addedStock = stockService.addStock(stock);

        // Retrieve the added stock by its ID
        Stock retrievedStock = stockService.retrieveStock(addedStock.getIdStock());

        // Assert that the retrieved stock matches the added stock
        Assertions.assertEquals(addedStock, retrievedStock);
    }

    @Test
    public void testRetrieveAllStock() {
        // Add some stocks to the database
        Stock stock1 = stockService.addStock(new Stock());
        Stock stock2 = stockService.addStock(new Stock());

        // Retrieve all stocks
        List<Stock> stockList = stockService.retrieveAllStock();

        // Assert that the list contains the added stocks
        Assertions.assertTrue(stockList.contains(stock1));
        Assertions.assertTrue(stockList.contains(stock2));
    }
}

