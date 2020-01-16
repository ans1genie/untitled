package me.aitbahaa.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.Permission;

public class CanYouAccess {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try{
            int num = 4;

            // Object o : Must be used to hold the reference of the instance of the class Solution.Inner.Private

            Object o;
            Constructor<Inner.Private> constructor = Inner.Private.class.getDeclaredConstructor(Inner.class);
            constructor.setAccessible(true);
            o= constructor.newInstance(new Inner()) ;

            Method powerof2 = ((Inner.Private )o).getClass().getDeclaredMethod("powerof2", int.class);
            powerof2.setAccessible(true);
            String res = (String) powerof2.invoke((Inner.Private )o,num);
            System.out.println(num +" is "+res);

            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }//end of try

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }//end of main
    static class Inner{
        private class Private{
            private String powerof2(int num){
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }//end of Inner

}//end of Solution

class DoNotTerminate { //This class prevents exit(0)

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}

