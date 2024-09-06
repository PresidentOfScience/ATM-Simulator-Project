
public class MoneyStorage {
	private int nominal = 0;

	public int getNominal() {
		return nominal;
	}

	public void setNominal(int nominal) {
		this.nominal = nominal;
	}
	
	public void penarikan(int total) {
		nominal -= total;
	}
}
