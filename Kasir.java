
public class Kasir {

		private Fitur fitur = new Fitur();
	
		public void main() {
			// TODO Auto-generated method stub
			boolean login = true;
      char key = '*';
			
			while (login) {
				login = false;
				Boolean dariCase1 = false;
				
        if (!(Character.isDigit(key))){
          	System.out.println("\n"
						+ "Selamat datang di aplikasi kasir toko Hahay, silahkan tekan tombol"
						+ "\n +_______________________________________________________________+"
						+ "\n |                                                               |"
						+ "\n | (1) <= cek harga barang                                       |"
						+ "\n | (2) <= beli barang                                            |"
						+ "\n | (3) <= pendapatan hari ini                                    |"
						+ "\n | (4) <= jumlah barang yang terjual hari ini                    |"
						+ "\n | (5) <= logout                                                 |"
						+ "\n +_______________________________________________________________+");
			  	System.out.print("\n"
				  		+ "Tombol: ");
				  key = fitur.inputScanner.next().charAt(0);
        }
				
				switch (key) {
					//
					case '1':
						
						fitur.tabelProduk();
						System.out.print("\n"
								+ "tekan tombol apa saja untuk masuk ke menu utama"
								+ "\n atau tombol 2 untuk masuk ke menu pembelian: ");
						char reference_key = fitur.inputScanner.next().charAt(0);
						if (reference_key == '2') {
							key = '2';
							dariCase1 = true;
						} else {
							login = true;
              key = '*';
              break;
						}
					//	
					case '2':
						char jawaban;
						boolean pilih_produk = false;
						if (!dariCase1) {
							fitur.tabelProduk();
						}
						System.out.print("\n"
								+ "Silahkan Pilih Barang: ");
						fitur.pembelianProduk(fitur.inputScanner.nextInt());
						pilih_produk = fitur.validasiPembelianBerulang();
						while (pilih_produk) {
							pilih_produk = fitur.validasiPembelianBerulang();
						}
						fitur.strukTagihan();
						login = true;
            key = '*';
						break;
					//	
					case '3':
						fitur.totalPenjualan();
						System.out.print("\n"
								+ "Ingin kembali ke menu utama"
								+ "\n atau keluar dari program? (Y/T): ");
						jawaban = fitur.inputScanner.next().charAt(0);
						if (jawaban == 'Y' || jawaban == 'y') {
							login = true;
              key = '*';
							break;
						} else if (jawaban == 'T' || jawaban == 't') {
							System.out.println("\nTerima kasih karena sudah memakai aplikasi kasir toko kami, sampai jumpa!");
							break;
						}
					//	
					case '4':
						fitur.tabelPenjualan();
						System.out.print("Ingin kembali ke menu utama"
								+ "\n atau keluar dari program? (Y/T): ");
						jawaban = fitur.inputScanner.next().charAt(0);
						if (jawaban == 'Y' || jawaban == 'y') {
							login = true;
              key = '*';
							break;
						} else if (jawaban == 'T' || jawaban == 't') {
						}
					//
					case '5':
						System.out.println("Terima kasih karena sudah memakai aplikasi kasir toko kami, sampai jumpa!");
						break;
					default:
						do {
							System.out.print("\n"
									+ "Tombol: ");
						  key = fitur.inputScanner.next().charAt(0);
						} while(!(0 < Character.getNumericValue(key) && Character.getNumericValue(key) <= 5));
            if(Character.getNumericValue(key) == 5) {
              System.out.println("Terima kasih karena sudah memakai aplikasi kasir toko kami, sampai jumpa!");
						  break;
            } else {
              char draftKey = key;
              login = true;
              key = draftKey;
            }
				}
			}
		}
}
