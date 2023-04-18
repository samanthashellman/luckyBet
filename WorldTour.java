public class WorldTour implements SlotTypes{
    
    String[] Countries = {"Canada", "Mexico", "Japan", "Austria", "Ghana", "Russia", "Morocco", "South Africa", "China", "Mongolia", "Brazil", "Australia", "Chile", "Nigeria", "India"};
    String[] results = {"", "", ""};

    public String[] getResults(){
        // TODO: make this more complex

        results[0] = Countries[rand.nextInt(Countries.length)];
        results[1] = Countries[rand.nextInt(Countries.length)];
        results[2] = Countries[rand.nextInt(Countries.length)];

        return results;
    }
}
