/**
 * 
 */
package utiles;

/**
 * @author hevacho
 *
 */
public class Configuracion {
	
	private String mailFrom;
	private String mailBcc;
	/**
	 * @return the mailFrom
	 */
	public String getMailFrom() {
		return mailFrom;
	}
	/**
	 * @param mailFrom the mailFrom to set
	 */
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	/**
	 * @return the mailBcc
	 */
	public String getMailBcc() {
		return mailBcc;
	}
	/**
	 * @param mailBcc the mailBcc to set
	 */
	public void setMailBcc(String mailBcc) {
		this.mailBcc = mailBcc;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Configuracion [mailFrom=");
		builder.append(mailFrom);
		builder.append(", mailBcc=");
		builder.append(mailBcc);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
