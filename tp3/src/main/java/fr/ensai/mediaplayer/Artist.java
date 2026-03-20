package fr.ensai.mediaplayer;


public class Artist {
    // Attributes
    private String firstName;
    private String lastName;
    private String nationality;

    /**
     * Constructs a new Artist object.
     * @param firstName
     * @param lastName
     * @param nationality
     */
    public Artist(String firstName, String lastName, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    // methode tostring
    @Override
    public String toString() {
        return String.format("Artist %s %s", this.firstName, this.lastName);
    }

}

