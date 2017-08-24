package reportgenerator;

import reportgenerator.pdfManager.linker;
import reportgenerator.pdflayout.pageLayout;
import reportgenerator.window.Window;

public class main {

	public static void main(String[] args) {

		linker link = new linker();
		Window window = new Window();
		pageLayout layout = new pageLayout(link);
	}
}