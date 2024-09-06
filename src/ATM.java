import java.util.ArrayList;

public class ATM {
	private boolean kondisi;
	private String nama;
	private int total = 0;
	private ArrayList<Integer> logTransaksi = new ArrayList<Integer>();
	
	public ATM(boolean kondisi, String nama) {
		super();
		this.kondisi = kondisi;
		this.nama = nama;
	}

	public boolean isKondisi() {
		return kondisi;
	}

	public void setKondisi(boolean kondisi) {
		this.kondisi = kondisi;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ArrayList<Integer> getLogTransaksi() {
		return logTransaksi;
	}

	public void setLogTransaksi(int total) {
		logTransaksi.add(total);
	}
		
}
