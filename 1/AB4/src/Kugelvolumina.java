public class Kugelvolumina {
    public static double[] radien = new double[20];

    public static void main(String[] args) {

        for (int i = 0; i < radien.length; i++) {
            radien[i] = Math.random() * 10;

            System.out.printf("r=" + radien[i] + " == " + ((4.0/3.0) * Math.PI * Math.pow(radien[i], 3)) + " VE\n");
        }
    }
}
