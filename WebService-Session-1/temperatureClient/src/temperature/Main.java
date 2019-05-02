package temperature;

import java.rmi.RemoteException;
import java.util.logging.*;

import javax.xml.rpc.ServiceException;

/**
 * a client class to test the web service convertTemp
 * @author Satyam Bhadoria
 *
 */
public class Main{

	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	/**
	 *driver method to run the test
	 *@param args - command line argument 
	 */
	public static void main(String[] args) throws RemoteException, ServiceException {
		//to obtain the service instance of required class
		ConvertTempServiceLocator serviceLocator = new ConvertTempServiceLocator();
		logger.info( serviceLocator.getConvertTemp().convertToCelsius(40) );
	}
}
