package PallindromeStringApp;

/**
* PallindromeStringApp/PallindromeStringHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PallindromeString.idl
* Friday, 9 May, 2025 8:06:47 PM IST
*/

public final class PallindromeStringHolder implements org.omg.CORBA.portable.Streamable
{
  public PallindromeStringApp.PallindromeString value = null;

  public PallindromeStringHolder ()
  {
  }

  public PallindromeStringHolder (PallindromeStringApp.PallindromeString initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PallindromeStringApp.PallindromeStringHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PallindromeStringApp.PallindromeStringHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PallindromeStringApp.PallindromeStringHelper.type ();
  }

}
