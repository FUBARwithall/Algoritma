import java.util.ArrayList;
import java.util.Random;

public class UAS {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> stok = new ArrayList<>();
        stok.add(2000); // Pertalite
        stok.add(2500); // Pertamax
        stok.add(1700); // Pertamax Turbo
        stok.add(2800); // Pertadex

        ArrayList<ArrayList<Integer>> penjualan = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            penjualan.add(new ArrayList<>());
        }

        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 4; j++) {
                int penjualanHariIni = random.nextInt(501);
                penjualan.get(j).add(penjualanHariIni);
                stok.set(j, stok.get(j) - penjualanHariIni);
            }
            Thread.sleep(3000);
        }

        for (int j = 0; j < 4; j++) {
            System.out.println("Jenis BBM " + (j + 1) + ":");
            System.out.println("Total Penjualan: " + getTotal(penjualan.get(j)) + " kg");
            System.out.println("Sisa Stok: " + stok.get(j) + " kg");
            System.out.println();
        }
    }

    private static int getTotal(ArrayList<Integer> list) {
        int total = 0;
        for (int value : list) {
            total += value;
        }
        return total;
    }
}
