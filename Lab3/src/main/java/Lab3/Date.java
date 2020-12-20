package Lab3;
public class Date {
    private int day;
    private int month;
    private int year;
    
    public Date(int day, int month, int year){
        if(day>0 && day<=31 && month>0 && month<=12 && year>=0){
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
}
