package core;

/***
 * 
 * @author anderson.mann
 *
 */

public class BaseTest extends DriverFactory {

	public void waiter(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}