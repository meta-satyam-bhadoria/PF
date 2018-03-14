package temperature;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * This class contains a function to convert temperature unit from farenheit to celsius
 * @author Satyam Bhadoria
 *
 */
@WebService
public class ConvertTemp {

	/**
	 * This function takes a input parameter which is the temperature in farenhiet
	 * and returns the celsius equivalent temperature.
	 * @param farenheit - temperature in farenheit
	 * @return celsius equivalent temperature
	 */
	@WebMethod
	public float convertToCelsius(float farenheit){
		return ( ( farenheit - 32) * 5 ) / 9;
	}
}