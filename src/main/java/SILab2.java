import java.util.ArrayList;
import java.util.List;

class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {

    public static List<Integer> function(List<Time> timesList) {
        List<Integer> result = new ArrayList<>();//A.0

        for (int i = 0; //A.1
             i < timesList.size(); //A.2
             i++) { //A.3
            int hr = timesList.get(i).getHours(); //B
            int min = timesList.get(i).getMinutes(); //C
            int sec = timesList.get(i).getSeconds(); //D
            if (hr < 0 || hr > 24){ //E
                if (hr < 0){ //F
                    throw new RuntimeException("The hours are smaller than the minimum"); //G
                }
                else {
                    throw new RuntimeException("The hours are grater than the maximum"); //H
                }
            } //I
            else if (hr < 24) { //J
                if (min < 0 || min > 59) //K
                    throw new RuntimeException("The minutes are not valid!"); //L
                else {
                    if (sec >= 0 && sec <= 59) //M
                        result.add(hr * 3600 + min * 60 + sec); //N
                    else
                        throw new RuntimeException("The seconds are not valid"); //O
                }
            } //P
            else if (hr == 24 && min == 0 && sec == 0) { //Q
                result.add(hr * 3600 + min * 60 + sec); //R
            }
            else {
                throw new RuntimeException("The time is greater than the maximum"); //S
            }
        } //T
        return result; //U
    } //V
}