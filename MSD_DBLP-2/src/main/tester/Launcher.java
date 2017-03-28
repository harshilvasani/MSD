package tester;

import java.io.IOException;

public class Launcher {

	public static void main(String[] args) throws IOException {
		Runtime.getRuntime().exec("java frontend.LoginPage");
		System.out.println("Launched Application");
	}
}
