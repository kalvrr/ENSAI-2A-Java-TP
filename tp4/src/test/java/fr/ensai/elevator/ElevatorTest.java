package fr.ensai.elevator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElevatorTest{
    
    private Elevator elevator;
    private Person person;

    /*
    * Initialise un nouvel ascenseur 
    avec une capacité de 5 avant chaque test
    */ 

    @BeforeEach
        void setUp() {
            elevator = new Elevator(id = 1, startFloor = 0, capacity = 5);
    }
    
    /* 
     * Teste la fonction isFull vérifie que 
     l'ascenseur est pas remplie quand il est vide 
     et qu'il est plein une fois qu'il atteint sa capacité maximum
     */

    @Test
    void test_remplissage_IsFull(){
        //Given
        assertFalse(elevator.isFull());
        //When
        for (int i = 0; i < elevator.getCapacity(); i++){
            elevator.spawnPerson(new Person(0, 1));
        }
        //Then
        assertTrue(elevator.isFull());
    }

    /* 
     * Teste la fonction addDestination vérifie que 
     l'ascenseur ajoute correctement une nouvelle destination
     */

    @Test
    void test_addDestination(){
        //Given
        
        //When
        elevator.addDestination(3);
        //Then
        assertEquals(1, elevator.getDestinations().size());
        assertTrue(elevator.getDestinations().contains(3));
    }
}