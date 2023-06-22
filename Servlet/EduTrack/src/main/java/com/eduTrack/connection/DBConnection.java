package com.eduTrack.connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import jakarta.servlet.ServletContext;

public final class DBConnection {

	private String dbURL;
	private String driver;
	private String schema;
	private String username;
	private String password;
	
	@Override
	public String toString() {
		return "DBConnection [dbURL=" + dbURL + ", \n driver=" + driver + ", \n  schema=" + schema + ", \n  username=" + username
				+ ", \n password=" + password + "]";
	}
	private void setDBCredentials (ServletContext context) {

        String propertiesFilePath = context.getRealPath("/WEB-INF/config.properties");
        Properties properties = new Properties();
        
        try {
            
        	properties.load(new FileInputStream(propertiesFilePath));
            
            this.dbURL = properties.getProperty("dbConnection.url");
            this.driver = properties.getProperty("dbConnection.driver");
            this.schema = properties.getProperty("dbConnection.schema");
            this.username = properties.getProperty("dbConnection.username");
            this.password = properties.getProperty("dbConnection.password");

        }catch (Exception e) {
        	e.getStackTrace();
        }

	}
	public static Connection getDBConnection(ServletContext context) throws Exception {

		DBConnection db = new DBConnection();
		db.setDBCredentials(context);
		Connection con = null;

			Class.forName(db.driver);	
			con = DriverManager.getConnection(db.dbURL+db.schema,db.username,db.password);

			if(con != null ) {
				System.out.println(
						
						  "\n ----------------------------------"
						+ "\n ----------------------------------"
						+ "\n ---- DB Connction Established ----"		  
						+ "\n ----------------------------------"
						+ "\n ----------------------------------"
				);
			}
		

		
		return con;
	}

}

//System.out.println("DBConnection [dbURL=" + db.dbURL + ", \n driver=" + db.driver + ", \n  schema=" + db.schema + ", \n  username=" + db.username
//+ ", \n password=" + db.password + "]");