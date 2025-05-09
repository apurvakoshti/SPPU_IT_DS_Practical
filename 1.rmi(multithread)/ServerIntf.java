import java.rmi.*;
import java.util.List;

public interface ServerIntf extends Remote {
    int addition(int a, int b) throws RemoteException;
    int subtraction(int a, int b) throws RemoteException;
    int division(int a, int b) throws RemoteException;
    int multiplication(int a, int b) throws RemoteException;
    int square(int a) throws RemoteException;
    int squareroot(int a) throws RemoteException;
    boolean isPalindrome(String str) throws RemoteException;
    boolean isEqualString(String str1, String str2) throws RemoteException;
     List<Integer> fibonacci(int n) throws RemoteException;
}
// in intellij, make rmi as folder and in src the folder, add all the files by deleting the main file.
//for running these commands. go to cd src and then run
// rmiregistry -version
//step 1 : javac *.java
//step 2: start rmiregistry
// step 3: java Server
// step 4: java Client