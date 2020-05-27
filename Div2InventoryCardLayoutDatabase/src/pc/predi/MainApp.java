package pc.predi;

public class MainApp {
	public static void main(String[] args) {
//		MainView view = new MainView();
//		MainModel model = new MainModel();
//		MainController controller = new MainController(view, model);
//		view.getFrame().pack();
//		view.getFrame().setVisible(true);

		/**
		 * MainView is to handle the view of the program
		 *
		 * MainModel is to handle the calculations of the program
		 * - since the program is just to send the information from the GUI to the database/textfiles
		 * - the program will have little to no calculations
		 * MainController is to handle the event handlers of the program and the interactions between the View and the Model
		 *
		 */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainView view = new MainView();
				MainModel model = new MainModel();
				MainController controller = new MainController(view, model);
				//view.getFrame().pack();
				view.getFrame().setVisible(true);
			}
		});
	}
}