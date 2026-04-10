package fr.ensai.elevator;

import static fr.ensai.elevator.Elevator.logger;

import java.util.ArrayList;
import java.util.List;

public class CrazyElevator extends Elevator {

    // Constructeur
    public CrazyElevator(int id, int capacity, int currentFloor) {
        super(id, capacity, currentFloor);
    }


        /**
     * Unloads passengers whose target floor matches the current floor.
     * Updates the lastUnloaded list.
     * 
     * @param floor the Floor where passengers will exit
     * @return the number of passengers unloaded
     */
    @Override
    public int unloadPassengers(Floor floor) {
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
}
