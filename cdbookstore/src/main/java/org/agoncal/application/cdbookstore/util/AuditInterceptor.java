package org.agoncal.application.cdbookstore.util;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.logging.Logger;

@Auditable
@Interceptor
public class AuditInterceptor implements Serializable {

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