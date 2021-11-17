import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import acm.program.GraphicsProgram;

public class MainApplication extends GraphicsProgram {
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";

	private GraphicsPane curScreen;
	private WelcomePane welcome;
	private MenuPane menu;
	private Settings settings;
	private Leaderboard leaderboard;
	private TransitionPane transition;
	private MainGame game;
	
	/* Method: setupInteractions
	 * -------------------------
	 * must be called before switching to another
	 * pane to make sure that interactivity
	 * is setup and ready to go.
	 */
	protected void setupInteractions() {
		requestFocus();
		addKeyListeners();
		addMouseListeners();
	}
	
	/* switchToScreen(newGraphicsPane)
	 * -------------------------------
	 * will simply switch from making one pane that was currently
	 * active, to making another one that is the active class.
	 */
	protected void switchToScreen(GraphicsPane newScreen) {
		if(curScreen != null) {
			curScreen.hideContents();
		}
		newScreen.showContents();
		curScreen = newScreen;
	}
	
	public void switchToGame() {
		switchToScreen(game);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mousePressed(e);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseReleased(e);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseClicked(e);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseDragged(e);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseMoved(e);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyPressed(e);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyReleased(e);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyTyped(e);
		}
	}
	

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("Let's make something awesome!");
		welcome = new WelcomePane(this);
		menu = new MenuPane(this);
		leaderboard = new Leaderboard(this);
		settings = new Settings(this);
		transition = new TransitionPane(this);
		game = new MainGame(this);
		setupInteractions();
		switchToWelcome();
	}

	public void switchToWelcome() {
		switchToScreen(welcome);
	}
	
	public void switchToMenu() {
		switchToScreen(menu);
	}

	public static void main(String[] args) {
		new MainApplication().start();
	}

	public void switchToSettings() {
		switchToScreen(settings);	
	}
	
	public void switchToLeaderboard() {
		switchToScreen(leaderboard);
		
	}
	
	public void switchToTransition() {
		switchToScreen(transition);	
	}
}
