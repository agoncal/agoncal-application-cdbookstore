package org.agoncal.application.cdbookstore.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class PasswordUtils
{

   public static String digestPassword(String plainTextPassword)
   {
      try
      {
         MessageDigest md = MessageDigest.getInstance("SHA-256");
         md.update(plainTextPassword.getBytes("UTF-8"));
         byte[] passwordDigest = md.digest();
         return new BASE64Encoder().encode(passwordDigest);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Exception encoding password", e);
      }
   }
}