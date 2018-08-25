import java.util.Arrays;

/**
 * CichellisMethod constructs a default CichellisMethod object. The point of this class is simply to return the hash values of 
 * every letter in the alphabet given the predetermined set of string values provided by the omitted.txt file.
 * Cichellis method is a useful algorithm for designing a minimal perfect hash function for string values. It words by first 
 * determining the number of occurrences for the first and last letters of every word in a set. From there, the letters are often
 * organized from greatest commonality to smallest. Then, the words in the set are organized based on the added commonality of the 
 * first and last letters, also from greatest commonality to smallest. From there, the value for each letter is set back to zero, and
 * the values are redesigned by hashing each word in the set according to this equation: [(string length) + (char1 value) + (char2 
 * value)]%tablesize. If a collision occurs, then the value of char1 is incremented until the collision is absolved. If there is already
 * a value greater than 0 for char1, then char2's value is incremented until the collision is absolved. If both values are greater than
 * zero, then a previous word in which the two values are not greater than 0 is found, and from there either its value1 or value2 is 
 * incremented until a collision is absolved. From this algorithm, specific hash values for each letter of the alphabet are 
 * calculated until a minimal perfect hash collision occurs. These values will be returned to the Hash class.
 */

public class CichellisMethod 
{
	
	/**
	 * default CichellisMethod constructor. This class contains no unique variables.
	 */
	
	public CichellisMethod(){
		
	}
	
	/**
	 * This method follows the steps articulated in the class description. The omitted words have already 
	 * been pre-programmed into the method in the form of a String array.
	 * @return int[] function = an array of size 26 that contains hash values for every letter in the alphabet.
	 */
	
