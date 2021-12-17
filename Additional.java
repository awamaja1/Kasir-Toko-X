import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Additional {

	private StringBuilder stringBuilder = new StringBuilder();
    	private Random random = new Random();
    

    	public String amblKdAck() {
    		char[] karakter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
    		String hasil;
    	
		for (int lenght = 0; lenght < 7; lenght++) {
		    Character character = karakter[random.nextInt(karakter.length)];
		    stringBuilder.append(character);
		}

		hasil = stringBuilder.toString();
		stringBuilder.delete(0, 7);

		return hasil;
	}
	
	
	public void kursRp(Double angka) {
		DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
		
		formatRp.setCurrencySymbol("Rp. ");
		formatRp.setMonetaryGroupingSeparator('.');
		formatRp.setMonetaryDecimalSeparator(',');
		
		kursIndonesia.setDecimalFormatSymbols(formatRp);
		System.out.printf("%s", kursIndonesia.format(angka));
	}
	
}
