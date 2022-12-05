package site_drug_request.drug_request_interface_adapters;
import java.sql.*;
//import java.sql.Connection;

public class DrugRequestDBConnection {
        Connection con;
        DrugRequestDBConnection(){
            try{
                Class.forName("oracle.jbdc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thi://@localhost:");
            } catch(Exception e){

            }
        }
}
