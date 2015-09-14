package org.agoncal.application.cdbookstore.view.util;

import org.agoncal.application.cdbookstore.view.util.CatchException;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.Exception;
import javax.interceptor.AroundInvoke;
import org.apache.logging.log4j.Logger;
import javax.inject.Inject;
@CatchException
@Interceptor
public class CatchExceptionInterceptor {

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