import java.util.*;

public class EncryptionProgram {
	
	private Scanner scanner;
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String line;
	private char[] letters;
	
	
	
	EncryptionProgram(){
		scanner = new Scanner(System.in);
		random = new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();
		character = ' ';
		
		newKey();
		askQuestion();
       
	}
	private void askQuestion(){
		while(true) {
			System.out.println("*****************************************************");
			System.out.println("what do you want to do?");
			System.out.println("(N)ewKay, (G)etKey, (E)ncrypt, (D)ecript, (Q)uit");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch (response) {
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
			default:
				System.out.println("not a valid answer :(");
			}
			
		}
		
	}
	private void newKey() {
		
		character = ' ';
		list.clear();
		shuffledList.clear();
		
		for(int i = 32; i<127; i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		shuffledList = new ArrayList(list);
		Collections.shuffle(shuffledList);
		System.out.println("A new key has been generated!");
	}
	private void getKey() {
		System.out.println("key: ");
		for(Character x : list) {
			System.out.print(x);
		}
		System.out.println();
		for(Character x : shuffledList) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void encrypt() {
		
		System.out.println("enter a message to be encypted!");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for (int i =0; i<letters.length;i++) {
		
			for (int j =0; j<list.size();j++) {
			       if(letters[i]==list.get(j)) {
					letters[i]=shuffledList.get(j);
					break;
				}
				
			}
		}
			System.out.println("encrypted: ");
			for(char x : letters) {
				System.out.print(x);
			}
		System.out.println();
	}
	private void decrypt() {

		System.out.println("enter a message to be decypted!");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for (int i =0; i<letters.length;i++) {
		
			for (int j =0; j<shuffledList.size();j++) {
			      if(letters[i]==shuffledList.get(j)) {
					letters[i]=list.get(j);
					break;
				}
				
			}
		}
			System.out.println("decrypted: ");
			for(char x : letters) {
				System.out.print(x);
			}
		System.out.println();
	}
	private void  quit() {
		System.out.println("thank you, have a nice day!");
		System.exit(0);
	}

}
