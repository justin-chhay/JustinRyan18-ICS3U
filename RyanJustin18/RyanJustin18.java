/*
     Ryan Rambali and Justin Chhay
     Mr. Afsari-Nejad
     1-3-2020
     Program that creates and modify files.
     File Header will be called: RJ18
     Our unique file extension is called .abc
*/

import java.awt.*;
import hsa.Console;
import java.io.*;
import javax.swing.*;
import java.lang.*;

public class RyanJustin18
{
    Console c;

    int in;
    char choice;
    String fileName, line;

    public RyanJustin18 ()
    {
	c = new Console ("Ryan And Justin - Problem 18");
    }


    public static void main (String[] args)
    {
	RyanJustin18 a = new RyanJustin18 ();

	a.choice = '0';
	a.line = "";
	a.fileName = "Untitled.abc";

	while (true)
	{

	    if (a.choice == '0')
	    {
		a.title ();
		a.menu ();
	    }
	    else if (a.choice == '1')
	    {
		a.title ();
		a.new1 ();
	    }
	    else if (a.choice == '2')
	    {
		a.title ();
		a.open ();
	    }
	    else if (a.choice == '3')
	    {
		a.title ();
		a.display ();
	    }
	    else if (a.choice == '4')
	    {
		a.title ();
		a.modify ();
	    }
	    else if (a.choice == '5')
	    {
		a.title ();
		a.save ();
	    }
	    else if (a.choice == '6')
	    {
		a.title ();
		a.saveAs ();
	    }
	    else
	    {
		a.title ();
		a.goodbye ();
		break;
	    }
	}
	a.c.close ();
    }


    public void title ()
    {
	c.clear ();
	int x = 40 - (fileName.length () / 2);
	c.print ("", x);
	c.println (fileName);
    }


    public void goodbye ()
    {

	c.println ("Thank you for using the program!");
	c.println ("Press any key to close!");
	c.getChar ();
    }


    public void askData ()
    {
	c.print ("Please Enter Your Integer Value: ");
	try
	{
	    in = c.readInt ();
	}
	catch (Exception e)
	{
	    c.println ("Error! Please enter an integer value...");
	    c.print ("Please enter anything to continue...");
	    String q = c.readLine ();
	    title ();
	    askData ();
	}
	choice = '0';
    }


    public void new1 ()
    {
	int prompt = JOptionPane.showConfirmDialog (null, "Would you like to save your current data?");
	if (prompt == JOptionPane.YES_OPTION || prompt == JOptionPane.NO_OPTION)
	{
	    fileName = "Untitled.abc"; // rubric fileName (if not saved/opened)
	    if (prompt == JOptionPane.YES_OPTION)
	    {
		saveAs ();
	    }

	    askData ();
	}
	else if (prompt == JOptionPane.CANCEL_OPTION)
	{
	    c.println ("CANCELLED. Returning to main menu.");
	    c.print ("Please enter anything to continue...");
	    String q = c.readLine ();
	}

	choice = '0';
    }


    public void open ()
    {

	BufferedReader input;

	int g = JOptionPane.showConfirmDialog (null, "Would you like to save your current data?");
	if (g == JOptionPane.YES_OPTION)
	{
	    saveAs ();
	}
	else if (g == JOptionPane.CANCEL_OPTION)
	{
	    c.print ("Please enter anything to continue...");
	    String q = c.readLine ();
	    choice = '0';
	}
	else
	{
	    c.print ("Enter the file name: ");
	    fileName = c.readLine ();
	    title ();
	    try
	    {
		input = new BufferedReader (new FileReader (fileName));
		line = input.readLine ();
		if (line.equals ("RJ18") && (fileName.substring (fileName.length () - 4)).equals (".abc"))
		{
		    line = input.readLine ();
		    c.println (line);
		    in = Integer.parseInt (line);
		}
		else
		{
		    title ();
		    c.println ("Invalid File");
		    c.println ("Press any key to continue");
		    String q = c.readLine ();
		    choice = '0';
		}
		line = input.readLine ();
	    }
	    catch (Exception e)
	    {
	    }

	    c.println ("");
	    c.print ("Please enter anything to continue...");
	    String q = c.readLine ();
	    choice = '0';
	}
    }


    public void display ()
    {
	c.println ("The current value of the integer is: " + in);
	c.println ("Press any key to continue!");
	String q = c.readLine ();
	choice = '0';
    }


    public void display (int x)
    {
	c.println ("The current value of the integer is: " + in);
	c.println ("Press any key to continue!");
	String q = c.readLine ();
    }


    public void modify ()
    {
	display (5);
	askData ();
    }


    public void save ()
    {
	try
	{
	    PrintWriter output;
	    output = new PrintWriter (new FileWriter (fileName));

	    output.println ("RJ18");
	    output.println (in);

	    output.close ();
	}
	catch (Exception e)
	{
	}

	c.println ("File Saved");
	String q = c.readLine ();

	choice = '0';
    }


    public void saveAs ()
    {

	try
	{
	    PrintWriter output;

	    c.print ("What do you want to name the file?");
	    fileName = c.readLine ();

	    for (int i = 0 ; i < fileName.length () ; i++)
	    {
		if (fileName.charAt (i) == '<' || fileName.charAt (i) == '>' || fileName.charAt (i) == '"' || fileName.charAt (i) == '!' || fileName.charAt (i) == '/' || fileName.charAt (i) == '\\' || fileName.charAt (i) == '?' || fileName.charAt (i) == '*')
		{
		    c.println ("Please Enter Valid File Name");
		    String q = c.readLine ();
		    title ();
		    saveAs ();
		}
	    }
	    fileName = fileName.concat (".abc");
	    output = new PrintWriter (new FileWriter (fileName));

	    output.println ("RJ18");
	    output.println (in);

	    output.close ();
	}
	catch (Exception e)
	{
	}
	c.println ("File Saved");
	String q = c.readLine ();
	choice = '0';
    }


    public void menu ()
    {
	c.println ("Welcome to the file modifier program");
	c.println ("1. New");
	c.println ("2. Open");
	c.println ("3. Display");
	c.println ("4. Modify");
	c.println ("5. Save");
	c.println ("6. Save As");
	c.println ("ANY_OTHER_KEY. Quit");
	c.print ("Please Choose an option: ");
	choice = c.readChar ();
    }
}
