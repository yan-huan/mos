package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.AbopenaccountMoneySz;
import com.myb.entity.pojo.mos.AbopenaccountMoneySzMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("abopenaccountMoneySzDao")
public class AbopenaccountMoneySzDao extends MySqlCommandBase
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
        return "abopenaccount_money_sz";
    }


    public int insert(AbopenaccountMoneySz abopenaccountMoneySz)
    {
        String sql="INSERT INTO "+getTableName()+" (xuhao,shengfen,chengshi,quyu,shangquan,xiaoshourenyuan,dianming,dingdandanhao,xingming,danshu,kaitonghaoma,jine,fukuanfangshi,shifoushiliansuodian,kaitongshijian,jiezhishijian,daozhangriqi,daozhangjine,shouxufei,hetonghao,beizhu,end)VALUES(@{xuhao},@{shengfen},@{chengshi},@{quyu},@{shangquan},@{xiaoshourenyuan},@{dianming},@{dingdandanhao},@{xingming},@{danshu},@{kaitonghaoma},@{jine},@{fukuanfangshi},@{shifoushiliansuodian},@{kaitongshijian},@{jiezhishijian},@{daozhangriqi},@{daozhangjine},@{shouxufei},@{hetonghao},@{beizhu},@{end})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneySzMapping.Xuhao, abopenaccountMoneySz.getXuhao());
        sqlParameter.add(AbopenaccountMoneySzMapping.Shengfen, abopenaccountMoneySz.getShengfen());
        sqlParameter.add(AbopenaccountMoneySzMapping.Chengshi, abopenaccountMoneySz.getChengshi());
        sqlParameter.add(AbopenaccountMoneySzMapping.Quyu, abopenaccountMoneySz.getQuyu());
        sqlParameter.add(AbopenaccountMoneySzMapping.Shangquan, abopenaccountMoneySz.getShangquan());
        sqlParameter.add(AbopenaccountMoneySzMapping.Xiaoshourenyuan, abopenaccountMoneySz.getXiaoshourenyuan());
        sqlParameter.add(AbopenaccountMoneySzMapping.Dianming, abopenaccountMoneySz.getDianming());
        sqlParameter.add(AbopenaccountMoneySzMapping.Dingdandanhao, abopenaccountMoneySz.getDingdandanhao());
        sqlParameter.add(AbopenaccountMoneySzMapping.Xingming, abopenaccountMoneySz.getXingming());
        sqlParameter.add(AbopenaccountMoneySzMapping.Danshu, abopenaccountMoneySz.getDanshu());
        sqlParameter.add(AbopenaccountMoneySzMapping.Kaitonghaoma, abopenaccountMoneySz.getKaitonghaoma());
        sqlParameter.add(AbopenaccountMoneySzMapping.Jine, abopenaccountMoneySz.getJine());
        sqlParameter.add(AbopenaccountMoneySzMapping.Fukuanfangshi, abopenaccountMoneySz.getFukuanfangshi());
        sqlParameter.add(AbopenaccountMoneySzMapping.Shifoushiliansuodian, abopenaccountMoneySz.getShifoushiliansuodian());
        sqlParameter.add(AbopenaccountMoneySzMapping.Kaitongshijian, abopenaccountMoneySz.getKaitongshijian());
        sqlParameter.add(AbopenaccountMoneySzMapping.Jiezhishijian, abopenaccountMoneySz.getJiezhishijian());
        sqlParameter.add(AbopenaccountMoneySzMapping.Daozhangriqi, abopenaccountMoneySz.getDaozhangriqi());
        sqlParameter.add(AbopenaccountMoneySzMapping.Daozhangjine, abopenaccountMoneySz.getDaozhangjine());
        sqlParameter.add(AbopenaccountMoneySzMapping.Shouxufei, abopenaccountMoneySz.getShouxufei());
        sqlParameter.add(AbopenaccountMoneySzMapping.Hetonghao, abopenaccountMoneySz.getHetonghao());
        sqlParameter.add(AbopenaccountMoneySzMapping.Beizhu, abopenaccountMoneySz.getBeizhu());
        sqlParameter.add(AbopenaccountMoneySzMapping.End, abopenaccountMoneySz.getEnd());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(AbopenaccountMoneySz abopenaccountMoneySz)
    {
        String sql="UPDATE "+getTableName()+" set shengfen=@{shengfen},chengshi=@{chengshi},quyu=@{quyu},shangquan=@{shangquan},xiaoshourenyuan=@{xiaoshourenyuan},dianming=@{dianming},dingdandanhao=@{dingdandanhao},xingming=@{xingming},danshu=@{danshu},kaitonghaoma=@{kaitonghaoma},jine=@{jine},fukuanfangshi=@{fukuanfangshi},shifoushiliansuodian=@{shifoushiliansuodian},kaitongshijian=@{kaitongshijian},jiezhishijian=@{jiezhishijian},daozhangriqi=@{daozhangriqi},daozhangjine=@{daozhangjine},shouxufei=@{shouxufei},hetonghao=@{hetonghao},beizhu=@{beizhu},end=@{end} WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneySzMapping.Xuhao, abopenaccountMoneySz.getXuhao());
        sqlParameter.add(AbopenaccountMoneySzMapping.Shengfen, abopenaccountMoneySz.getShengfen());
        sqlParameter.add(AbopenaccountMoneySzMapping.Chengshi, abopenaccountMoneySz.getChengshi());
        sqlParameter.add(AbopenaccountMoneySzMapping.Quyu, abopenaccountMoneySz.getQuyu());
        sqlParameter.add(AbopenaccountMoneySzMapping.Shangquan, abopenaccountMoneySz.getShangquan());
        sqlParameter.add(AbopenaccountMoneySzMapping.Xiaoshourenyuan, abopenaccountMoneySz.getXiaoshourenyuan());
        sqlParameter.add(AbopenaccountMoneySzMapping.Dianming, abopenaccountMoneySz.getDianming());
        sqlParameter.add(AbopenaccountMoneySzMapping.Dingdandanhao, abopenaccountMoneySz.getDingdandanhao());
        sqlParameter.add(AbopenaccountMoneySzMapping.Xingming, abopenaccountMoneySz.getXingming());
        sqlParameter.add(AbopenaccountMoneySzMapping.Danshu, abopenaccountMoneySz.getDanshu());
        sqlParameter.add(AbopenaccountMoneySzMapping.Kaitonghaoma, abopenaccountMoneySz.getKaitonghaoma());
        sqlParameter.add(AbopenaccountMoneySzMapping.Jine, abopenaccountMoneySz.getJine());
        sqlParameter.add(AbopenaccountMoneySzMapping.Fukuanfangshi, abopenaccountMoneySz.getFukuanfangshi());
        sqlParameter.add(AbopenaccountMoneySzMapping.Shifoushiliansuodian, abopenaccountMoneySz.getShifoushiliansuodian());
        sqlParameter.add(AbopenaccountMoneySzMapping.Kaitongshijian, abopenaccountMoneySz.getKaitongshijian());
        sqlParameter.add(AbopenaccountMoneySzMapping.Jiezhishijian, abopenaccountMoneySz.getJiezhishijian());
        sqlParameter.add(AbopenaccountMoneySzMapping.Daozhangriqi, abopenaccountMoneySz.getDaozhangriqi());
        sqlParameter.add(AbopenaccountMoneySzMapping.Daozhangjine, abopenaccountMoneySz.getDaozhangjine());
        sqlParameter.add(AbopenaccountMoneySzMapping.Shouxufei, abopenaccountMoneySz.getShouxufei());
        sqlParameter.add(AbopenaccountMoneySzMapping.Hetonghao, abopenaccountMoneySz.getHetonghao());
        sqlParameter.add(AbopenaccountMoneySzMapping.Beizhu, abopenaccountMoneySz.getBeizhu());
        sqlParameter.add(AbopenaccountMoneySzMapping.End, abopenaccountMoneySz.getEnd());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String xuhao)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneySzMapping.Xuhao,xuhao);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public AbopenaccountMoneySz searchByXuhao(java.lang.String xuhao)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneySzMapping.Xuhao,xuhao);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, AbopenaccountMoneySz.class);
    }
    public PagedList<AbopenaccountMoneySz> searchByPage(QueryCondition queryCondition) {
        PagedList<AbopenaccountMoneySz> pagedList=this.searchByPage(queryCondition, AbopenaccountMoneySz.class);
        return pagedList;
    }
    public List<AbopenaccountMoneySz> searchList(QueryParameter queryParameter) {
                List<AbopenaccountMoneySz> list=this.searchList(queryParameter, AbopenaccountMoneySz.class);
                    return list;
    }
}
