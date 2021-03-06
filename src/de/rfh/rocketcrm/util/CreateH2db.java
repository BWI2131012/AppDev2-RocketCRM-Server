package de.rfh.rocketcrm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import de.rfh.rocketcrm.entity.DataSource;
import de.rfh.rocketcrm.entity.H2DataSource;

public class CreateH2db 
{

	public static void main(String[] args)
	{
		Connection myConnection = null;
		
		try {
			
			String dbURL = "jdbc:h2:tcp://localhost/C:/git/AppDev2-RocketCRM-Server/src/dbFolder/RocketCRM";	
			String driver = "org.h2.Driver";
			String user = "sa";
			String pwd = "";

			Class.forName(driver);
			myConnection = DriverManager.getConnection(dbURL, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if  (myConnection != null) 
		{
			try {
				createTable();
				deleteAllRecords();
				fillTable();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void createTable() throws Exception, SQLException
	{
		DataSource myDataSource = new H2DataSource();
		
		Connection myConnection = myDataSource.getConnection();
		if  (myConnection != null) 
		{
			String sql = "CREATE TABLE IF NOT EXISTS `kontakt` (" + 
						  "`cId` bigint PRIMARY KEY," +
						  "`cCrtDate` date," +
						  "`cCrtUser` varchar," +
						  "`cUpdtDate` date," +
						  "`cUpdtUser` varchar," +
						  "`cVName` varchar," +
						  "`cNName` varchar," +
						  "`cCompany` varchar," +
						  "`cCity` varchar," +
						  "`cBirthDay` date," +
						  "`cMail` varchar," +
						  "`cPhone` varchar," +
						  "`cVersion` bigint," +
						  ");";

			PreparedStatement myStatement = myConnection.prepareStatement(sql);
			myStatement.execute();
		}
	}
	
	private static void fillTable() throws Exception, SQLException
	{
		DataSource myDataSource = new H2DataSource();
		
		Connection myConnection = myDataSource.getConnection();
		if  (myConnection != null) 
		{
			String sql = "INSERT INTO `kontakt` (`cId`, `cCrtDate`, `cCrtUser`, `cUpdtDate`, `cUpdtUser`, `cVName`, `cNName`, `cCompany`, `cCity`, `cBirthDay`, `cMail`, `cPhone`, `cVersion`) VALUES" + 
						"(1, '2012-01-08', 'admin', '2012-01-08', 'admin', 'Barack', 'Obama', 'US State', 'Hawai', '1956-01-08', 'obama@care.gov', '0800666666', '1')," + 
						"(2, '2012-03-08', 'admin', '2013-11-07', 'user', 'Helmut', 'Schmidt', 'Kanzleramt', 'Kalk', '1945-01-08', 'schmidt@raucherkette.de', '0175632546', '1')," +
						"(3, '2014-03-08', 'admin', '2014-01-01', 'admin', 'Willi', 'Brandt', 'Kanzleramt', 'Brunsbuettel', '1914-01-08', 'deutschland@brandt.de', '02115469875', '1')," + 
						"(4, '2013-11-21', 'user', '2013-12-24', 'user', 'Helmut', 'Kohl', 'Kanzleramt', 'Rostock', '1948-01-08', 'schwarzkonto@kohl.de', '072365963', '1')," + 
						"(5, '2013-11-21', 'admin', '2012-05-09', 'admin', 'Balboa', 'Rocky', 'Box', 'Arena', '1980-01-08', 'rocky@adrian.com', '01025665998', '1')," + 
						"(6, '2013-11-21', 'user', '2012-08-08', 'admin', 'Bill', 'Clinton', 'US State', 'Hawana', '1961-01-08', 'clinton@practice.gov', '110', '1')," + 
						"(7, '2013-11-21', 'admin', '2014-02-08', 'admin', 'Georg W.', 'Bush', 'US State', 'Teheran', '1983-01-08', 'bush@standard-oil.gov', '112', '1')," + 
						"(8, '2013-11-21', 'admin', '2014-02-08', 'admin', 'Gustav', 'Heinemann', 'SAP', 'Waldorf', '1978-04-27', 'heinemann@sap.de', '06532566584', '1')," + 
						"(9, '2013-11-21', 'admin', '2014-02-08', 'admin', 'Peter', 'Silie', 'Salat GmbH', 'Beet', '1985-11-23', 'peter.silie@beet.de', '01253658965', '1')," + 
						"(10, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Klara', 'Korn', 'Bar&Co KG.', 'Bottrop', '1956-03-05', 'klara@korn.com', '0863256329', '1')," + 
						"(11, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Anne', 'Theke', 'Kneipen Tour AG', 'Gelsenkirchen', '1967-07-04', 'anne@kneipentour.de', '032648654', '1')," + 
						"(12, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Irmgard', 'Patton', 'Bayer AG', 'Wuppertal', '1988-09-26', 'i.patton@mail.xyz', '202 / 33331731', '1')," + 
						"(13, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Olaf', 'Hempel', 'Bayer AG', 'Leverkusen', '1967-01-13', 'o.hempel@mail.xyz', '0214 36598754', '1')," + 
						"(14, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Marvin', 'Deininger', 'IBM', 'New York', '1932-05-25', 'm.deininger@ibm.com', '0236590565564', '1')," + 
						"(15, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Reiner', 'Zufall', 'Lotto AG', 'Zugspitze', '1912-12-12', 'zufall@lotto.eu', '021212121', '1')," + 
						"(16, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Mohammed', 'Ali', 'NBO', 'Sacramento', '1935-04-03', 'ali@champion.net', '283473434', '1')," + 
						"(17, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Maria', 'Cron', 'Mumm', 'Oppenheim', '1977-05-03', 'maria@cron.de', '034287364', '1')," + 
						"(18, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Chuck', 'Norris', 'US State', 'Boston', '1956-04-23', 'chuck@norris.com', '054564564', '1')," + 
						"(19, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Bruce', 'Lee', 'US State', 'Boston', '1957-06-07', 'Bruce@Lee.com', '394839401', '1')," + 
						"(20, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Mahatma', 'Gandhi', 'Buckingham Palace', 'England', '1868-03-27', 'gandhi@westminster.gov', '049848', '1')," + 
						"(21, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Papst', 'Franziskus', 'Vatikan AG', 'Vatikan', '1936-09-17', 'papst@vatikan.gov', '666', '1')," + 
						"(22, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Angela', 'Merkel', 'Kanzleramt', 'Berlin', '1956-07-05', 'mutti@kanzleramt.de', '0123456789', '1')," + 
						"(23, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Wladimir', 'Putin', 'KGB AG', 'Moskau', '1956-06-06', 'putin@kgb.ru', '999', '1')," + 
						"(24, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Bill', 'Gates', 'Microsoft', 'Redmond', '1955-08-08', 'bill@millionclub.com', '0101101101010', '1')," + 
						"(25, '2014-07-09', 'admin', '2014-07-09', 'admin', 'Edward', 'Snowden', 'NSA', 'Moskau', '1983-09-11', 'Snowden@nsa.gov', '342890', '1');";

			PreparedStatement myStatement = myConnection.prepareStatement(sql);
			myStatement.execute();
		}

	}

	private static void deleteAllRecords() throws Exception, SQLException
	{
		DataSource myDataSource = new H2DataSource();
		
		Connection myConnection = myDataSource.getConnection();
		if  (myConnection != null) 
		{
			String sql ="DELETE FROM Kontakt";
			PreparedStatement myStatement = myConnection.prepareStatement(sql);
			myStatement.execute();
		}
	}
}
