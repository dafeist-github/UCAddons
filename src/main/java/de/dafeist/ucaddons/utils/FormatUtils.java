package de.dafeist.ucaddons.utils;

public class FormatUtils {
	public static String extractNumber(final String str) {                
	    
	    if(str == null || str.isEmpty()) return "";
	    
	    StringBuilder sb = new StringBuilder();
	    boolean found = false;
	    for(char c : str.toCharArray()){
	        if(Character.isDigit(c)){
	            sb.append(c);
	            found = true;
	        } else if(found){
	            break;                
	        }
	    }
	    
	    return sb.toString();
	}
}
