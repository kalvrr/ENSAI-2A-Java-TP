package fr.ensai.elevator;

import static fr.ensai.elevator.Elevator.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CrazyElevator extends Elevator {

    private static Random random = new Random();

    // Constructeur
    public CrazyElevator(int id, int capacity, int currentFloor) {
        super(id, capacity, currentFloor);
    }

    /**
     * Overrides the move() method from the normal Elevator class. 
     * It has 3 possible behaviours with same probability : It can either remain stationnary, skip the next destination
     * behave as normal.
     * 
     */
    @Override
    public void move() {
        var index = random.nextInt(3);
        // remain stationnary
        if (index == 0){
            return;
        }
        // skip next destination
        if (index == 1){
            destinationQueue.removeFirst();
            this.currentFloor = destinationQueue.removeFirst();
        }
        // normal behaviour
        if (index == 2 && !destinationQueue.isEmpty())
            if (!destinationQueue.isEmpty()){
                Integer nextFloor = destinationQueue.removeFirst();
                if (nextFloor > this.currentFloor) {
                    this.direction = Direction.UP;
                } else if (nextFloor < this.currentFloor) {
                    this.direction = Direction.DOWN;
                } else {
                    this.direction = Direction.IDLE;
                }
            this.currentFloor = nextFloor;
            } else {
                this.direction = Direction.IDLE;
            }
    }


    /**
     * Overrides the unloadPassengers(floor) from the Elevator class.
     * It has a 1/2 probability of behaving normally : unloads passengers whose target floor matches the current floor.
     * In the other case : it unloads no passenger.
     * 
     * @param floor the Floor where passengers will exit
     * @return the number of passengers unloaded
     */
    @Override
    public int unloadPassengers(Floor floor) {
        var index = random.nextInt(2);
        // No unloaded passengers : return 0
        if (index == 0){
            return 0;
        }
        this.lastUnloaded.clear();
        List<Person> remaining = new ArrayList<>();
        for (Person p : this.passengers) {
            if (p.getTargetFloor() == floor.getNumber()) {
                this.lastUnloaded.add(p);
                logger.info("Floor {}: {}{} leaves Elevator {}",
                        floor.getNumber(),
                        p.getNickname(),
                        p.getTargetFloor(),
                        this.id);
            } else {
                remaining.add(p);
            }
        }
        this.passengers = remaining;
        return this.lastUnloaded.size();
    }

    /**
     * Checks if the elevator is full and, if so, sends the passengers into another dimension 
     * 
     * @return boolean
     */
    @Override
    public boolean isFull(){
        if (capacity == passengers.size()){
            this.passengers.clear();
            return true;
        }
        return false;
    }
}
