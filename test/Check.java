import java.sql.*;
public class Check
{
    static String pid,mid;
    String a,b;
    public static void main(String[] args) 
    {
        try
        { 
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comp_project","root","ankrish123");
          PreparedStatement psmt=con.prepareStatement("select * from module");
          ResultSet rs=psmt.executeQuery();
          while (rs.next()) 
          {
                mid=rs.getString(1);
                pid=rs.getString(7);     
                System.out.println("mid is"+mid);
                System.out.println("Pid is"+pid);
          }
        }
        catch(Exception e)
        {
          
        }
        
        
    }

    public Check(String a, String b) 
    {
        this.a = a;
        this.b = b;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comp_project","root","ankrish123");
            PreparedStatement psmt=con.prepareStatement("delete from module where mid=? and pid=?");
            psmt.setString(1, a);
            psmt.setString(2, b);
        
            if(a.equals(mid) && b.equals(pid))
            {
                psmt.executeUpdate();
            }
            else
                System.out.println("Cannot Delete");
        }
        catch(Exception e)
        {
            
        }
    }
}
