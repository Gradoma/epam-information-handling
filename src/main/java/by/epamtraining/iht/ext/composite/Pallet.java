package by.epamtraining.iht.ext.composite;

import java.util.ArrayList;
import java.util.List;

public class Pallet implements Parcel {
    private List<Parcel> insideParcels = new ArrayList<>();

    public void addToPallet(Parcel newParcel){
        insideParcels.add(newParcel);
    }

    public void removeFromPallet(Parcel p){
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
