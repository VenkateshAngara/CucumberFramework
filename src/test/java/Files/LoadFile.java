package Files;

public class LoadFile {

	public static String AddPlace() {
		return "{\\r\\n\"+\n"
				+ "	\"  \\\"location\\\":{\\r\\n\"+\n"
				+ "	\"  \\\"lat\\\" :-38.383494,\\r\\n \"+\n"
				+ "	\"  \\\"lng\\\" :33.383494,\\r\\n \"+\n"
				+ "	\"},\\r\\n\"+\n"
				+ "	\"  \\\"accuracy\\\":50,\\r\\n\"+\n"
				+ "	\"  \\\"name\\\":\\\"Angara Venkatesh\\\",\\r\\n\"+\n"
				+ "	\"  \\\"phone_number\\\":\\\"(+91) 954 2322 769\\\",\\r\\n\"+\n"
				+ "	\"  \\\"address\\\":\\\"8-5-29/30,RAMACHANDRAPURAM\\\",\\r\\n\"+\n"
				+ "	\"  \\\"types\\\":[,\\r\\n\"+\n"
				+ "	\"  \\\"shoe park\\\",\\r\\n\"+\n"
				+ "	\"  \\\"shop\\\"\\r\\n\"+\n"
				+ "	\"  ],\\r\\n\"+\n"
				+ "	\"  \\\"website\\\":\\\"http://www.venkateshangara.com\\\",\\r\\n\"+\n"
				+ "	\"  \\\"language\\\":\\\"French-IN\\\",\\r\\n\"+\n"
				+ "	\"}\\r\\n\"+\"";
	}
	public static String CreateAccount() {
		return "{\n"
				+ "    \"name\": \"Angara Venkatesh\",\n"
				+ "    \"job\": \"QA Tester\"\n"
				+ "}";
	}
	public static String updateData() {
		return "{\n"
				+ "    \"name\": \"Angara\",\n"
				+ "    \"job\": \"QA Tester\"\n"
				+ "}";
	}
	public static String responseCheck() {
		return "{\n"
				+ "\n"
				+ "\"dashboard\": {\n"
				+ "\n"
				+ "\"purchaseAmount\": 910,\n"
				+ "\n"
				+ "\"website\": \"rahulshettyacademy.com\"\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "\"courses\": [\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Selenium Python\",\n"
				+ "\n"
				+ "\"price\": 50,\n"
				+ "\n"
				+ "\"copies\": 6\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Cypress\",\n"
				+ "\n"
				+ "\"price\": 40,\n"
				+ "\n"
				+ "\"copies\": 4\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"RPA\",\n"
				+ "\n"
				+ "\"price\": 45,\n"
				+ "\n"
				+ "\"copies\": 10\n"
				+ "\n"
				+ "}\n"
				+ "\n"
				+ "]\n"
				+ "\n"
				+ "}\n"
				+ "\n"
				+ "";
	}
	public static String UpdatedData() {
		return"{\n"
				+ "\n"
				+ "\"dashboard\": {\n"
				+ "\n"
				+ "\"purchaseAmount\": 1190,\n"
				+ "\n"
				+ "\"website\": \"rahulshettyacademy.com\"\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "\"courses\": [\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Selenium Python\",\n"
				+ "\n"
				+ "\"price\": 50,\n"
				+ "\n"
				+ "\"copies\": 6\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Cypress\",\n"
				+ "\n"
				+ "\"price\": 40,\n"
				+ "\n"
				+ "\"copies\": 4\n"
				+ "\n"
				+ "},\n"
				+"\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Full Stack\",\n"
				+ "\n"
				+ "\"price\": 40,\n"
				+ "\n"
				+ "\"copies\": 4\n"
				+ "\n"
				+ "},\n"
				+"\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Appium\",\n"
				+ "\n"
				+ "\"price\": 30,\n"
				+ "\n"
				+ "\"copies\": 4\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"RPA\",\n"
				+ "\n"
				+ "\"price\": 45,\n"
				+ "\n"
				+ "\"copies\": 10\n"
				+ "\n"
				+ "}\n"
				+ "\n"
				+ "]\n"
				+ "\n"
				+ "}";
	}
	public static String AddBook() {
		return "{\n"
				+ "\"name\" :\"Learn Selenium Automation with Java\",\n"
				+ "\"isbn\":\"bczd\",\n"
				+ "\"aisle\":\"2270\",\n"
				+ " \"author\":\"John foe\"\n"
				+ "  \n"
				+ "}";
	}
	public static String AddBook(String isbn,String aisle) {
		return "{\n"
				+ "\"name\" :\"Learn Selenium Automation with Java\",\n"
				+ "\"isbn\":\""+isbn+"\"\",\n"
				+ "\"aisle\":\""+aisle+"\"\",\n"
				+ " \"author\":\"John foe\"\n"
				+ "  \n"
				+ "}";
	}
}
