/**
 * Program to simulate an escape room with multiple doors
 * @author Group 16: Marvin Barajas and Catherine Bui
 * @version 10/13/2020
 * Copyright (C) 2020 Marvin Barajas and Catherine Bui. All Rights Reserved.
 */

import java.util.Random;

public class Main {
	/** Main function to run program
	 * @param args arguments to be input into main
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the Escape Room.");
		System.out.println("You must unlock 3 doors to escape...");

		for (int i = 0; i < 3; i++) {
			Random rand = new Random();
			int doorNum = rand.nextInt(4) + 1;

			if (doorNum == 1) {
				Door d = new BasicDoor();
				System.out.println("You encountered a basic door.");
				openDoor(d);
			} else if (doorNum == 2) {
				Door d = new LockedDoor();
				System.out.println("You encountered a locked door.");
				openDoor(d);
			} else if (doorNum == 3) {
				Door d = new DeadboltDoor();
				System.out.println("You encountered a deadbolt door.");
				openDoor(d);
			} else if (doorNum == 4) {
				Door d = new ComboDoor();
				System.out.println("You encountered a combination door.");
				openDoor(d);
			}
		}
		System.out.println("Congratulations! You were the only one to survive...alone...FOREVER!");
	}

	/** Interacts user with a locked door until it can be opened
	 * @param d door user will try to unlock
	 */
	public static void openDoor(Door d) {
		System.out.println(d.examine());
		System.out.println(d.menu());
		int option = CheckInput.getPositiveInt();
		System.out.println(d.unlock(option));
		d.open();

		while (d.open() == false) {
			System.out.println(d.clue());
			System.out.println(d.menu());
			option = CheckInput.getPositiveInt();
			System.out.println(d.unlock(option));
			d.open();
		}
		if (d.open() == true) {
			System.out.println(d.success());
		}
	}
}
