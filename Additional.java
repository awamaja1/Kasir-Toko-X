import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Additional {

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
