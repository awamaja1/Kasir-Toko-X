
public class Produk {

	private String nama;
	private double harga;
	private int stokTerjual;
	private int pnjlStokPerTrnsksi;
	
	public Produk(String nama, double harga) {
		super();
		this.nama = nama;
		this.harga = harga;
		this.stokTerjual = 0;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public double getHarga() {
		return harga;
	}

	public void setHarga(double harga) {
		this.harga = harga;
	}

	public int getStokTerjual() {
		return stokTerjual;
	}

	public void setStokTerjual(int stokTerjual) {
		this.stokTerjual = stokTerjual;
	}
	
	public void sumStokTerjual(int tambahTerjual) {
		this.stokTerjual += tambahTerjual;
	}
	
	public void minStokTerjual(int stokTerjual) {
		this.stokTerjual -= stokTerjual;
	}
	
	public void setCatatanStok(int catatanStok) {	
		this.pnjlStokPerTrnsksi = catatanStok;
	}
	
	public int getCatatanStok() {
		return this.pnjlStokPerTrnsksi;
	}
	
	public double getPendapatanStok() {
		return this.harga * this.stokTerjual;
	}
}
