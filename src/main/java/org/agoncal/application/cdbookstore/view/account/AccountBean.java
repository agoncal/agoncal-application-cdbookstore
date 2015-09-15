package org.agoncal.application.cdbookstore.view.account;

import org.agoncal.application.cdbookstore.model.User;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class AccountBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   // Logged user
   private User user = new User();

   private boolean loggedIn;

   private boolean admin;

   private boolean rememberMe;

   private String password1;

   private String password2;

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public boolean isLoggedIn()
   {
      return loggedIn;
   }

   public void setLoggedIn(boolean loggedIn)
   {
      this.loggedIn = loggedIn;
   }

   public boolean isAdmin()
   {
      return admin;
   }

   public void setAdmin(boolean admin)
   {
      this.admin = admin;
   }

   public boolean isRememberMe()
   {
      return rememberMe;
   }

   public void setRememberMe(boolean rememberMe)
   {
      this.rememberMe = rememberMe;
   }

   public String getPassword1()
   {
      return password1;
   }

   public void setPassword1(String password1)
   {
      this.password1 = password1;
   }

   public String getPassword2()
   {
      return password2;
   }

   public void setPassword2(String password2)
   {
      this.password2 = password2;
   }
}