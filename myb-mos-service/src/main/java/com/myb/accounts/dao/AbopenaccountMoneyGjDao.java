package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.AbopenaccountMoneyGj;
import com.myb.entity.pojo.mos.AbopenaccountMoneyGjMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("abopenaccountMoneyGjDao")
public class AbopenaccountMoneyGjDao extends MySqlCommandBase
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
        return "abopenaccount_money_gj";
    }


    public int insert(AbopenaccountMoneyGj abopenaccountMoneyGj)
    {
        String sql="INSERT INTO "+getTableName()+" (xuhao,shengfen,chengshi,quyu,shangquan,xiaoshourenyuan,dianming,dingdandanhao,xingming,danshu,kaitonghaoma,jine,fukuanfangshi,shifouliansuodian,kaitongshijian,jiezhishijian,daozhangriqi,daozhangjine,shouxufei,hetonghao,beizhu,F22,F23,F24,F25,F26)VALUES(@{xuhao},@{shengfen},@{chengshi},@{quyu},@{shangquan},@{xiaoshourenyuan},@{dianming},@{dingdandanhao},@{xingming},@{danshu},@{kaitonghaoma},@{jine},@{fukuanfangshi},@{shifouliansuodian},@{kaitongshijian},@{jiezhishijian},@{daozhangriqi},@{daozhangjine},@{shouxufei},@{hetonghao},@{beizhu},@{F22},@{F23},@{F24},@{F25},@{F26})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyGjMapping.Xuhao, abopenaccountMoneyGj.getXuhao());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Shengfen, abopenaccountMoneyGj.getShengfen());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Chengshi, abopenaccountMoneyGj.getChengshi());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Quyu, abopenaccountMoneyGj.getQuyu());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Shangquan, abopenaccountMoneyGj.getShangquan());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Xiaoshourenyuan, abopenaccountMoneyGj.getXiaoshourenyuan());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Dianming, abopenaccountMoneyGj.getDianming());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Dingdandanhao, abopenaccountMoneyGj.getDingdandanhao());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Xingming, abopenaccountMoneyGj.getXingming());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Danshu, abopenaccountMoneyGj.getDanshu());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Kaitonghaoma, abopenaccountMoneyGj.getKaitonghaoma());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Jine, abopenaccountMoneyGj.getJine());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Fukuanfangshi, abopenaccountMoneyGj.getFukuanfangshi());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Shifouliansuodian, abopenaccountMoneyGj.getShifouliansuodian());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Kaitongshijian, abopenaccountMoneyGj.getKaitongshijian());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Jiezhishijian, abopenaccountMoneyGj.getJiezhishijian());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Daozhangriqi, abopenaccountMoneyGj.getDaozhangriqi());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Daozhangjine, abopenaccountMoneyGj.getDaozhangjine());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Shouxufei, abopenaccountMoneyGj.getShouxufei());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Hetonghao, abopenaccountMoneyGj.getHetonghao());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Beizhu, abopenaccountMoneyGj.getBeizhu());
        sqlParameter.add(AbopenaccountMoneyGjMapping.F22, abopenaccountMoneyGj.getF22());
        sqlParameter.add(AbopenaccountMoneyGjMapping.F23, abopenaccountMoneyGj.getF23());
        sqlParameter.add(AbopenaccountMoneyGjMapping.F24, abopenaccountMoneyGj.getF24());
        sqlParameter.add(AbopenaccountMoneyGjMapping.F25, abopenaccountMoneyGj.getF25());
        sqlParameter.add(AbopenaccountMoneyGjMapping.F26, abopenaccountMoneyGj.getF26());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(AbopenaccountMoneyGj abopenaccountMoneyGj)
    {
        String sql="UPDATE "+getTableName()+" set shengfen=@{shengfen},chengshi=@{chengshi},quyu=@{quyu},shangquan=@{shangquan},xiaoshourenyuan=@{xiaoshourenyuan},dianming=@{dianming},dingdandanhao=@{dingdandanhao},xingming=@{xingming},danshu=@{danshu},kaitonghaoma=@{kaitonghaoma},jine=@{jine},fukuanfangshi=@{fukuanfangshi},shifouliansuodian=@{shifouliansuodian},kaitongshijian=@{kaitongshijian},jiezhishijian=@{jiezhishijian},daozhangriqi=@{daozhangriqi},daozhangjine=@{daozhangjine},shouxufei=@{shouxufei},hetonghao=@{hetonghao},beizhu=@{beizhu},F22=@{F22},F23=@{F23},F24=@{F24},F25=@{F25},F26=@{F26} WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyGjMapping.Xuhao, abopenaccountMoneyGj.getXuhao());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Shengfen, abopenaccountMoneyGj.getShengfen());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Chengshi, abopenaccountMoneyGj.getChengshi());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Quyu, abopenaccountMoneyGj.getQuyu());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Shangquan, abopenaccountMoneyGj.getShangquan());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Xiaoshourenyuan, abopenaccountMoneyGj.getXiaoshourenyuan());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Dianming, abopenaccountMoneyGj.getDianming());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Dingdandanhao, abopenaccountMoneyGj.getDingdandanhao());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Xingming, abopenaccountMoneyGj.getXingming());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Danshu, abopenaccountMoneyGj.getDanshu());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Kaitonghaoma, abopenaccountMoneyGj.getKaitonghaoma());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Jine, abopenaccountMoneyGj.getJine());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Fukuanfangshi, abopenaccountMoneyGj.getFukuanfangshi());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Shifouliansuodian, abopenaccountMoneyGj.getShifouliansuodian());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Kaitongshijian, abopenaccountMoneyGj.getKaitongshijian());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Jiezhishijian, abopenaccountMoneyGj.getJiezhishijian());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Daozhangriqi, abopenaccountMoneyGj.getDaozhangriqi());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Daozhangjine, abopenaccountMoneyGj.getDaozhangjine());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Shouxufei, abopenaccountMoneyGj.getShouxufei());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Hetonghao, abopenaccountMoneyGj.getHetonghao());
        sqlParameter.add(AbopenaccountMoneyGjMapping.Beizhu, abopenaccountMoneyGj.getBeizhu());
        sqlParameter.add(AbopenaccountMoneyGjMapping.F22, abopenaccountMoneyGj.getF22());
        sqlParameter.add(AbopenaccountMoneyGjMapping.F23, abopenaccountMoneyGj.getF23());
        sqlParameter.add(AbopenaccountMoneyGjMapping.F24, abopenaccountMoneyGj.getF24());
        sqlParameter.add(AbopenaccountMoneyGjMapping.F25, abopenaccountMoneyGj.getF25());
        sqlParameter.add(AbopenaccountMoneyGjMapping.F26, abopenaccountMoneyGj.getF26());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String xuhao)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyGjMapping.Xuhao,xuhao);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public AbopenaccountMoneyGj searchByXuhao(java.lang.String xuhao)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyGjMapping.Xuhao,xuhao);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, AbopenaccountMoneyGj.class);
    }
    public PagedList<AbopenaccountMoneyGj> searchByPage(QueryCondition queryCondition) {
        PagedList<AbopenaccountMoneyGj> pagedList=this.searchByPage(queryCondition, AbopenaccountMoneyGj.class);
        return pagedList;
    }
    public List<AbopenaccountMoneyGj> searchList(QueryParameter queryParameter) {
                List<AbopenaccountMoneyGj> list=this.searchList(queryParameter, AbopenaccountMoneyGj.class);
                    return list;
    }
}
