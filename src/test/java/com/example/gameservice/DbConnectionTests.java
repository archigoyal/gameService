package com.example.gameservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class DbConnectionTests {

    @Test
    void DbConnectionTest(){
        DbConnection db=new DbConnection();
        assertTrue(true)
        ;
    }
}
