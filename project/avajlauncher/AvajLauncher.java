package avajlauncher;

import avajlauncher.Parser;

public class AvajLauncher {
	public static void main(String args[]) {
		if (args.length < 1)
			System.out.println("Wrong number of arguments.\n"
				+ "Usage: java Parser <file path>");
	
		Parser	parser = new Parser(args[0]);
		if (!parser.isOk())
			return ;

		System.out.println(parser.getLines());
	}
}