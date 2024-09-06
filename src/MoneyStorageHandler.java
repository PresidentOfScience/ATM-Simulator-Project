
public class MoneyStorageHandler implements Runnable {
	private MoneyStorage ms;
	ATM a1 = new ATM(true, "ATM 1");
	ATM a2 = new ATM(true, "ATM 2");
	ATM a3 = new ATM(true, "ATM 3");
	ATM a4 = new ATM(true, "ATM 4");
	
	public MoneyStorageHandler(MoneyStorage ms) {
		super();
		this.ms = ms;
	}
	
	@Override
	public void run() {
		do {
			tarikTunai(100000);
			try {
				Thread.sleep(1500);
			}
			catch (InterruptedException e) {
				System.out.println("Transaksi gagal!");
			}
		} while(ms.getNominal() > 0);
	}

	private synchronized void tarikTunai(int totalPenarikan) {
		if (ms.getNominal() >= totalPenarikan) {
			System.out.println("[?] " + Thread.currentThread().getName() + " sedang melakukan penarikan Rp" + totalPenarikan);
			ms.penarikan(totalPenarikan);
			System.out.println("[V] " + Thread.currentThread().getName() + " selesai melakukan penarikan sejumlah Rp" + totalPenarikan);
			System.out.println();
			
			if(Thread.currentThread().getName().equals("ATM 1")) {
				a1.setLogTransaksi(100000);
				a1.setTotal(a1.getTotal() + 100000);
			}
			else if(Thread.currentThread().getName().equals("ATM 2")) {
				a2.setLogTransaksi(100000);
				a2.setTotal(a2.getTotal() + 100000);
			}
			else if(Thread.currentThread().getName().equals("ATM 3")) {
				a3.setLogTransaksi(100000);
				a3.setTotal(a3.getTotal() + 100000);
			}
			else if(Thread.currentThread().getName().equals("ATM 4")) {
				a4.setLogTransaksi(100000);
				a4.setTotal(a4.getTotal() + 100000);
			}
		}
		else {
			System.out.println("[!] Uang tidak tersedia lagi untuk " + Thread.currentThread().getName());
		}
	}
}
