package com.teja.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	public static boolean isValidEmail(String string){
		boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
	}
}
