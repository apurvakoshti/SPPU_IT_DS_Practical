import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {
    private static final long serialVersionUID = 1L;
    private final ExecutorService executor;

    public ServerImpl() throws RemoteException {
        super();
        executor = Executors.newFixedThreadPool(5); // 5 Threads in the Pool
    }

    @Override
    public int addition(int a, int b) throws RemoteException {
        executor.execute(() -> System.out.println("Processing addition in " + Thread.currentThread().getName()));
        return a + b;
    }

    @Override
    public int subtraction(int a, int b) throws RemoteException {
        executor.execute(() -> System.out.println("Processing subtraction in " + Thread.currentThread().getName()));
        return a - b;
    }

    @Override
    public int multiplication(int a, int b) throws RemoteException {
        executor.execute(() -> System.out.println("Processing multiplication in " + Thread.currentThread().getName()));
        return a * b;
    }

    @Override
    public int division(int a, int b) throws RemoteException {
        executor.execute(() -> System.out.println("Processing division in " + Thread.currentThread().getName()));
        if (b == 0) throw new ArithmeticException("Division by zero!");
        return a / b;
    }

    @Override
    public int square(int a) throws RemoteException {
        executor.execute(() -> System.out.println("Processing square in " + Thread.currentThread().getName()));
        return a * a;
    }

    @Override
    public int squareroot(int a) throws RemoteException {
        executor.execute(() -> System.out.println("Processing square root in " + Thread.currentThread().getName()));
        return (int) Math.sqrt(a);
    }

    @Override
    public boolean isPalindrome(String str) throws RemoteException {
        executor.execute(() -> System.out.println("Processing palindrome in " + Thread.currentThread().getName()));
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    @Override
    public boolean isEqualString(String str1, String str2) throws RemoteException {
        executor.execute(() -> System.out.println("Processing string comparison in " + Thread.currentThread().getName()));
        return str1.equals(str2);
    }

     @Override
    public List<Integer> fibonacci(int n) throws RemoteException {
        executor.execute(() -> System.out.println("Processing Fibonacci in " + Thread.currentThread().getName()));
        
        List<Integer> fibList = new ArrayList<>();
        if (n <= 0) return fibList;
        
        fibList.add(0);
        if (n > 1) fibList.add(1);
        
        for (int i = 2; i < n; i++) {
            fibList.add(fibList.get(i - 1) + fibList.get(i - 2));
        }
        
        return fibList;
    }
}
