import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CollectionSorting {

	public static void main(String[] args) throws FileNotFoundException {

		Map<String, Student> map = new TreeMap<String, Student>();

		// Reading lines from input.txt line by line
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\Users\\Sujay\\git\\training\\Project\\src\\input"));
		String line = null;
		String[] words = null;
		try {
			line = br.readLine();
			while (line != null) {
				words = line.split(" ");
				Student student = new Student();
				if (map.containsKey(words[0])) {
					student.setMarks(map.get(words[0]).getMarks()
							+ Integer.parseInt(words[1]));
					student.setNumOfSubs(map.get(words[0]).getNumOfSubs() + 1);
					map.put(words[0], student);
				} else {
					student.setMarks(Integer.parseInt(words[1]));
					student.setNumOfSubs(1);
					map.put(words[0], student);
				}
				line = br.readLine();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Alpha Order (default sorting)

		System.out.println("**** Alpha Order ****");
		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key).getNumOfSubs() + " "
					+ (float) map.get(key).getMarks()
					/ map.get(key).getNumOfSubs());
		}

		// Merit Order
		System.out.println("**** Merit Order ****");
		
		Comparator<Map.Entry<String, Student>> byMapVal = new Comparator<Map.Entry<String, Student>>() {
			@Override
			public int compare(Entry<String, Student> arg0,
					Entry<String, Student> arg1) {
				// TODO Auto-generated method stub
				return (arg1.getValue().getMarks() / arg1.getValue()
						.getNumOfSubs())
						- (arg0.getValue().getMarks() / arg0.getValue()
								.getNumOfSubs());
			}
		};
		
		List<Map.Entry<String, Student>> studentList = new ArrayList<Map.Entry<String, Student>>();
		studentList.addAll(map.entrySet());
		Collections.sort(studentList, byMapVal);

		for (Entry<String, Student> s : studentList) {
			System.out.println(s.getKey() + " " + s.getValue().getNumOfSubs()
					+ " " + (float) s.getValue().getMarks()
					/ s.getValue().getNumOfSubs());
		}

		// Statistics:
		System.out.println("**** Statistics *****");
		System.out.println("Number of students : " + map.keySet().size());

		// Computing Average
		float totalAvg = 0;
		float mean = 0;
		for (String key : map.keySet()) {
			totalAvg += map.get(key).getMarks() / map.get(key).getNumOfSubs();
		}
		mean = totalAvg / map.keySet().size();
		System.out.println("Average student marks "
				+ String.format("%.1f", mean));

		// Computing Standard Deviation
		float std_num = 0;
		for (String key : map.keySet()) {
			std_num += Math.pow(map.get(key).getMarks()
					/ map.get(key).getNumOfSubs() - mean, 2);
		}
		System.out.println("Standard Deviation is"
				+ String.format("%.1f",
						Math.sqrt(std_num / map.keySet().size())));

	}
}
