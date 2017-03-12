/**
 * 
 */
package hellfoz.web;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * @author hevacho
 *
 */
public class EntradaDataSource implements JRDataSource {

	int uno =5;
	
	/* (non-Javadoc)
	 * @see net.sf.jasperreports.engine.JRDataSource#getFieldValue(net.sf.jasperreports.engine.JRField)
	 */
	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		return "prueba";
	}

	/* (non-Javadoc)
	 * @see net.sf.jasperreports.engine.JRDataSource#next()
	 */
	@Override
	public boolean next() throws JRException {
		uno --;
		return uno>0;
		
	}

}
