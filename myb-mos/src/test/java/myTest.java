/**
 * Created by ZhangLun on 2016/9/19.
 */
import com.myb.accounts.service.OpenAccountService;
import com.myb.entity.pojo.mos.OpenAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;


/**
 * @author Rainisic
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application_context.xml")
public class myTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private OpenAccountService openAccountService;

    @Test
    public void saveTest() {
        OpenAccount openAccount = openAccountService.searchByAccountId(1221);
        openAccount.setFinanceSuccessDate(new Date());
        int update = openAccountService.update(openAccount);
        System.out.print(update);
    }
}
