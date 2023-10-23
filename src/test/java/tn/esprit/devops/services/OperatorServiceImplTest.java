package tn.esprit.devops.services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest

class OperatorServiceImplTest {
    OperatorServiceImpl imp ;
    OperatorRepository repos;

    @Test
    void testretrieveAllOperators() {
        List<Operator> op = imp.retrieveAllOperators();
        assertNotEquals(0, op.size());
    }

    @Test
    void testaddOperator() {

        Operator op = new Operator(1, "kacem", "yedes", "kacem@gmail.com");
        Operator a = imp.addOperator(op);
        assertEquals(op.getIdOperateur(), a);
    }

    @Test
    void testdeleteOperator() {
        Operator op = new Operator(1, "kacem", "yedes", "kacem@gmail.com");
        repos.save(op);
        repos.deleteById((long) op.getIdOperateur());
        Optional optional = repos.findById((long) op.getIdOperateur());
        assertEquals(Optional.empty(), optional);
    }

    @Test
    void testupdateOperator() {
        Operator op = new Operator(1, "kacem", "yedes", "kacem@gmail.com");
        Operator a = imp.updateOperator(op);
        assertEquals(op.getIdOperateur(), a);
    }

    @Test
    void testretrieveOperator() {

        Operator op = new Operator(1, "kacem", "yedes", "kacem@gmail.com");
        Operator op1 = new Operator(2, "yossr", "boushih", "yossr@gmail.com");
        Optional<Operator> optional =  repos.findById((long) op1.getIdOperateur());
        assertEquals(op1.getIdOperateur(), optional.get().getIdOperateur());
        assertEquals(op1.getFname(), optional.get().getFname());
    }
    }
