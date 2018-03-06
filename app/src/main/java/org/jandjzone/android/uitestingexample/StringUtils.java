package org.jandjzone.android.uitestingexample;

/**
 * <p>String utilities</p>
 * Created by Jason on 2018-03-05.
 */

public class StringUtils {
    /**
     * <p>Check if a string is blank</p>
     * <pre>
     *     null   :true
     *     ""     :true
     *     "   "  :false
     *     "aa"   :false
     * </pre>
     * @param str
     * @return
     */
    public static boolean isBlank(String str){
        return (str==null||str.length()==0)?true:false;
    }

    /**
     * <p>Check if a string is empty</p>
     * <pre>
     *     null   :true
     *     ""     :true
     *     "   "  :true
     *     "aa"   :false
     * </pre>
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if((str==null||str.length()==0))return true;

        if(str.trim().length() ==0 )return true;
        return false;
    }
}
