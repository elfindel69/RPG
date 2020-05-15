import java.util.Scanner;

public class ViewMenu {
	
	static int startMenu(Scanner sc) {
		System.out.println("Menu:");
		System.out.println("1. affichage...");
		System.out.println("2. ajout...");
		System.out.println("3. nouveau...");
		int choice = sc.nextInt();
		return choice;
	}
	
	static int viewMenu(Scanner sc) {
		System.out.println("Menu affichage:");
		System.out.println("1. liste des personnages...");
		System.out.println("2. liste des �quipements...");
		System.out.println("3. liste des sorts...");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}
	
	static int editMenu (Scanner sc) {
		System.out.println("�diter: ");
		System.out.println("1. �quipement");
		System.out.println("2. sorts");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}
	
	static int newMenu(Scanner sc) {
		System.out.println("Menu cr�ation:");
		System.out.println("1. personnages...");
		//System.out.println("2. liste des �quipements...");
		//System.out.println("3. liste des sorts...");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}
	
	static char editMenuEnd(Scanner sc, String nom) {
		System.out.println("�quipement "+ nom+" ajout� !");
		System.out.println("Retour au menu principal ? y/n");
		
		sc.nextLine();
		String sExit = sc.nextLine();
		char cExit = sExit.charAt(0);
		return cExit;
	}
}
