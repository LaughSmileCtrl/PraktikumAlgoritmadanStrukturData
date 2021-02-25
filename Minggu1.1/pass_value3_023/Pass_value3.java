package pass_value3_023;

class Baloon {
    private String color;

    public Baloon (){}

    public Baloon(String c){
        this.color=c;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color=color;
    }
}

public class Pass_value3 {
    public static void main(String[] args) {
        Baloon red = new Baloon("Red");
        Baloon blue = new Baloon("Blue");

        swap(red, blue);
        System.out.println("red color=" + red.getColor());
        System.out.println("blue color=" + blue.getColor());

        foo(blue);
        System.out.println("blue color=" + red.getColor());

    }

    private static void foo(Baloon baloon) {
        baloon.setColor("Red");
        baloon = new Baloon("Green");
        baloon.setColor("Blue");
    }

    public static void swap(Object ol, Object o2) {
        Object temp = ol;
        ol = o2;
        o2 = temp;
    }
}