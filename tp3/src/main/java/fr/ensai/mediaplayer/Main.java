package fr.ensai.mediaplayer;

public class Main {
    public static void main(String[] args) {

        Artist theChamps = new Artist("The Champs", null, "American");
        Song tequila = new Song("Tequila", theChamps, 1958, 213,
            "🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 Tequila! 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 Tequila! 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 🎷 Tequila!", null, null);
        
        tequila.play();
    }
}
