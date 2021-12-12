import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class Kasir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean login = true, pilih_produk = true;
		Scanner inputScanner = new Scanner(System.in);
		char key;
		int jumlah_beli, produk_key;
		double total_bayar = 0.00;
		String[][] listProduk = produkListing();
		
		while (login) {
			
			login = false;
			
			System.out.println("Selamat datang di aplikasi kasir toko kami, silahkan tekan tombol"
					+ "\n +_______________________________________________________________+"
					+ "\n |                                                               |"
					+ "\n | (1) <= cek harga barang                                       |"
					+ "\n | (2) <= beli barang                                            |"
					+ "\n | (3) <= pendapatan hari ini                                    |"
					+ "\n | (4) <= jumlah barang yang terjual hari ini                    |"
					+ "\n | (5) <= logout                                                 |"
					+ "\n +_______________________________________________________________+");
			key = inputScanner.next().charAt(0);
			
			switch (key) {
			
				case '1':
					tabelProduk(listProduk);
					char reference_key = inputScanner.next().charAt(0);
					if (reference_key == '2') {
						key = '2';
					}
					login = true;
					
				case '2':
					do {
						System.out.print("Silahkan Pilih Barang: ");
						produk_key = inputScanner.nextInt();
						System.out.println("Masukkan jumlah barang: ");
						jumlah_beli = inputScanner.nextInt();
						total_bayar += jumlahBayar(produk_key, jumlah_beli, listProduk);
						System.out.print("jumlah bayar: ");
						kursRp(total_bayar);
						System.out.println("Tambah produk? (Y/T) = ");
						char jawaban = inputScanner.next().charAt(0);
						if (jawaban == 'Y' || jawaban == 'y') {
							pilih_produk = true;
						} else if (jawaban == 'T' || jawaban == 't') {
							System.out.print("total yang harus dibayar: ");
							kursRp(total_bayar);
							System.out.print("Konfirmasi pembelian (Y/T): ");
							jawaban = inputScanner.next().charAt(0);
							if (jawaban == 'Y' || jawaban == 'y') {
								System.out.println("Pesanan dibayarkan");
							} else if (jawaban == 'T' || jawaban == 't') {
								System.out.println("Pesanan dibatalkan");
							}
							pilih_produk = false;
							total_bayar *= 0;
						}
					} while (pilih_produk);
					login = true;
					break;
					
				case '5':
					System.out.println("Terima kasih karena sudah memakai aplikasi kasir toko kami, sampai jumpa!");
					System.exit(0);
				default:
					try {
						System.out.println("Masukkan ulang nilai indeks");
						key = inputScanner.next().charAt(0);
						if (key == '1' | key == '2' | key == '3' | key == '4' | key == '5') {
							login = true;
						} else {
							continue;
						}
					} catch (IllegalArgumentException e) {
						// TODO: handle exception
						throw new IllegalArgumentException("tidak ada pilihan menurut indeks " + key + "yang valid");
					}
			}
		}
		
		inputScanner.close();
	}


	///Penampil list produk
	public static void tabelProduk(String[][] indeks) {
		System.out.println("+________________________________________________________________+");
		
		for (int i = 0; i < indeks.length; i++) {
			System.out.println("");
			for (int j = 0; j < 3; j++) {
				
				System.out.print(" " + indeks[i][j] + " ");
			}
		}
		System.out.println("\n+________________________________________________________________+");
		
		
		/* 
			Hanya sebagai referensi/cara lain
			
			System.out.println(""
					+ "\n +________________________________________________________________+"
					+ "\n |                                                                |"
					+ "\n | 1. Susu UHT Rp. 20.000                                         |"
					+ "\n | 2. Mie Goreng Rp. 2.500                                        |"
					+ "\n | 3. Kopi Kapal Api 380g Rp. 23.000                              |"
					+ "\n | 4. Chocolate Silver Queen Rp. 18.000                           |"
					+ "\n | 5. Es Krim Rp. 5.000                                           |"
					+ "\n +________________________________________________________________+");
		*/
		
			/*		
			 		System.out.println("\n tekan x untuk kembali ke menu utama");
					key = inputScanner.next().charAt(0);
					if (key == 'x') {
						login = true;
					}
			*/				
	}
	
	///Perhitungan jumlah yang harus dibayar
	public static int jumlahBayar(int indeks, int jumlahProduk, String[][] listProduk) {
			int searchIndeks = indeks, jumlahAwal = 0, hargaTotal = 0;
			
			while (searchIndeks > 0 && searchIndeks <= listProduk.length) {
				hargaTotal += Integer.parseInt(listProduk[searchIndeks-1][3]) * jumlahProduk;
				jumlahAwal += Integer.parseInt(listProduk[searchIndeks-1][4]);
				System.out.println(jumlahAwal);
				listProduk[searchIndeks-1][4] = (String.valueOf(jumlahAwal + jumlahProduk));
				System.out.println(listProduk[searchIndeks-1][4]);
				searchIndeks = 0;
			}
			return hargaTotal;
		}
	
	///Perubahan ke mata uang rupiah
	public static void kursRp(Double angka) {
		DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
		
		formatRp.setCurrencySymbol("Rp. ");
		formatRp.setMonetaryGroupingSeparator('.');
		formatRp.setMonetaryDecimalSeparator(',');
		
		kursIndonesia.setDecimalFormatSymbols(formatRp);
		System.out.printf("%s %n", kursIndonesia.format(angka));
	}

	///berisi list produk yang akan ditampilkan & diolah
	public static String[][] produkListing() {
	
		String[][] indeks_produk;
		indeks_produk = new String[][] {
				{"(1)", "Susu UHT", "Rp. 20.000", "20000", "0"},
				{"(2)", "Mie Goreng", "Rp. 2.500", "2500", "0"},
				{"(3)", "Kopi Kapal Api 380g", "Rp. 23.000", "23000", "0"},
				{"(4)", "Chocolate Silver Queen", "Rp. 18.000", "18000", "0"},
				{"(5)", "Es Krim", "Rp. 5.000", "5000", "0"}
		};
		
		return indeks_produk;
	}

}
