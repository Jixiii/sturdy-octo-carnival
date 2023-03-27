package homework2;

/**
 * @author IDK You Yet
 */
public class Homework21 {
}

interface MyTimeInterface {
    void incrementMinute();

    void incrementHour();

    void incrementSecond();
}

class MyTime implements MyTimeInterface {
    int hour;
    int minute;
    int second;

    @Override
    public void incrementHour() {
        if (isValid()) {
            hour = hour == 23 ? 0 : hour + 1;
        }
    }

    @Override
    public void incrementMinute() {
        if (isValid()) {
            if (minute == 59) {
                incrementHour();
                minute = 0;
            } else {
                minute++;
            }
        }
    }

    @Override
    public void incrementSecond() {
        if (isValid()) {
            if (second == 59) {
                incrementMinute();
                second = 0;
            } else {
                second++;
            }
        }
    }

    public MyTime() {
    }

    public MyTime(int hour) {
        this.hour = hour;
    }

    public MyTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public MyTime(MyTime copy) {
        this.hour = copy.hour;
        this.minute = copy.minute;
        this.second = copy.second;
    }

    public String toUniversalString() {
        String universalString = "";
        if (isValid()) {
            universalString = toTimeString(hour, minute, second);
        }
        return universalString;
    }

    @Override
    public String toString() {
        String string = "";
        boolean am = hour < 12;
        if (isValid()) {
            string = switch (hour) {
                case 0, 12 -> toTimeString(12, minute, second);
                default -> toTimeString(hour >= 13 ? hour - 12 : hour, minute, second);
            };
            string += am ? " AM" : " PM";
        }
        return string;
    }

    public static String toTimeString(int hour, int minute, int second) {
        String string = "";
        string += hour < 10 ? "0" + hour : hour;
        string += ":";
        string += minute < 10 ? "0" + minute : minute;
        string += ":";
        string += second < 10 ? "0" + second : second;
        return string;
    }

    private boolean isValid() {
        boolean valid = true;
        if (hour < 0 || hour > 24) {
            System.out.println("hour must be 0-23");
            valid = false;
        }
        if (minute < 0 || minute > 59) {
            System.out.println("minute must be 0-59");
            valid = false;
        }
        if (second < 0 || second > 59) {
            System.out.println("second must be 0-59");
            valid = false;
        }
        return valid;
    }


}

class TestTime {
    public static void main(String[] args) {
        MyTime t1 = new MyTime();
        MyTime t2 = new MyTime(2);
        MyTime t3 = new MyTime(21, 34);
        MyTime t4 = new MyTime(12, 25, 42);
        MyTime t5 = new MyTime(t4);
        System.out.println("Constructed with:");
        System.out.println("t1: all arguments defaulted");
        System.out.printf("    %s\n", t1.toUniversalString());
        System.out.printf("    %s\n", t1);

        System.out.println("t2: hour specified; minute and second defaulted");
        System.out.printf("    %s\n", t2.toUniversalString());
        System.out.printf("    %s\n", t2);

        System.out.println("t3: hour and minute specified; second defaulted");
        System.out.printf("    %s\n", t3.toUniversalString());
        System.out.printf("    %s\n", t3);

        System.out.println("t4: hour ,minute and second specified");
        System.out.printf("    %s\n", t4.toUniversalString());
        System.out.printf("    %s\n", t4);

        System.out.println("t5: MyTime object t4 specified");
        System.out.printf("    %s\n", t5.toUniversalString());
        System.out.printf("    %s\n", t5);

//when initialize t6 with invalid values,please output error information
        MyTime t6 = new MyTime(15, 74, 99);
        System.out.println("t6: invalid values");
        System.out.printf("%s\n", t6.toUniversalString());

        MyTime test01 = new MyTime();
        System.out.print(test01.toUniversalString() + " incrementSecond: ");
        test01.incrementSecond();
        System.out.println(test01.toUniversalString());

        MyTime test02 = new MyTime(0, 0, 59);
        System.out.print(test02.toUniversalString() + " incrementSecond: ");
        test02.incrementSecond();
        System.out.println(test02.toUniversalString());

        MyTime test07 = new MyTime(0, 59, 59);
        System.out.print(test07.toUniversalString() + " incrementSecond: ");
        test07.incrementSecond();
        System.out.println(test07.toUniversalString());

        MyTime test08 = new MyTime(23, 59, 59);
        System.out.print(test08.toUniversalString() + " incrementSecond: ");
        test08.incrementSecond();
        System.out.println(test08.toUniversalString());

        System.out.println();
        MyTime test03 = new MyTime();
        System.out.print(test03.toUniversalString() + " incrementMinute: ");
        test03.incrementMinute();
        System.out.println(test03.toUniversalString());

        MyTime test04 = new MyTime(0, 59, 0);
        System.out.print(test04.toUniversalString() + " incrementMinute: ");
        test04.incrementMinute();
        System.out.println(test04.toUniversalString());

        MyTime test09 = new MyTime(23, 59, 0);
        System.out.print(test09.toUniversalString() + " incrementMinute: ");
        test09.incrementMinute();
        System.out.println(test09.toUniversalString());

        System.out.println();
        MyTime test05 = new MyTime(0, 0, 0);
        System.out.print(test05.toUniversalString() + " incrementHour: ");
        test05.incrementHour();
        System.out.println(test05.toUniversalString());

        MyTime test06 = new MyTime(23, 0, 0);
        System.out.print(test06.toUniversalString() + " incrementHour: ");
        test06.incrementHour();
        System.out.println(test06.toUniversalString());

        System.out.println();
        System.out.println(new MyTime(-14, 5, 50));
        System.out.println(new MyTime(-14, 5, -50));
        System.out.println(new MyTime(-14, -5, 50));
        System.out.println(new MyTime(30, 0, 0));
    }
}