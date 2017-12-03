public class DurationTime {
    private Integer minutes;
    private Integer seconds;

//=======================to do (Exception)=============================

    public DurationTime(Integer min, Integer sec) {
        minutes = min;
        seconds = sec;
    }

    public DurationTime() {
        minutes = null;
        seconds = null;
    }

    public boolean correctTime(Integer time) {
        if(time >= 60 || time < 0) {
            return false;
        }
        return true;
    }

    public void setMinutes(Integer min) {

        minutes = min;
    }
    public void setSeconds(Integer sec) {
        seconds = sec;
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
        return min + ":" + sec;
    }

}
