package com.example.study4_listdetails.Core;

import com.example.study4_listdetails.R;

import java.util.ArrayList;


public class DbHelper {

    private ArrayList<Car> simpleDB = new ArrayList<Car>();

    public ArrayList<Car> getCars(){
        simpleDB.clear();
        simpleDB.add(new Car(1, R.drawable.ford_focus_icon, R.drawable.ford_focus, "Ford Focus", "1.6", "125", "1 102 000", R.string.ford_focus_desc));
        simpleDB.add(new Car(2, R.drawable.honda_crv_icon, R.drawable.honda_crv, "Honda CR-V", "2.0", "150", "1 869 900", R.string.honda_crv_desc));
        simpleDB.add(new Car(3, R.drawable.hyundai_sonata_icon, R.drawable.hyundai_sonata, "Hyundai Sonata", "2.4", "188", "1 775 000", R.string.hyundai_sonata_desc));
        simpleDB.add(new Car(4, R.drawable.lexus_rx350_icon, R.drawable.lexus_rx350, "Lexus RX-350", "3.5", "301", "4 434 000", R.string.lexus_rx350_desc));
        simpleDB.add(new Car(5, R.drawable.mazda_mazda6_icon, R.drawable.mazda_mazda6, "Mazda 6", "2.5", "194", "1 941 000", R.string.mazda_mazda6_desc));
        simpleDB.add(new Car(6, R.drawable.mitsubishi_pajero_icon, R.drawable.mitsubishi_pajero, "Mitsubishi Pajero", "3.2", "200", "3 030 000", R.string.mitsubishi_pajero_desc));
        simpleDB.add(new Car(7, R.drawable.skoda_octavia_icon, R.drawable.skoda_octavia, "Scoda Octavia", "1.8", "180", "1 547 000", R.string.skoda_octavia_desc));
        simpleDB.add(new Car(8, R.drawable.volkswagen_touareg_icon, R.drawable.volkswagen_touareg, "Volkswagen Touareg", "3.0", "249", "4 369 000", R.string.volkswagen_touareg_desc));

        return simpleDB;
    }


    public Car getCarByPosition(int position){
        return simpleDB.get(position);
    }


}
