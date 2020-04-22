package by.epamtraining.iht.ext.composite;

import java.util.ArrayList;
import java.util.List;

public class Container implements Parcel {
    private List<Parcel> insideParcels = new ArrayList<>();

    public void addToContainer(Parcel newParcel){
        insideParcels.add(newParcel);
    }

    public void removeFromContainer(Parcel p){
        insideParcels.remove(p);
    }

    public List<Parcel> getInsideParcels() {
        return insideParcels;
    }

    @Override
    public int countWeight() {
        int totalWeight = 0;
        for (Parcel parcel : insideParcels){
            totalWeight += parcel.countWeight();
        }
        return totalWeight;
    }
}
