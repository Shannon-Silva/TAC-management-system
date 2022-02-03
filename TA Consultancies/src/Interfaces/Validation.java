/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Shadow Walker
 */
public class Validation {
    
    public static boolean validatemail(String email)
    {
     boolean result = true;
    
        try   
            {
             InternetAddress mailaddress = new InternetAddress(email);
             mailaddress.validate();
            }
     catch (AddressException ex)
            {
                result = false;
            }
        return result;
}
    public static boolean validatePhone(String phoneNumber)
    {
        boolean isValid = false;
        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        
        if(matcher.matches())
        {
            isValid = true;
        }
            return isValid;
    }
    
}
