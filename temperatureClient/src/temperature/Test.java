package temperature;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

/**
 * a client class to test the web service convertTemp
 * @author Satyam Bhadoria
 *
 */
public class Test {
	
	public static void main(String[] args) throws RemoteException, ServiceException {
		//to obtain the service instance of required class
		ConvertTempServiceLocator serviceLocator = new ConvertTempServiceLocator();
		System.out.println( serviceLocator.getconvertTemp().convertToCelsius(4f) );
	}
}
