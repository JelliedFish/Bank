package bank_model.utils;

import java.util.ArrayList;

public class Utils {

    public static double getInterestOnBalance(ArrayList<Pair<Pair<Double, Double>,Double>> depositChoices, double startBalance){
        for (Pair<Pair<Double, Double>,Double> choice:
             depositChoices) {
            if(startBalance >= choice.first.first && startBalance <= choice.first.second)
                return choice.second;
        }
        return -0.0;
    }
}
