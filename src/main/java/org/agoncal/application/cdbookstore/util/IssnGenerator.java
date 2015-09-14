package org.agoncal.application.cdbookstore.util;

import org.apache.logging.log4j.Logger;
import javax.inject.Inject;
@EightDigits
public class IssnGenerator {

	@Inject
	private Logger logger;
	@Inject
	@EightDigits
	private String prefix;
	@Inject
	@EightDigits
	private int postfix;
	public String generateNumber() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}