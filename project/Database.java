package Com.project;

import java.sql.Connection;
import java.sql.DriverManager;


public class Database {
	
	    protected Connection connection;
	    public Database()
	    {
	        try
	        {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineAssessment","root","saheer");
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        }
	    }
	}

