import PallindromeStringApp.PallindromeString;
import PallindromeStringApp.PallindromeStringHelper;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

public class Server {
    public static void main(String[] args) {
        try {
            // Create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // Get reference to RootPOA and activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Create servant and register it with the ORB
            PallindromeImpl palindromeImpl = new PallindromeImpl();

            // Get object reference from servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(palindromeImpl);
            PallindromeString href = PallindromeStringHelper.narrow(ref);

            // Get the naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Bind the object reference in naming
            String name = "Palindrome";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("Server ready and waiting...");

            // Wait for invocations from clients
            orb.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}