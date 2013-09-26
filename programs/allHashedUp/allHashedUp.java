import java.util.*;
import java.io.*;
import java.security.*;

public class allHashedUp{
	public static void main(String[] args) throws Exception {
		try{
			File commonPasswords = new File(args[0]);
			File hashes = new File(args[1]);
			
			Scanner in = new Scanner(commonPasswords);
			Scanner hash = new Scanner(hashes);
			
			List<String> wordlist = new ArrayList<String>();
			List<String> hashesToFind = new ArrayList<String>();
			
		    while (in.hasNext()) {
			   wordlist.add(in.next());
	        }
			
			int i = 0;
		    while (hash.hasNext() && i < 6) {
				hashesToFind.add(hash.next());
			   	i++;
	        }
			
			for(int j = 0; j < hashesToFind.size(); j++){
				for(int k = 0; k < wordlist.size(); k++){
					byte[] hashedWord = wordlist.get(k).getBytes();
					MessageDigest md = MessageDigest.getInstance("MD5");
					byte[] md5digest = md.digest(hashedWord);
					String md5string = new String();
					for(byte b: md5digest){
						md5string += Integer.toHexString(0xFF & b);
					}
					if(hashesToFind.get(j).equals(md5string)){
						System.out.println("==HASH FOUND FOR: " + hashesToFind.get(j) + " ==");
						System.out.println(wordlist.get(k));
					}
				}
			}
		}
		catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } 
	}
}