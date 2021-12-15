
public class Produk {

	private static String[][] mProduk = {
			{"(1)", "Susu UHT", "20000", "0"},
			{"(2)", "Mie Goreng", "2500", "0"},
			{"(3)", "Kopi Kapal Api 380g", "23000", "0"},
			{"(4)", "Chocolate Silver Queen", "18000", "0"},
			{"(5)", "Es Krim", "5000", "0"}
	};
	
	public String[][] listMnplt = mProduk;
	private String[][] backupList = mProduk;
	
	String namaProduk;
	double hargaProduk;
	int stokAwal;
	
	public String[][] tabelProduk() {
		return listMnplt;
	}
	
	public void pencarianProduk(int indeks) {
		
		if (indeks > 0 && indeks <= listMnplt.length) {
			namaProduk = listMnplt[indeks-1][1];
			hargaProduk = Double.parseDouble(listMnplt[indeks-1][2]);
			stokAwal = Integer.parseInt(listMnplt[indeks-1][3]);
		}
		
	}
	
	public void tmbhPenjualanBrng(int indeks, int stokTerjual) {
		
		listMnplt[indeks-1][3] = String.valueOf(stokAwal + stokTerjual);
		
	}
	
	public void pengembalianStok() {
		listMnplt = backupList;
	}
	
	public void konfirmasiStok() {
		backupList = listMnplt;
	}
	
	public void kmbliKeAwal() {
		listMnplt = mProduk;
	}
}
