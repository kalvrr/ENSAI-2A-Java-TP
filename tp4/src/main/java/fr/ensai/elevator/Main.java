package fr.ensai.elevator;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {

        // --------------------------------------------------------------------
        // Create Floors, Elevators and Hotel
        // --------------------------------------------------------------------

        final int elevatorCapacity = Config.getInt("hotel.elevator.capacity");
        final int nbSteps = Config.getInt("steps.count");
        final int msBetweenSteps = Config.getInt("steps.delay");
        final int floorNumber = Config.getInt("hotel.floors.number");
        final int elevatorQuantity = Config.getInt("hotel.elevator.quantity");
        final int crazyElevatorQuantity = Config.getInt("hotel.crazy-elevator.quantity");


        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < floorNumber; i++){
            floors.add(new Floor(i));
        }

        List<Elevator> elevators = new ArrayList<>();
        for (int i = 1; i <= elevatorQuantity; i++){
            elevators.add(new Elevator(i, 0, elevatorCapacity));
        }
        for (int i = 1; i <= crazyElevatorQuantity; i++){
            elevators.add(new CrazyElevator(i, 0, elevatorCapacity));
        }

        Hotel hotel = new Hotel(floors, elevators);

        // --------------------------------------------------------------------
        // Run simulation
        // --------------------------------------------------------------------

        for (int step = 1; step <= nbSteps; step++) {
            logger.info("\nStep: {}\n--------", step);

            hotel.update();
            hotel.spawnPerson();
            hotel.display(step);
            Thread.sleep(msBetweenSteps);
        }
    }

}