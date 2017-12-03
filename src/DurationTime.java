public class DurationTime {
    private Integer hours;
    private Integer minutes;
    private Integer seconds;

    private boolean twoParam = true;

//=======================to do (Exception)=============================

    public DurationTime(Integer min, Integer sec) {
        minutes = min;
        seconds = sec;
    }

    public DurationTime(Integer hour,Integer min, Integer sec) {
        hours = hour;
        minutes = min;
        seconds = sec;
    }

    public DurationTime() {
        hours = null;
        minutes = null;
        seconds = null;
    }

    public boolean correctTime() {
        if( minutes > 59 || seconds > 59) {
            return false;
        }
        if( minutes < 0 || seconds < 0) {
            return false;
        }
        if (!twoParam) {
            if ( hours < 0 || hours > 23){
                return false;
            }
        }
        return true;
    }

    public  void setHours(Integer hour) {
        hours = hour;
    }
    public void setMinutes(Integer min) {
        minutes = min;
    }
    public void setSeconds(Integer sec) {
        seconds = sec;
    }

    public void setTwoParam(Boolean isTwo) {
        twoParam = isTwo;
    }

    public Integer getHours() {
        return hours;
    }
    public Integer getMinutes() {
        return minutes;
    }
    public Integer getSeconds() {
        return seconds;
    }

    public String toString() {
        String min = minutes.toString();
        String sec = seconds.toString();
        if (minutes < 10)
            min = "0" + minutes;
        if (seconds < 10)
            sec = "0" + seconds;
        if (!twoParam) {
            String hour = hours.toString();
            if (hours < 10)
                hour = "0" + hours;
            return hour + ":" + min + ":" + sec;
        }
        return min + ":" + sec;


    }

}
