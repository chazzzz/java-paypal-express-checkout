package util;

public class StringUtil {
	
	/**
	 * Checks if a given string is empty or null.
	 * 
	 * @param obj
	 * @return
	 */
    public static boolean isEmpty(String obj) {
    	if ((obj==null) || (obj.trim().length()==0))
    		return true;
    	else
    		return false;
    }
}
