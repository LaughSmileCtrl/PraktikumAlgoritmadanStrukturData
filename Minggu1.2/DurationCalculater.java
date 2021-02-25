import java.util.Scanner;

class Time {
    
    int hour;
    
    int minute;
    
    int totalMinute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
        this.totalMinute = inMinute(hour);
    }

    private int inMinute(int hour) {
        return (hour * 60) + minute;
    }
}

public class DurationCalculater {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan jam pertama : ");
        int tmpHour = scan.nextInt();
        System.out.print("Masukkan menit pertama : ");
        int tmpMinute = scan.nextInt();
        Time time1 = new Time(tmpHour, tmpMinute);

        System.out.print("Masukkan jam kedua : ");
        tmpHour = scan.nextInt();
        System.out.print("Masukkan menit kedua : ");
        tmpMinute = scan.nextInt();
        Time time2 = new Time(tmpHour, tmpMinute);

        tmpHour = Math.abs((time2.totalMinute - time1.totalMinute) / 60);
        tmpMinute = Math.abs((time2.totalMinute - time1.totalMinute) % 60);

        System.out.printf("\nSelisih jam %02d.%02d dengan %02d.%02d adalah %02d.%02d\n", time1.hour, time1.minute, time2.hour, time2.minute, tmpHour, tmpMinute);
        System.out.printf("Atau %02d jam %02d menit\n", tmpHour, tmpMinute);
        scan.close();
    }
}
