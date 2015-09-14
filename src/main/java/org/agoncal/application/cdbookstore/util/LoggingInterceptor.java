package org.agoncal.application.cdbookstore.util;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.logging.log4j.Logger;

@Loggable
@Interceptor
public class LoggingInterceptor
{

   @Inject
   private Logger logger;

   @AroundInvoke
   private Object intercept(InvocationContext ic) throws Exception
   {
      try
      {
         return ic.proceed();
      }
      finally
      {
      }
   }
}