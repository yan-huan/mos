package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.AbopenaccountMoneyHz;
import com.myb.entity.pojo.mos.AbopenaccountMoneyHzMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("abopenaccountMoneyHzDao")
public class AbopenaccountMoneyHzDao extends MySqlCommandBase
{

	@Resource(name = "datacommand_write")
    private DataCommand dataCommandWrite;
    
    @Resource(name = "datacommand_read")
    private DataCommand dataCommandRead;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommandWrite);
    }
    @Override
    public String getTableName()
    {
        return "abopenaccount_money_hz";
    }


    public int insert(AbopenaccountMoneyHz abopenaccountMoneyHz)
    {
        String sql="INSERT INTO "+getTableName()+" (xuhao,shengfen,chengshi,quyu,shangquan,xiaoshourenyuan,dianming,dingdandanhao,xingming,danshu,kaitonghaoma,jine,fukuanfangshi,shifoushiliansuodian,kaitongshijian,jiezhishijian,daoqiriqi,daozhangjine,shouxufei,hetonghao,beizhu)VALUES(@{xuhao},@{shengfen},@{chengshi},@{quyu},@{shangquan},@{xiaoshourenyuan},@{dianming},@{dingdandanhao},@{xingming},@{danshu},@{kaitonghaoma},@{jine},@{fukuanfangshi},@{shifoushiliansuodian},@{kaitongshijian},@{jiezhishijian},@{daoqiriqi},@{daozhangjine},@{shouxufei},@{hetonghao},@{beizhu})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyHzMapping.Xuhao, abopenaccountMoneyHz.getXuhao());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Shengfen, abopenaccountMoneyHz.getShengfen());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Chengshi, abopenaccountMoneyHz.getChengshi());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Quyu, abopenaccountMoneyHz.getQuyu());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Shangquan, abopenaccountMoneyHz.getShangquan());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Xiaoshourenyuan, abopenaccountMoneyHz.getXiaoshourenyuan());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Dianming, abopenaccountMoneyHz.getDianming());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Dingdandanhao, abopenaccountMoneyHz.getDingdandanhao());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Xingming, abopenaccountMoneyHz.getXingming());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Danshu, abopenaccountMoneyHz.getDanshu());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Kaitonghaoma, abopenaccountMoneyHz.getKaitonghaoma());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Jine, abopenaccountMoneyHz.getJine());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Fukuanfangshi, abopenaccountMoneyHz.getFukuanfangshi());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Shifoushiliansuodian, abopenaccountMoneyHz.getShifoushiliansuodian());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Kaitongshijian, abopenaccountMoneyHz.getKaitongshijian());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Jiezhishijian, abopenaccountMoneyHz.getJiezhishijian());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Daoqiriqi, abopenaccountMoneyHz.getDaoqiriqi());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Daozhangjine, abopenaccountMoneyHz.getDaozhangjine());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Shouxufei, abopenaccountMoneyHz.getShouxufei());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Hetonghao, abopenaccountMoneyHz.getHetonghao());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Beizhu, abopenaccountMoneyHz.getBeizhu());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(AbopenaccountMoneyHz abopenaccountMoneyHz)
    {
        String sql="UPDATE "+getTableName()+" set shengfen=@{shengfen},chengshi=@{chengshi},quyu=@{quyu},shangquan=@{shangquan},xiaoshourenyuan=@{xiaoshourenyuan},dianming=@{dianming},dingdandanhao=@{dingdandanhao},xingming=@{xingming},danshu=@{danshu},kaitonghaoma=@{kaitonghaoma},jine=@{jine},fukuanfangshi=@{fukuanfangshi},shifoushiliansuodian=@{shifoushiliansuodian},kaitongshijian=@{kaitongshijian},jiezhishijian=@{jiezhishijian},daoqiriqi=@{daoqiriqi},daozhangjine=@{daozhangjine},shouxufei=@{shouxufei},hetonghao=@{hetonghao},beizhu=@{beizhu} WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyHzMapping.Xuhao, abopenaccountMoneyHz.getXuhao());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Shengfen, abopenaccountMoneyHz.getShengfen());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Chengshi, abopenaccountMoneyHz.getChengshi());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Quyu, abopenaccountMoneyHz.getQuyu());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Shangquan, abopenaccountMoneyHz.getShangquan());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Xiaoshourenyuan, abopenaccountMoneyHz.getXiaoshourenyuan());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Dianming, abopenaccountMoneyHz.getDianming());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Dingdandanhao, abopenaccountMoneyHz.getDingdandanhao());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Xingming, abopenaccountMoneyHz.getXingming());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Danshu, abopenaccountMoneyHz.getDanshu());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Kaitonghaoma, abopenaccountMoneyHz.getKaitonghaoma());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Jine, abopenaccountMoneyHz.getJine());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Fukuanfangshi, abopenaccountMoneyHz.getFukuanfangshi());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Shifoushiliansuodian, abopenaccountMoneyHz.getShifoushiliansuodian());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Kaitongshijian, abopenaccountMoneyHz.getKaitongshijian());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Jiezhishijian, abopenaccountMoneyHz.getJiezhishijian());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Daoqiriqi, abopenaccountMoneyHz.getDaoqiriqi());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Daozhangjine, abopenaccountMoneyHz.getDaozhangjine());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Shouxufei, abopenaccountMoneyHz.getShouxufei());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Hetonghao, abopenaccountMoneyHz.getHetonghao());
        sqlParameter.add(AbopenaccountMoneyHzMapping.Beizhu, abopenaccountMoneyHz.getBeizhu());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String xuhao)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyHzMapping.Xuhao,xuhao);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public AbopenaccountMoneyHz searchByXuhao(java.lang.String xuhao)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyHzMapping.Xuhao,xuhao);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, AbopenaccountMoneyHz.class);
    }
    public PagedList<AbopenaccountMoneyHz> searchByPage(QueryCondition queryCondition) {
        PagedList<AbopenaccountMoneyHz> pagedList=this.searchByPage(queryCondition, AbopenaccountMoneyHz.class);
        return pagedList;
    }
    public List<AbopenaccountMoneyHz> searchList(QueryParameter queryParameter) {
                List<AbopenaccountMoneyHz> list=this.searchList(queryParameter, AbopenaccountMoneyHz.class);
                    return list;
    }
}
