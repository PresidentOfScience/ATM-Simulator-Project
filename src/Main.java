import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		MoneyStorage ms = new MoneyStorage();
		MoneyStorageHandler msh = new MoneyStorageHandler(ms);
		
		int choice;
		
		do {
			System.out.println("==================================================");
			System.out.println("|| Selamat datang di Simulator ATM Bank Fentira ||");
			System.out.println("==================================================");
			System.out.println("Pilih salah satu tindakan berikut:");
			System.out.println("1. Masukkan uang ke storage ATM");
			System.out.println("2. Pantau penarikan setiap mesin ATM");
			System.out.println("3. Kosongkan uang dari storage ATM");
			System.out.println("4. Tampilkan log transaksi setiap mesin ATM");
			System.out.println("5. Hapus log transaksi semua mesin ATM");
			System.out.println("6. Keluar dari program simulasi");
			System.out.print(">> ");
			
			choice = scan.nextInt();
			System.out.println();

			if(choice == 1) {
				int total;
				
				do {
					System.out.print("Masukkan jumlah uang ke mesin ATM: ");
					total = scan.nextInt();
					
					if(total % 100000 != 0) {
						System.out.println("Masukkan nominal pecahan Rp100.000,- saja. Coba lagi.");
						System.out.println();
					}
				} while(total % 100000 != 0);
				
				ms.setNominal(ms.getNominal() + total);
				System.out.println("Sejumlah uang dengan nominal Rp" + ms.getNominal() + ",- siap ditransaksi oleh nasabah.");
				System.out.println("Mesin siap digunakan.");
				System.out.println();
			}
			else if(choice == 2) {
				Thread atm1 = new Thread(msh);
				Thread atm2 = new Thread(msh);
				Thread atm3 = new Thread(msh);
				Thread atm4 = new Thread(msh);
				
				atm1.setName("ATM 1");
				atm2.setName("ATM 2");
				atm3.setName("ATM 3");
				atm4.setName("ATM 4");

				if(msh.a1.isKondisi() == true) {
					atm1.start();
				}
				
				if(msh.a2.isKondisi() == true) {
					atm2.start();
				}
				
				if(msh.a3.isKondisi() == true) {
					atm3.start();
				}		
				
				if(msh.a4.isKondisi() == true) {
					atm4.start();
				}
				
				try {
					atm1.join();
				}
				catch (InterruptedException e) {
					System.out.println("[X] Mesin ATM 1 mengalami kegagalan transaksi.");
				}
				
				try {
					atm2.join();
				}
				catch (InterruptedException e) {
					System.out.println("[X] Mesin ATM 2 mengalami kegagalan transaksi.");
				}
				
				try {
					atm3.join();
				}
				catch (InterruptedException e) {
					System.out.println("[X] Mesin ATM 3 mengalami kegagalan transaksi.");
				}
				
				try {
					atm4.join();
				}
				catch (InterruptedException e) {
					System.out.println("[X] Mesin ATM 4 mengalami kegagalan transaksi.");
				}
			}
			else if(choice == 3) {
				if(ms.getNominal() == 0) {
					System.out.println("Mesin sudah kosong.");
					System.out.println("Saat ini mesin masih belum bisa dipakai sampai sejumlah uang dimasukkan.");
				}
				else {
					ms.setNominal(0);
					System.out.println("Mesin berhasil dikosongkan.");
					System.out.println("Nasabah belum bisa melakukan penarikan sampai uang tersedia di dalam mesin.");
				}
				System.out.println();
			}
			else if(choice == 4) {
				System.out.println("Log transaksi ATM 1:");
				if(msh.a1.getLogTransaksi().isEmpty()) {
					System.out.println(">> ATM 1 belum melakukan transaksi apapun sejauh ini.");
				}
				else {
					for(int i=0; i<msh.a1.getLogTransaksi().size(); i++) {
						System.out.println(">> " + (i+1) + ". Mesin ATM 1 melakukan transaksi sebesar Rp" + msh.a1.getLogTransaksi().get(i) + ",-");
					}
				}
				System.out.println();
				
				System.out.println("Log transaksi ATM 2:");
				if(msh.a2.getLogTransaksi().isEmpty()) {
					System.out.println(">> ATM 2 belum melakukan transaksi apapun sejauh ini.");
				}
				else {
					for(int i=0; i<msh.a2.getLogTransaksi().size(); i++) {
						System.out.println(">> " + (i+1) + ". Mesin ATM 2 melakukan transaksi sebesar Rp" + msh.a2.getLogTransaksi().get(i) + ",-");
					}
				}
				System.out.println();
				
				System.out.println("Log transaksi ATM 3:");
				if(msh.a3.getLogTransaksi().isEmpty()) {
					System.out.println(">> ATM 3 belum melakukan transaksi apapun sejauh ini.");
				}
				else {
					for(int i=0; i<msh.a3.getLogTransaksi().size(); i++) {
						System.out.println(">> " + (i+1) + ". Mesin ATM 3 melakukan transaksi sebesar Rp" + msh.a3.getLogTransaksi().get(i) + ",-");
					}
				}
				System.out.println();
				
				System.out.println("Log transaksi ATM 4:");
				if(msh.a4.getLogTransaksi().isEmpty()) {
					System.out.println(">> ATM 4 belum melakukan transaksi apapun sejauh ini.");
				}
				else {
					for(int i=0; i<msh.a4.getLogTransaksi().size(); i++) {
						System.out.println(">> " + (i+1) + ". Mesin ATM 4 melakukan transaksi sebesar Rp" + msh.a4.getLogTransaksi().get(i) + ",-");
					}
				}
				System.out.println();
				
				System.out.println("Total transaksi di mesin ATM 1 = Rp" + msh.a1.getTotal() + ",-");
				System.out.println("Total transaksi di mesin ATM 2 = Rp" + msh.a2.getTotal() + ",-");
				System.out.println("Total transaksi di mesin ATM 3 = Rp" + msh.a3.getTotal() + ",-");
				System.out.println("Total transaksi di mesin ATM 4 = Rp" + msh.a4.getTotal() + ",-");
				System.out.println();
			}
			else if(choice == 5) {
				if(msh.a1.getLogTransaksi().isEmpty() && msh.a2.getLogTransaksi().isEmpty() && msh.a3.getLogTransaksi().isEmpty() && msh.a4.getLogTransaksi().isEmpty()) {
					System.out.println("Log transaksi keempat mesin ATM masih kosong.");
					System.out.println("Tidak ada data yang perlu dihapus.");
					System.out.println();
				}
				else {
					scan.nextLine();
					char confirm;
					
					System.out.println("Apakah Anda yakin ingin menghapus semua log transaksi?");
					System.out.println("Anda tidak dapat mengembalikannya setelah terhapus.");
					do {
						System.out.print("Konfirmasi dengan menjawab [Y atau N]: ");
						confirm = scan.nextLine().charAt(0);
					} while(confirm != 'Y' && confirm != 'N');
					
					if(confirm == 'Y') {
						msh.a1.getLogTransaksi().clear();
						msh.a2.getLogTransaksi().clear();
						msh.a3.getLogTransaksi().clear();
						msh.a4.getLogTransaksi().clear();
						
						msh.a1.setTotal(0);
						msh.a2.setTotal(0);
						msh.a3.setTotal(0);
						msh.a4.setTotal(0);
						
						System.out.println("Log transaksi semua mesin ATM berhasil dihapus.");
						System.out.println();
					}
					else {
						System.out.println("Log transaksi batal dihapus.");
						System.out.println();
					}
				}
			}
			else if(choice == 6) {
				System.out.println("Terima kasih telah menggunakan simulator ATM Bank Fentira.");
			}
			else {
				System.out.println("Maaf, Anda memasukkan input yang salah.");
				System.out.println("Coba lagi.");
				System.out.println();
			}
			
			System.out.println();
			
		} while(choice != 6);
		
	}
}