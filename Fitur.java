import java.util.Scanner;

public class Fitur {
	
	private Additional fiturTambahan = new Additional();
	
	public Scanner inputScanner = new Scanner(System.in);

	private static Produk produk1 = new Produk("Susu UHT", 20000.00);

	private static Produk produk2 = new Produk("Mie Goreng", 2500.00);
	
	private static Produk produk3 = new Produk("Kopi Kapal Api 380g", 23000.00);

	private static Produk produk4 = new Produk("Chocolate Silver Queen", 18000.00);
	
	private static Produk produk5 = new Produk("Es Krim", 5000.00);

	private static Produk[] produks = new Produk[5];
	
	private double totalSemuaPmbyrn = 0;
	
	private double totalBayar = 0;
	
	private int jumlahBeli, produkKey;
	
	//private boolean[] produkTerjual = new boolean[produks.length];
	
	private int pembelianLebihDari1 = 0;
	
	//private  name = new ();
	
	private static void produks() {
		// TODO Auto-generated method stub
		produks[0] = produk1;
		produks[1] = produk2;
		produks[2] = produk3;
		produks[3] = produk4;
		produks[4] = produk5;
	}
	
	public void tabelProduk() {
		produks();
		
		System.out.println(" +___________________________________________________________+");
		
		for (int i = 0; i < produks.length; i++) {
			
			System.out.print("\n (" + String.valueOf(i+1) + ") " + produks[i].getNama() + " ");
			fiturTambahan.kursRp(produks[i].getHarga());		
		}
		
		System.out.println("\n +___________________________________________________________+");
				
	}
	
	public boolean termasukIndeks(int at) {
		produks();
		return 0 < at && at <= produks.length;
	}
	
	public boolean validasiPembelianBerulang() {
    produks();
		System.out.print("\n"
				+ "Silahkan Pilih Barang, Tekan Q untuk selesai: ");
		char jawaban = inputScanner.next().charAt(0);
		boolean pilihProduk = true;
		if (jawaban == 'Q' || jawaban == 'q') {
			pilihProduk = false;
		}else if (this.termasukIndeks(Character.getNumericValue(jawaban))) {
			this.pembelianProduk(Character.getNumericValue(jawaban));
			pembelianLebihDari1 += 1;
			pilihProduk = true;
		}
		
		return pilihProduk;
	}
	
	public void pembelianProduk(int produkKey) {
		produks();
		if (!this.termasukIndeks(produkKey)){
      do {
        System.out.print("\n"
					+ "Silahkan Pilih Barang: ");
			  produkKey = inputScanner.nextInt();
      } while (!this.termasukIndeks(produkKey));
      System.out.print("\n"
					+ "Masukkan jumlah barang: ");
			  jumlahBeli = inputScanner.nextInt();
		} else if (produks[produkKey-1].getCatatanStok() != 0) {
      do {
        System.out.print("\n"
					+ "Silahkan Pilih Barang: ");
			  produkKey = inputScanner.nextInt();
      } while (produks[produkKey-1].getCatatanStok() != 0);
      System.out.print("\n"
					+ "Masukkan jumlah barang: ");
			  jumlahBeli = inputScanner.nextInt();
    } else {
			System.out.print("\n"
					+ "Masukkan jumlah barang: ");
			jumlahBeli = inputScanner.nextInt();
		}
		System.out.print("\n"
				+ "Jumlah bayar: ");
		this.jumlahBayar(produkKey, jumlahBeli);
	}
	
  private void jumlahBayar(int indeks, int jumlahBeli) {
		produks();	
 		Produk produk;
		double hargaBayar = 0;
		while(indeks > 0 && indeks <= produks.length) {
			produk = produks[indeks-1];
			//produkTerjual[indeks-1] = produk.equals(produks[indeks-1]);
			produk.setCatatanStok(jumlahBeli);
			//produk.sumStokTerjual(jumlahBeli); --diaktifkan jika ingin menambahkan secara langsung stok produk yang terjual
			hargaBayar += produk.getHarga() * jumlahBeli;
			System.out.print(produk.getNama() + " ");
			fiturTambahan.kursRp(hargaBayar);
			System.out.println("");	
			indeks = 0;
	  }
		totalBayar += hargaBayar;
	}	
  	
  public void strukTagihan() {
  	produks();
  	char jawaban;
  	System.out.println("\n Total yang harus dibayarkan");
  	System.out.println("-------------------------------");
  	for (int i = 0; i < produks.length; i++) {
		  Produk produk = produks[i];
  		if (produk.getCatatanStok() != 0) {
  			System.out.print(" " + produk.getNama() + " " + produk.getCatatanStok() + " ");
  			fiturTambahan.kursRp(produk.getHarga() * produk.getCatatanStok());
  			System.out.println("");
			}
	  }
		this.kalkulasiTotal();
		System.out.print("Tekan K untuk membayar"
				+ "\n atau tekan T untuk membatalkan pesanan: ");
		jawaban = this.inputScanner.next().charAt(0);
		if (jawaban == 'K' || jawaban == 'k') {
			this.pembelianTerjadi();
		} else if (jawaban == 'T' || jawaban == 't') {
			this.pembelianTdkTerjadi();
		}
	}
  	
	private void kalkulasiTotal() {
		System.out.print("Total transaksi yang harus dibayarkan: ");
		fiturTambahan.kursRp(totalBayar);
		System.out.println("");
	}
	
	public void pembelianTerjadi() {
		produks();
		for (int i = 0; i < produks.length; i++) {
			Produk produk = produks[i];
			if (produk.getCatatanStok() != 0) {
				produk.sumStokTerjual(produk.getCatatanStok());
				produk.setCatatanStok(0);
			}
		}
		totalSemuaPmbyrn += totalBayar; // input semua total pembayaran tiap transaksi
		totalBayar *= 0;
		System.out.println("Pesanan dibayarkan");
	}

	public void pembelianTdkTerjadi() {
		produks();
		for (Produk produk: produks) {
			if(produk.getCatatanStok() != 0){
				//produk.minStokTerjual(produk.getCatatanStok()); --Diaktifkan jika produks[indeks ke-berapa].sumStokTerjual di method jumlah bayar diaktifkan
				produk.setCatatanStok(0);
			}
		}
		totalBayar *= 0;
		System.out.println("Pesanan dibatalkan");
	}
	
	public void tabelPenjualan() {
		produks();
		System.out.println("Jumlah barang yang terjual hari ini");
		System.out.println("+________________________________________________________________+");
		for (Produk produk : produks) {
			System.out.print("| " + produk.getNama() + " | ");
			fiturTambahan.kursRp(produk.getHarga());
			System.out.print(" | " + produk.getStokTerjual() + " | ");
			fiturTambahan.kursRp(produk.getPendapatanStok());
			System.out.println("");
			System.out.println("+________________________________________________________________+");
		}
		System.out.println("+________________________________________________________________+");
	}
	
	public void totalPenjualan() {
		System.out.println("_________________________________________________________________________");
		System.out.print("| total pendapatan dari semua stok produk: ");
		fiturTambahan.kursRp(totalSemuaPmbyrn);
		System.out.println(" |");
		System.out.println("_________________________________________________________________________");
	}
}
