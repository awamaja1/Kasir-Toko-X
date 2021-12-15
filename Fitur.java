

public class Fitur {

	private Produk produk = new Produk();
	
	private Additional fiturTambahan = new Additional();
	
	private double totalSemuaPmbyrn = 0;
	
	private double totalBayar = 0;
	
	public void tabelProduk() {
		String[][] indeks = produk.tabelProduk();
		
		System.out.println("+________________________________________________________________+");
		
		for (int i = 0; i < indeks.length; i++) {
			System.out.println("");
			for (int j = 0; j < 3; j++) {
				
				if (j == 2) {
					double hargaProduk = Integer.parseInt(indeks[i][j]);
					System.out.print(" ");
					fiturTambahan.kursRp(hargaProduk);
					System.out.print(" ");
				} else {
					System.out.print(" " + indeks[i][j] + " ");
				}
			}
		}
		System.out.println("\n+________________________________________________________________+");
				
	}
	
	
	public void jumlahBayar(int indeks, int jumlahBeli) {

		double hargaBayar = 0;
		
		while (indeks > 0 && indeks <= produk.tabelProduk().length) {
		
			produk.pencarianProduk(indeks);
			
			hargaBayar += produk.hargaProduk * jumlahBeli;
		
			produk.tmbhPenjualanBrng(indeks, jumlahBeli);
			
			indeks = 0;
		
		}
		
		totalBayar += hargaBayar;
		
		fiturTambahan.kursRp(hargaBayar);
		System.out.println("");
		
		
	/*	
	 * Argument -> int indeks, int jumlahProduk, String[][] listProduk
	 * 
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
	*/
		
	}
	
	public void kalkulasiTotal() {
		
		fiturTambahan.kursRp(totalBayar);
		System.out.println("");
		
		totalSemuaPmbyrn += totalBayar;
		
		totalBayar *= 0;
		
	}
	
	public void pembelianTerjadi() {
		
		produk.konfirmasiStok();
		System.out.println("Pesanan dibayarkan");
	}

	public void pembelianTdkTerjadi() {
		
		produk.pengembalianStok();
		System.out.println("Pesanan dibatalkan");
		
	}
	
	
	public void kmbliKeAwal() {
		produk.kmbliKeAwal();
		System.out.println("Kembali ke stok awal");
	}
	
	/*
	 * Buat sebuah method yang akan mengambil variabel totalSemuaPmbyrn dan diolah menjadi
	 * fitur ke-3
	 */

	public void tblPenjualanPerTrnsksi() {
		
	}
	
	
	/*
	 * Buat fitur ke-4 yang akan menghasilkan total penjualan per setiap produk
	 * dengan mengolah nilai yang ada di array 2 dimensi class Produk
	 */

	public void tblPenjualanPerPrdk() {
		
	}
	
}
