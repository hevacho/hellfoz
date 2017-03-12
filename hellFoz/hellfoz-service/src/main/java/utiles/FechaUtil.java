/**
 * 
 */
package utiles;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hevacho
 *
 */
public class FechaUtil {
	
	private static SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
	
	public static String convertirFecha(Date fecha){
		if(fecha!=null){
			return sf.format(fecha);
		}
		return "";
	}

}
