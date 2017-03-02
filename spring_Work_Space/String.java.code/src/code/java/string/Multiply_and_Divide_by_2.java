package code.java.string;

public class Multiply_and_Divide_by_2 {

    public static void main (String[] args) {

        int num = 12;

        int mul = multiplayByTwo (num);
        int dv = devideByTwo (num);

        System.out.println ("Result of " + num + "*2 = " + mul);
        System.out.println ("Result of " + num + "/2 = " + dv);
    }

    /**
     * This program multiply a number by 2 without using * operator.
     * 
     * @param num
     *            : Integer
     * @return Integer
     */
    public static int multiplayByTwo (int num) {
        return (num << 1);
    }

    /**
     * This program divide a number by 2 without using / operator.
     * 
     * @param num
     *            : Integer
     * @return Integer
     */
    public static int devideByTwo (int num) {
        return (num >> 1);
    }

}