	public void getFunction() {
		String[] omitted = {"a", "after", "all", "and", "because", "every", "for", "from", "had", "have", "in",
				"is", "it", "its", "now", "of", "on", "so", "that", "the", "their", "there", "to",
				"was", "were", "which", "with"};
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		Letter[] l = new Letter[26];
		int i = 0;
		//makes a Letter array containing every letter of the alphabet.
		for(i = 0; i < alphabet.length; i++) {
			l[i] = new Letter(alphabet[i], 0);
		}
		//increments the occurrences of every first and last letter of every omitted word.
		//the increments are accrued by the Letter objects contained in l[].
		for(i = 0; i < omitted.length; i++) {
			if(omitted[i].length() > 1) {
				l[omitted[i].charAt(0)%97].add();
				l[omitted[i].charAt(omitted[i].length()-1)%97].add();
			}
			else {
				l[omitted[i].charAt(0)%97].add();
			}
		}
		//creates an array containing OmittedWord objects with each word from the omitted array 
		//as well as every word's commonality index, determined by the occurrences of each word's
		//FIRST and last letters
		OmittedWord[] w = new OmittedWord[27];
		OmittedWord word;
		for(i = 0; i < omitted.length; i++) {
			if(omitted[i].length() > 1) {
				word = new OmittedWord(omitted[i], l[omitted[i].charAt(0)%97].getValue() 
						+ l[omitted[i].charAt(omitted[i].length()-1)%97].getValue());
			}
			else {
				word = new OmittedWord(omitted[i], l[omitted[i].charAt(0)%97].getValue());
			}
			w[i] = word;
		}
		//bubble sorts the OmittedWord array's contents from greatest commonality to lowest commonality
		OmittedWord temp;
		for(i = 0; i < w.length-1; i++) {
			for(int j = i+1; j < w.length; j++) {
				if(w[i].getValue() < w[j].getValue()) {
					temp = w[i];
					w[i] = w[j];
					w[j] = temp;
				}
			}
		}
		//main loop of the entire class
		//this loop goes through the process of reassigning values to every Letter object.
		//to avoid more collisions, the equation is designed to take into account the letter
		//that comes after every word's first letter, and the letter that comes before 
		//every word's last letter. By the end of this loop, every hash value will be 
		//calculated and ready for the Hash class.
		OmittedWord[] hashTable = new OmittedWord[27];
		for(i = 0; i < w.length; i++) {
			int length = (int) w[i].getWord().length();
			int value1 = (int) l[((w[i].getWord().charAt(0)+1)%123)%97].getValue();
			int value2 = (int) l[((w[i].getWord().charAt(w[i].getWord().length()-1)+25)%123)%97].getValue();
			String myWord = w[i].getWord();
			OmittedWord words = (OmittedWord) w[i];
			//if the hash function results in a null value then the current values for value1 and value2 suffice.
			if(hashTable[(length + value1 + value2)%27] == null) {
				hashTable[(length + value1 + value2)%27] = w[i];
			}
			//else, this will determine the new values for value1 and/or value2
			else {
				//this if statement will call upon previous words to increment their character values in order to make room for the current word and its values.
				//the statement proceeds until either the first word is confronted, or until a word with an empty value (either 1 or 2) is met.
				if(value1 > 0 && value2 > 0) {

					int iTemp = i;
					while(value1 > 0 && value2 > 0 && i > 0) {

						i -= 1;
						length = (int) w[i].getWord().length();
						value1 = (int) l[((w[i].getWord().charAt(0)+1)%123)%97].getValue();
						value2 = (int) l[((w[i].getWord().charAt(w[i].getWord().length()-1)+25)%123)%97].getValue();
						myWord = w[i].getWord();
						words = (OmittedWord) w[i];
						
					}
					i = iTemp;
					if(value1 > 0 && value2 > 0) {

						length = (int) w[i].getWord().length();
						value1 = (int) l[((w[i].getWord().charAt(0)+1)%123)%97].getValue();
						value2 = (int) l[((w[i].getWord().charAt(w[i].getWord().length()-1)+25)%123)%97].getValue();
						myWord = w[i].getWord();
						words = (OmittedWord) w[i];
					}
					else hashTable[(length + value1 + value2)%27] = null;

				}
				//if either the current word or a previous word is found with a value1 or value2 of zero, then these statements proceed as follows:
				if(value1 == 0 && value2 > 0) {
					value1++;
					l[((myWord.charAt(0)+1)%123)%97].add();
					while(hashTable[(length + value1 + value2)%27] != null) {
						value1++;
						l[((myWord.charAt(0)+1)%123)%97].add();
					}
					hashTable[(length + value1 + value2)%27] = words;
					
				}
				else if(value1 > 0 && value2 == 0){
					value2++;
					l[((myWord.charAt(myWord.length()-1)+25)%123)%97].add();
					while(hashTable[(length + value1 + value2)%27] != null) {
						value2++;
						l[((myWord.charAt(myWord.length()-1)+25)%123)%97].add();
					}
					hashTable[(length + value1 + value2)%27] = words;
				}
				else if(value1 == 0 && value2 == 0) {
					value2++;
					l[((myWord.charAt(myWord.length()-1)+25)%123)%97].add();
					while(hashTable[(length + value1 + value2)%27] != null) {
						value2++;
						l[((myWord.charAt(myWord.length()-1)+25)%123)%97].add();
					}
					hashTable[(length + value1 + value2)%27] = words;
				}
				//if value1 and value2 contain values greater than zero, then this statement will find hash values appropriate for a minimal perfect hash function
				else {
					if(value1 > value2) {
						value2++;
						l[((myWord.charAt(myWord.length()-1)+25)%123)%97].add();
						while(hashTable[(length + value1 + value2)%27] != null) {
							value2++;
							l[((myWord.charAt(myWord.length()-1)+25)%123)%97].add();
						}
						hashTable[(length + value1 + value2)%27] = words;
					}
					else {
						value1++;
						l[((myWord.charAt(0)+1)%123)%97].add();
						while(hashTable[(length + value1 + value2)%27] != null) {
							value1++;
							l[((myWord.charAt(0)+1)%123)%97].add();
						}
						hashTable[(length + value1 + value2)%27] = words;
					}
				
				}
				//to take into account the possible modification of previous words' character hash values, the process will start back from the first word
				i = -1;
				Arrays.fill(hashTable, null);
			}
			
		}
		//this loop prints the values that we are looking to program into our getHash function.
		
		for(i = 0; i < l.length; i++) {
			System.out.print(l[i].getValue()%27 + " " );
		}

	}
}