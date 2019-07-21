package CoreQuestions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class testingwine {

	static final String inputFilename = "E:/workspace/CoreJava/src/CoreQuestions/person_wine_3.txt";

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(inputFilename));
		String line;
		int maxWid = -1;
		int count = 0;
		
		 /*Note that the IDs of the output second column should be unique since a
		 single bottle of wine cannot be sold to two people and an ID on the first column can
		 appear at most three times since each person can only buy up to 3 bottles of wine.
		 */
		Map<Integer, Integer> maps = new HashMap<>();
		LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
		while ((line = br.readLine()) != null) {
			
			/*Each subsequent line should be two columns, tab-separated. The first column is an ID of 
			a person and the second column should be the ID of the wine that they will buy.
			*/
			
			StringTokenizer token = new StringTokenizer(line);
			String personID = token.nextToken().replaceFirst("person", "");
			String wineID = token.nextToken().replaceFirst("wine", "");
			Integer pid = Integer.parseInt(personID);
			Integer wid = Integer.parseInt(wineID);

			if (wid < maxWid)
				wid = maxWid;

			if (count < 1) {
				maps.put(wid, pid);
				count++;
			}
			else {
				count=0;
			}

		}
		maps.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

		sortedMap.entrySet().forEach(entry -> {
		    System.out.println("wine"+entry.getKey() + " : " +"person"+entry.getValue());
		}); 
		
	

		
	}

}
