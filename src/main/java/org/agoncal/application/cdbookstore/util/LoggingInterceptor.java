package org.agoncal.application.cdbookstore.util;

import org.agoncal.application.cdbookstore.util.Loggable;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.Exception;
import javax.interceptor.AroundInvoke;
import org.apache.logging.log4j.Logger;
import javax.inject.Inject;
@Loggable
@Interceptor
public class LoggingInterceptor {

	@Inject
	private Logger logger;

	@AroundInvoke
	private Object intercept(InvocationContext ic) throws Exception {
		try {
			return ic.proceed();
		} finally {
		}
	}
}