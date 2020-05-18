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
		System.out.println("4. liste des habilet�s...");
		System.out.println("4. liste des sp�cialistations...");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}
	
	static int editMenu (Scanner sc) {
		System.out.println("�diter: ");
		System.out.println("1. �quipements");
		System.out.println("2. sorts");
		System.out.println("3. habilet�s");
		System.out.println("4. sp�cialisations");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}
	
	static int newMenu(Scanner sc) {
		System.out.println("Menu cr�ation:");
		System.out.println("1. personnages...");
		System.out.println("2. �quipements...");
		System.out.println("3. sorts...");
		System.out.println("4. competences...");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}
	
	static char editMenuEnd(Scanner sc, String nom, boolean added, String item) {
		if (added) {
			System.out.println(item+" "+ nom+" ajout� !");
		}
		System.out.println("Retour au menu principal ? y/n");
		
		sc.nextLine();
		String sExit = sc.nextLine();
		char cExit = sExit.charAt(0);
		return cExit;
	}
}
