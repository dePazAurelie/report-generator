package reportgenerator;

import reportgenerator.pdfManager.linker;
import reportgenerator.pdflayout.pageLayout;

public class main {

	public static void main(String[] args) {

		linker link = new linker();

		link.addAttendees("Jean", "Paul", "@", "true");
		link.addAttendees("Jean", "Paul", "@", "true");
		link.addAttendees("Jean", "Paul", "@", "true");
		link.addAttendees("Jean", "Paul", "@", "false");
		link.addAttendees("Jean", "Paul", "@", "false");
		link.addAttendees("Jean", "Paul", "@", "true");
		link.addAttendees("Jean", "Paul", "@", "true");
		link.addAttendees("Jean", "Paul", "@", "true");
		link.addAttendees("Jean", "Paul", "@", "true");

		link.setProjectName("Report generator");
		link.setDate("August the 24th 2017");
		link.addHost("Valentin", "Ronteix", "valentin@ronteix.fr");
		link.setMeetingNumber("3");
		link.setNotes("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
						"ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
						" laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit" +
						" in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat" +
						" cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");

		pageLayout layout = new pageLayout(link);
	}
}