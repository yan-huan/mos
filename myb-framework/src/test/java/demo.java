import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.myb.framework.data.DataCommand;
import com.myb.framework.data.SqlParameter;

/**
 * Created by Administrator on 2016/1/29.
 */
public class demo {
    private static Logger logger = Logger.getLogger(demo.class);
    public static void main(String[] args)
    {
        if (logger.isDebugEnabled()) {
            logger.debug("This is debug message.");
        }
        if (logger.isInfoEnabled()) {
            logger.info("This is a info message.");
        }

        if (logger.isEnabledFor(Level.INFO)) {
            logger.warn("This is a warn message.");
        }
        if (logger.isEnabledFor(Level.ERROR)) {
            logger.error("This is a error message.....");
        }


        String sql="select * from table where id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add("id",1);
        DataCommand dataCommand=new DataCommand();
        dataCommand.executeList(sql,sqlParameter);
        return ;
    }
}
