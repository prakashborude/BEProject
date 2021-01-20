package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class GMailAuthenticator extends Authenticator {
     String user;
     String pw;
     public GMailAuthenticator (String username, String password)
     {
        super();
        this.user = username; //or username pb changes
        this.pw = password;						// or password pb changes
     }
    public PasswordAuthentication getPasswordAuthentication()
    {
       return new PasswordAuthentication(user, pw);
    }
}