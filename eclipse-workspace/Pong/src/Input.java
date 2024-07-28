import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Input implements KeyListener{
	
	
	
	/*
	 * key: This boolean array (key) is used to store the state of each key on the keyboard.
	 *  The size 68836 is arbitrary and seems quite large; typically, you would size this array 
	 *  based on the maximum possible key code or the number of keys you expect to handle.

	 * */
	public boolean [] key = new boolean[68836];
	
	
	/*
	 * Invoked when a key is pressed down.
	e: Represents the KeyEvent object containing information about the key event.
	e.getKeyCode(): Retrieves the integer keycode associated with the pressed key.
	Sets the corresponding index in the key array to true, indicating that the key is currently pressed.
	 * */
	public void keyPressed(KeyEvent e) {
		
		key[e.getKeyCode()]=true;
	}
	
	
	
	/*
	 * keyReleased(KeyEvent e) Method:
	Invoked when a key is released.
	e: Represents the KeyEvent object containing information about the key event.
	e.getKeyCode(): Retrieves the integer keycode associated with the released key.
	Sets the corresponding index in the key array to false, indicating that the key is no longer pressed.
	 * */
	public void keyReleased(KeyEvent e) {
		key[e.getKeyCode()]=false;
		
	}
	
	
	public void keyTyped(KeyEvent e) {
		// This method is intentionally left blank
	    // Key typed events are not handled in this clasS
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
