public class FruitFrenzy implements SlotTypes{

    String[] Fruits = {"Apple", "Orange", "Banana", "Grape", "Papaya", "Pineapple", "Mango", "Raspberry", "Cherry", "Lemon"};
    String[] results = {"", "", ""};

    public String[] getResults(){

        results[0] = Fruits[rand.nextInt(Fruits.length)];
        results[1] = Fruits[rand.nextInt(Fruits.length)];
        results[2] = Fruits[rand.nextInt(Fruits.length)];

        return results;
    }

    
}
