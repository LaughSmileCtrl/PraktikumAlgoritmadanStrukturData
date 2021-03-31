package stack2_022;

class StackChar {
    private int ukuran;
    private char[] tumpukan;
    private int top;

    public StackChar(int s) {
        ukuran = s;
        tumpukan = new char[ukuran];
        top = -1;
    }

    public void push(char j) {
        tumpukan[++top] = j;
    }

    public char pop() {
        return tumpukan[top--];
    }

    public char peek() {
        return tumpukan[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == ukuran - 1);
    }

    public void baca() {
        int i = top;
        while (i >= 0) {
            System.out.println(tumpukan[i]);
            System.out.println(" ");
            i--;
        }
        System.out.println("  ");
    }
}

public class tugas22 {
    public static void main(String[] args) {
        // String input;
        StackChar tumpukan = new StackChar(10);
        System.out.println(" ");
        tumpukan.push('B');
        tumpukan.push('a');
        tumpukan.push('c');
        tumpukan.push('a');
        tumpukan.push(' ');
        tumpukan.push('B');
        tumpukan.push('u');
        tumpukan.push('k');
        tumpukan.push('u');

        tumpukan.baca();
    }
}