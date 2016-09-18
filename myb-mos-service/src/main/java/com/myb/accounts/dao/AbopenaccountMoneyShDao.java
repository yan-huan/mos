package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.AbopenaccountMoneySh;
import com.myb.entity.pojo.mos.AbopenaccountMoneyShMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("abopenaccountMoneyShDao")
public class AbopenaccountMoneyShDao extends MySqlCommandBase
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
        return "abopenaccount_money_sh";
    }


    public int insert(AbopenaccountMoneySh abopenaccountMoneySh)
    {
        String sql="INSERT INTO "+getTableName()+" (xuhao,shengfen,chengshi,quyu,shangquan,xiaoshourenyuan,dianming,dingdandanhao,xingming,kaitonghaoma,danshu,jine,fukuanfangshi,shifoushiliansuodian,kaitongshijian,jiezhishijian,daozhangriqi,daozhangjine,shouxufei,hetonghao,beizu,end)VALUES(@{xuhao},@{shengfen},@{chengshi},@{quyu},@{shangquan},@{xiaoshourenyuan},@{dianming},@{dingdandanhao},@{xingming},@{kaitonghaoma},@{danshu},@{jine},@{fukuanfangshi},@{shifoushiliansuodian},@{kaitongshijian},@{jiezhishijian},@{daozhangriqi},@{daozhangjine},@{shouxufei},@{hetonghao},@{beizu},@{end})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyShMapping.Xuhao, abopenaccountMoneySh.getXuhao());
        sqlParameter.add(AbopenaccountMoneyShMapping.Shengfen, abopenaccountMoneySh.getShengfen());
        sqlParameter.add(AbopenaccountMoneyShMapping.Chengshi, abopenaccountMoneySh.getChengshi());
        sqlParameter.add(AbopenaccountMoneyShMapping.Quyu, abopenaccountMoneySh.getQuyu());
        sqlParameter.add(AbopenaccountMoneyShMapping.Shangquan, abopenaccountMoneySh.getShangquan());
        sqlParameter.add(AbopenaccountMoneyShMapping.Xiaoshourenyuan, abopenaccountMoneySh.getXiaoshourenyuan());
        sqlParameter.add(AbopenaccountMoneyShMapping.Dianming, abopenaccountMoneySh.getDianming());
        sqlParameter.add(AbopenaccountMoneyShMapping.Dingdandanhao, abopenaccountMoneySh.getDingdandanhao());
        sqlParameter.add(AbopenaccountMoneyShMapping.Xingming, abopenaccountMoneySh.getXingming());
        sqlParameter.add(AbopenaccountMoneyShMapping.Kaitonghaoma, abopenaccountMoneySh.getKaitonghaoma());
        sqlParameter.add(AbopenaccountMoneyShMapping.Danshu, abopenaccountMoneySh.getDanshu());
        sqlParameter.add(AbopenaccountMoneyShMapping.Jine, abopenaccountMoneySh.getJine());
        sqlParameter.add(AbopenaccountMoneyShMapping.Fukuanfangshi, abopenaccountMoneySh.getFukuanfangshi());
        sqlParameter.add(AbopenaccountMoneyShMapping.Shifoushiliansuodian, abopenaccountMoneySh.getShifoushiliansuodian());
        sqlParameter.add(AbopenaccountMoneyShMapping.Kaitongshijian, abopenaccountMoneySh.getKaitongshijian());
        sqlParameter.add(AbopenaccountMoneyShMapping.Jiezhishijian, abopenaccountMoneySh.getJiezhishijian());
        sqlParameter.add(AbopenaccountMoneyShMapping.Daozhangriqi, abopenaccountMoneySh.getDaozhangriqi());
        sqlParameter.add(AbopenaccountMoneyShMapping.Daozhangjine, abopenaccountMoneySh.getDaozhangjine());
        sqlParameter.add(AbopenaccountMoneyShMapping.Shouxufei, abopenaccountMoneySh.getShouxufei());
        sqlParameter.add(AbopenaccountMoneyShMapping.Hetonghao, abopenaccountMoneySh.getHetonghao());
        sqlParameter.add(AbopenaccountMoneyShMapping.Beizu, abopenaccountMoneySh.getBeizu());
        sqlParameter.add(AbopenaccountMoneyShMapping.End, abopenaccountMoneySh.getEnd());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(AbopenaccountMoneySh abopenaccountMoneySh)
    {
        String sql="UPDATE "+getTableName()+" set shengfen=@{shengfen},chengshi=@{chengshi},quyu=@{quyu},shangquan=@{shangquan},xiaoshourenyuan=@{xiaoshourenyuan},dianming=@{dianming},dingdandanhao=@{dingdandanhao},xingming=@{xingming},kaitonghaoma=@{kaitonghaoma},danshu=@{danshu},jine=@{jine},fukuanfangshi=@{fukuanfangshi},shifoushiliansuodian=@{shifoushiliansuodian},kaitongshijian=@{kaitongshijian},jiezhishijian=@{jiezhishijian},daozhangriqi=@{daozhangriqi},daozhangjine=@{daozhangjine},shouxufei=@{shouxufei},hetonghao=@{hetonghao},beizu=@{beizu},end=@{end} WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyShMapping.Xuhao, abopenaccountMoneySh.getXuhao());
        sqlParameter.add(AbopenaccountMoneyShMapping.Shengfen, abopenaccountMoneySh.getShengfen());
        sqlParameter.add(AbopenaccountMoneyShMapping.Chengshi, abopenaccountMoneySh.getChengshi());
        sqlParameter.add(AbopenaccountMoneyShMapping.Quyu, abopenaccountMoneySh.getQuyu());
        sqlParameter.add(AbopenaccountMoneyShMapping.Shangquan, abopenaccountMoneySh.getShangquan());
        sqlParameter.add(AbopenaccountMoneyShMapping.Xiaoshourenyuan, abopenaccountMoneySh.getXiaoshourenyuan());
        sqlParameter.add(AbopenaccountMoneyShMapping.Dianming, abopenaccountMoneySh.getDianming());
        sqlParameter.add(AbopenaccountMoneyShMapping.Dingdandanhao, abopenaccountMoneySh.getDingdandanhao());
        sqlParameter.add(AbopenaccountMoneyShMapping.Xingming, abopenaccountMoneySh.getXingming());
        sqlParameter.add(AbopenaccountMoneyShMapping.Kaitonghaoma, abopenaccountMoneySh.getKaitonghaoma());
        sqlParameter.add(AbopenaccountMoneyShMapping.Danshu, abopenaccountMoneySh.getDanshu());
        sqlParameter.add(AbopenaccountMoneyShMapping.Jine, abopenaccountMoneySh.getJine());
        sqlParameter.add(AbopenaccountMoneyShMapping.Fukuanfangshi, abopenaccountMoneySh.getFukuanfangshi());
        sqlParameter.add(AbopenaccountMoneyShMapping.Shifoushiliansuodian, abopenaccountMoneySh.getShifoushiliansuodian());
        sqlParameter.add(AbopenaccountMoneyShMapping.Kaitongshijian, abopenaccountMoneySh.getKaitongshijian());
        sqlParameter.add(AbopenaccountMoneyShMapping.Jiezhishijian, abopenaccountMoneySh.getJiezhishijian());
        sqlParameter.add(AbopenaccountMoneyShMapping.Daozhangriqi, abopenaccountMoneySh.getDaozhangriqi());
        sqlParameter.add(AbopenaccountMoneyShMapping.Daozhangjine, abopenaccountMoneySh.getDaozhangjine());
        sqlParameter.add(AbopenaccountMoneyShMapping.Shouxufei, abopenaccountMoneySh.getShouxufei());
        sqlParameter.add(AbopenaccountMoneyShMapping.Hetonghao, abopenaccountMoneySh.getHetonghao());
        sqlParameter.add(AbopenaccountMoneyShMapping.Beizu, abopenaccountMoneySh.getBeizu());
        sqlParameter.add(AbopenaccountMoneyShMapping.End, abopenaccountMoneySh.getEnd());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String xuhao)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyShMapping.Xuhao,xuhao);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public AbopenaccountMoneySh searchByXuhao(java.lang.String xuhao)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyShMapping.Xuhao,xuhao);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, AbopenaccountMoneySh.class);
    }
    public PagedList<AbopenaccountMoneySh> searchByPage(QueryCondition queryCondition) {
        PagedList<AbopenaccountMoneySh> pagedList=this.searchByPage(queryCondition, AbopenaccountMoneySh.class);
        return pagedList;
    }
    public List<AbopenaccountMoneySh> searchList(QueryParameter queryParameter) {
                List<AbopenaccountMoneySh> list=this.searchList(queryParameter, AbopenaccountMoneySh.class);
                    return list;
    }
}
