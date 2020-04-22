package by.epamtraining.iht.ext.composite;

public class Item implements Parcel {
    private int weight;

    public Item(int weight){
        this.weight = weight;
    }

    @Override
    public int countWeight() {
        return weight;
    }
}
