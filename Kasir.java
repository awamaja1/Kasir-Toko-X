//import java.text.DecimalFormat;
//import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class Kasir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fitur fitur = new Fitur();
		Scanner inputScanner = new Scanner(System.in);
		boolean login = true;
		// String[][] listProduk = produkListing();
		
		while (login) {
			
			login = false;
			
			char key;
			
			System.out.println("Selamat datang di aplikasi kasir toko kami, silahkan tekan tombol"
					+ "\n +_______________________________________________________________+"
					+ "\n |                                                               |"
					+ "\n | (1) <= cek harga barang                                       |"
					+ "\n | (2) <= beli barang                                            |"
					+ "\n | (3) <= pendapatan hari ini                                    |"
					+ "\n | (4) <= jumlah barang yang terjual hari ini                    |"
					+ "\n | (5) <= logout                                                 |"
					+ "\n +_______________________________________________________________+");
			System.out.print("Tombol: ");
			key = inputScanner.next().charAt(0);
			
			switch (key) {
			
				case '1':
					
					fitur.tabelProduk();
					System.out.print("tekan tombol apa saja untuk masuk ke menu utama"
							+ " atau tombol 2 untuk masuk ke menu pembelian: ");
					char reference_key = inputScanner.next().charAt(0);
					if (reference_key == '2') {
						key = '2';
					} else {
						login = true;
						break;
					}
					
				case '2':
					boolean pilih_produk = true;
					
					do {
						int jumlah_beli, produk_key;
						//double total_bayar = 0.00;
						System.out.print("Silahkan Pilih Barang: ");
						produk_key = inputScanner.nextInt();
						System.out.print("Masukkan jumlah barang: ");
						jumlah_beli = inputScanner.nextInt();
						
						// total_bayar += jumlahBayar(produk_key, jumlah_beli, listProduk);
						
						System.out.print("jumlah bayar: ");
						fitur.jumlahBayar(produk_key, jumlah_beli);
						
						// kursRp(total_bayar);
						
						System.out.print("Tambah produk? (Y/T): ");
						char jawaban = inputScanner.next().charAt(0);
						if (jawaban == 'Y' || jawaban == 'y') {
							pilih_produk = true;
						} else if (jawaban == 'T' || jawaban == 't') {
							System.out.print("total yang harus dibayarkan: ");
							//kursRp(total_bayar);
							fitur.kalkulasiTotal();
							System.out.print("Konfirmasi pembelian (Y/T): ");
							jawaban = inputScanner.next().charAt(0);
							if (jawaban == 'Y' || jawaban == 'y') {
								fitur.pembelianTerjadi();
							} else if (jawaban == 'T' || jawaban == 't') {
								fitur.pembelianTdkTerjadi();
							}
							pilih_produk = false;
							//total_bayar *= 0;
						}
					} while (pilih_produk);
					login = true;
					break;
					
				case '4':
					fitur.tabelPenjualan();
					
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
	/*	public static void tabelProduk(String[][] indeks) {
			System.out.println("+________________________________________________________________+");
			
			for (int i = 0; i < indeks.length; i++) {
				System.out.println("");
				for (int j = 0; j < 3; j++) {
					
					if (j == 2) {
						double hargaProduk = Integer.parseInt(indeks[i][j]);
						System.out.print(" ");
						kursRp(hargaProduk);
						System.out.print(" ");
					} else {
						System.out.print(" " + indeks[i][j] + " ");
					}
				}
			}
			System.out.println("\n+________________________________________________________________+");
					
		}
	*/
	
	///Perhitungan jumlah yang harus dibayar
	/*	public static int jumlahBayar(int indeks, int jumlahProduk, String[][] listProduk) {
				int searchIndeks = indeks, jumlahAwal = 0, hargaTotal = 0;
				
				while (searchIndeks > 0 && searchIndeks <= listProduk.length) {
					hargaTotal += Integer.parseInt(listProduk[searchIndeks-1][2]) * jumlahProduk;
					
					jumlahAwal += Integer.parseInt(listProduk[searchIndeks-1][3]);
					System.out.println(jumlahAwal);
					listProduk[searchIndeks-1][3] = (String.valueOf(jumlahAwal + jumlahProduk));
					System.out.println(listProduk[searchIndeks-1][3]);
					searchIndeks = 0;
				}
				return hargaTotal;
			}
	*/
	
	///Perubahan ke mata uang rupiah
	/*	public static void kursRp(Double angka) {
			DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
			DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
			
			formatRp.setCurrencySymbol("Rp. ");
			formatRp.setMonetaryGroupingSeparator('.');
			formatRp.setMonetaryDecimalSeparator(',');
			
			kursIndonesia.setDecimalFormatSymbols(formatRp);
			System.out.printf("%s ", kursIndonesia.format(angka));
		}
	*/

	///berisi list produk yang akan ditampilkan & diolah
	/*	public static String[][] produkListing() {
		
			String[][] indeks_produk = {
					{"(1)", "Susu UHT", "20000", "0"},
					{"(2)", "Mie Goreng", "2500", "0"},
					{"(3)", "Kopi Kapal Api 380g", "23000", "0"},
					{"(4)", "Chocolate Silver Queen", "18000", "0"},
					{"(5)", "Es Krim", "5000", "0"}
			};
			
			return indeks_produk;
		}
	*/
}