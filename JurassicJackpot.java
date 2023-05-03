public class JurassicJackpot implements SlotTypes {

    String[] Dinosaurs = {"Stegosaurus", "T-rex", "Velociraptor", "Pterodactyl", "Brachiosaurus", "Megalodon"};
    String[] results = {"", "", ""};

    public String[] getResults(){

        results[0] = Dinosaurs[rand.nextInt(Dinosaurs.length)];
        results[1] = Dinosaurs[rand.nextInt(Dinosaurs.length)];
        results[2] = Dinosaurs[rand.nextInt(Dinosaurs.length)];

        return results;
    }
    
}
