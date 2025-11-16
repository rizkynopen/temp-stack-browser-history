package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static Stack<String> history = new Stack<>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("=== Browser History Menu ===");
            System.out.println("1. Browse (Kunjungi Website Baru)");
            System.out.println("2. View History");
            System.out.println("3. Back (Kembali)");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    browse();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    back();
                    break;
                case 4:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 4);
    }

    public static void browse() {
        System.out.print("Masukkan URL website: ");
        String url = input.next();
        history.push(url);
        System.out.println("Website '" + url + "' telah ditambahkan ke history.");
    }

    public static void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
            return;
        }

        System.out.println("--- Browser History (paling baru di atas) ---");

        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
        System.out.println("---------------------------------------------");
    }

    public static void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk kembali.");
            return;
        }

        String removed = history.pop();
        System.out.println("Kembali dari website: " + removed);

        if (!history.isEmpty()) {
            System.out.println("Sekarang berada di: " + history.peek());
        } else {
            System.out.println("History kosong, tidak ada website sebelumnya.");
        }
    }
}