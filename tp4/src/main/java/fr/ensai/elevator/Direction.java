package fr.ensai.elevator;

public enum Direction {
        UP,
        DOWN,
        IDLE;

    public String getArrow() {
            switch (this) {
                case UP:   return "↑";
                case DOWN: return "↓";
                case IDLE: return " ";
                default: return " ";
            }
        }
}