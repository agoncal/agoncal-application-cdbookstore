package org.agoncal.application.cdbookstore.util;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

import static javax.interceptor.Interceptor.Priority.APPLICATION;

@Auditable
@Interceptor
@Priority(APPLICATION + 10)
public class AuditInterceptor {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Inject
    private Logger logger;

    // ======================================
    // =          Business methods          =
    // ======================================

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {
        long begin = System.currentTimeMillis();
        try {
            return ic.proceed();
        } finally {
            logger.info("Took " + (System.currentTimeMillis() - begin));
        }
    }
}