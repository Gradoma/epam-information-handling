package by.epamtraining.iht.ext.cor;

public class WeeksToDays extends Converter {

    public WeeksToDays(){
        super(new DaysToHoursConverter());
    }

    @Override
    public int convert(int period) {
        int delimiter = 4;
        int days = period * delimiter;
        return convertNext(days);
    }
}
