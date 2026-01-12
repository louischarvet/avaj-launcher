package avajlauncher;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

import avajlauncher.InvalidFormatException;
import avajlauncher.InvalidValueException;

public class Parser {
	private	static List< String >	aircraftTypes;
	private static List< String >	lines;
	private static int	numberOfIterations;
	private boolean	ok;

	public static void main(String args[]) {
		if (args.length < 1)
			System.out.println("Wrong number of arguments.\n"
				+ "Usage: java Parser <file path>");
//		this(args[0]);
	}

	public Parser(String filePath) {
		this.ok = false;

		try {
			this.aircraftTypes = new ArrayList<>();
			this.aircraftTypes.add("Helicopter");
			this.aircraftTypes.add("JetPlane");
			this.aircraftTypes.add("Baloon");

			this.lines = readFile(filePath);
			checkLines();
			this.ok = true;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static List< String >	readFile(String filePath) {
		List< String >	linesList = new ArrayList<>();
		Scanner scanner = new Scanner(new File(filePath));

		while (scanner.hasNextLine()) {
			String	line = scanner.nextLine();

			if (!line.isEmpty() && line != "\n") //
				linesList.add(line);
		}

		return linesList;
	}

	private void checkLines() {
		ListIterator< String >	it = this.lines.listIterator();

		if (!it.hasNext())
			throw new InvalidFormatException("Empty file");

		String firstLine = it.next();
		this.numberOfIterations = Integer.parseInt(firstLine); // throws NumberFormatException

		if (!it.hasNext())
			throw new InvalidFormatException("No aircraft set");

		while (it.hasNext()) {
			String	line = it.next();
			if (!line.matches("^(Helicopter|Baloon|JetPlane) [a-zA-Z0-9]+ \\d+ \\d+ \\d+$"))
				throw new InvalidFormatException("Bad line format: " + line);

			String	words[] = line.split(" ");
			int	size = words.length;
			if (size != 5)
				throw new InvalidFormatException("Missing parameter: " + line
					+ "\nLine format: <Type> <Name> <Longitude> <Latitude> <Height>");

			if (!this.aircraftTypes.contains(words[0]))
				throw new InvalidValueException("Aircraft type", words[0],
					"Must be one of Helicopter, JetPlane or Baloon");

			for (int i = 2; i < size; i++) {
				if (Integer.parseInt(words[i]) < 0)
					throw new InvalidValueException("Coordinate", words[i],
						"Must be positive integer. If height > 100, it will be set to 100.");
			}
		}
	}

	public List< String >	getLines() {
		return this.lines;
	}
}