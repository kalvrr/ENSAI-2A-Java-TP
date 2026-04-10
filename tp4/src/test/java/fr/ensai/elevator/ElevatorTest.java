package fr.ensai.elevator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElevatorTest{
    
    private Elevator elevator;
    private Person person1;
    private Person person2; 
    private Person person3;
    final int elevatorCapacity = Config.getInt("hotel.elevator.capacity");

    /*
    * Initialise un nouvel ascenseur 
    avec une capacité de 3 avant chaque test et 3 personnes 
    */ 

    @BeforeEach
        void setUp() {
            elevator = new Elevator( 1, 0, 3);
            person1 = new Person(0);
            person2 = new Person(0);
            person3 = new Person(2);
        }
    
    
    /* 
     * Teste la fonction isFull vérifie que 
     l'ascenseur n'est pas remplie quand il est vide 
     et qu'il est plein une fois qu'il atteint sa capacité maximum
     */

    @Test
    void testremplissageIsFull(){
        //Given
        assertFalse(elevator.isFull());
        //When
        elevator.spawnPassengers(List.of(person1, person2, person3));
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
        assertEquals(1, elevator.getDestinationQueueStr().length());
        assertTrue(elevator.getDestinationQueueStr().contains("3"));
    }
}