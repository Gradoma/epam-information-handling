package by.epamtraining.iht.ext.cor;

public class MinToSecConverter extends Converter {
//    {nextConverter = null;}

    public MinToSecConverter(){
        super(null);
    }

    @Override
    public int convert(int period) {
        int delim = 60;
        int sec = period * delim;
        return convertNext(sec);
    }
}
