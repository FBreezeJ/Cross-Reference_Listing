import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Hash class constructs a hash object that simply stores the PrintWriter object initialized in the main method.
 * Hash function creates a hash table (String array) and stores omitted words from the omitted.txt file using 
 * the hash function. The getHash method creates a minimal perfect hash function by using the values that I
 * gathered from Cichelli's algorithm. A description of the process is also provided in the getDescription method.
 */

public class Hash {
	private PrintWriter pw;
	private int collisions = 0;
	private String[] hashTable = new String[27];
	
	/**
	 * Hash constructor constructs a Hash object that contains a PrintWriter object.
	 * @param PrintWriter p = object containing the csis_binarytrees.txt file to output data to
	 */
	
	public Hash(PrintWriter p) {
		pw = p;
	}
	
	/**
	 * increments the collisions class variable which determines the number of collisions that takes place in the hash table
	 */
	
	public void addCollision() {
		collisions++;
	}
	
	/**
	 * @return int collisions = integer variable representing the number of collisions that took place while assigning keys to the hash table
	 */
	
	public int getCollisions() {
		return collisions;
	}
	
	/**
	 * @return int hashTable.length = integer value representing the size of the hash table.
	 */
	
	public int getHashTableSize() {
		return hashTable.length;
	}
	
	/**
	 * @return int count = integer value representing the number of occupied spaces in the hash table.
	 */
	
	public int countSpacesTaken() {
		int count = 0;
		
		for(int i = 0; i < hashTable.length; i++) {
			if(hashTable[i] != null) count++;
		}
		return count;
	}
	
	/**
	 * method reads lines from the omitted.txt file and sends them to the getHash function to determine each string's hash table index.
	 * If a collision occurs (duplicate index) then linear probing occurs until an empty space is encountered. Collisions are counted 
	 * by calling upon the addCollisions method.
	 * @throws FileNotFoundException in case omitted.txt does not exist or cannot be read.
	 */
	
	public void getHashTable() throws FileNotFoundException {
		Scanner om = new Scanner(new File("omitted.txt"));
		
		while(om.hasNextLine()) {
			String omitted = om.nextLine();
			int hash = getHash(omitted);
			if(hashTable[hash] == null) { 
				hashTable[hash] = omitted;
			}
			else {
				addCollision();
				if(hash == hashTable.length-1) hash = 0;
				while(hashTable[hash] != null) {
					if(hash == hashTable.length-1) hash = 0;
					else hash++;
				}
				hashTable[hash] = omitted;
			}
		}
	
	}
	
	/**
	 * getHash method calculates the appropriate index value correlating to the independent string variable provided by the getHashTable method.
	 * An integer array containing constructed numerical values for each letter of the alphabet was calculated using a Cichelli's algorithm that I designed.
	 * This allows for the construction of a minimal perfect hash function, which, as can later be seen, produces absolutely no collisions and allows for O(1) 
	 * search time. The formula is: ((string length) + (value of char1 + 1) + (value of char2 - 1))%tablesize.
	 * @return int (length + value1 + value2)%27 = hash function's solution for the string provided.
	 * @param String s = omitted word read from the omitted.txt file.
	 */
	
	private int getHash(String s) { 
		int[] letterValue = {4, 4, 8, 12, 4, 21, 5, 4, 24, 11, 13, 16, 8, 18, 9, 1, 8, 9, 26, 17, 11, 6, 5, 20, 1, 1};
		int length = s.length();
		int letter1 = letterValue[(((s.charAt(0)+1)%123)%97)%27];
		int letter2 = letterValue[(((s.charAt(s.length()-1)+25)%123)%97)%27];

		return (length + letter1 + letter2)%27;
	}
	
	/**
	 * simply outputs a description of the hash function and table and other relevant data to the terminal window and csis_binarytrees.txt file.
	 */
	
	public void getDescription() {
		System.out.println("Description: The hash function is a minimal perfect hash function, meaning that it assigns");
		System.out.println("\teach independent variable (omitted words) to a dependent variable (hash table index) without");
		System.out.println("\tcollisions and with no wasted space. This makes the function have a worst case time complexity");
		System.out.println("\tof O(1). The values contained in the letter[] array were derived from a Cichelli's algorithm");
		System.out.println("\tthat I personally designed");
		System.out.println("Number of Collisions from the Hashing Function: " + getCollisions());
		System.out.println("Load Factor: " + countSpacesTaken()/getHashTableSize());
		System.out.println();
		pw.println("Description: The hash function is a minimal perfect hash function, meaning that it assigns");
		pw.println("\teach independent variable (omitted words) to a dependent variable (hash table index) without");
		pw.println("\tcollisions and with no wasted space. This makes the function have a worst case time complexity");
		pw.println("\tof O(1). The values contained in the letter[] array were derived from a Cichelli's algorithm");
		pw.println("\tthat I personally designed");
		pw.println("Number of Collisions from the Hashing Function: " + getCollisions());
		pw.println("Load Factor: " + countSpacesTaken()/getHashTableSize());
		pw.println();
	}
	
	/**
	 * outputs a visual hash table, complete with indices and keys, to the terminal window and .txt file.
	 */
	
	public void printHashTable() {
		int i = 0;
		
		for(i = 0; i < hashTable.length; i++) {
			System.out.println("[" + i + "] " + hashTable[i]);
			pw.println("[" + i + "] " + hashTable[i]);
		}
	}
	
	/**
	 * allows for other classes to search the hash table for specific strings. Because getHash is private, this is 
	 * the only way for other classes to test the hash table. Like the getHashTable method, a hash value for the parameter
	 * string is calculated by calling upon the getHash method. If the value is found, then true is returned; else false.
	 * @return boolean value depending on whether the string is found in the hash table or not.
	 * @param String s = string provided by external classes to determine if it lies within the hash table or not.
	 */
	
	public boolean searchHash(String s) {
		int hash = getHash(s);
		if(hashTable[hash] != null) {
			if(hashTable[hash].equals(s)) return true;
			else {
				int count = 0;
				while(hashTable[hash] != null && count < 27) {
					if(hash == hashTable.length-1) hash = 0;
					else if(hashTable[hash].equals(s)) return true;
					hash++;
					count++;
				}
			}
			if(hashTable[hash].equals(s)) return true;
		}
		return false; 
		
	}
}
