
package rodrigoservicecenter;


import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.views.LoginForm;

import java.sql.Connection;
import java.sql.SQLException;

public class RodrigoServiceCenter {

    
    public static void main(String[] args) {

        connect db = new connect();
        Connection con = db.createConnection();
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        LoginForm LoginForm1 = new LoginForm();
        LoginForm1.setVisible(true);
        LoginForm1.pack();
        LoginForm1.setLocationRelativeTo(null);
        
    }
    
}





