package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.AbopenaccountMoneyBj;
import com.myb.entity.pojo.mos.AbopenaccountMoneyBjMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("abopenaccountMoneyBjDao")
public class AbopenaccountMoneyBjDao extends MySqlCommandBase
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
        return "abopenaccount_money_bj";
    }


    public int insert(AbopenaccountMoneyBj abopenaccountMoneyBj)
    {
        String sql="INSERT INTO "+getTableName()+" (xuhao,shengfen,chengshi,quyu,shangquan,xiaoshourenyuan,dianming,dingdandanhao,xingming,danshu,kaitonghaoma,jine,fukuanfangshi,shifouliansuodian,kaitongshijian,jiezhishijian,daozhangriqi,daozhangjine,shouxufei,hetonghao,beizhu,F22)VALUES(@{xuhao},@{shengfen},@{chengshi},@{quyu},@{shangquan},@{xiaoshourenyuan},@{dianming},@{dingdandanhao},@{xingming},@{danshu},@{kaitonghaoma},@{jine},@{fukuanfangshi},@{shifouliansuodian},@{kaitongshijian},@{jiezhishijian},@{daozhangriqi},@{daozhangjine},@{shouxufei},@{hetonghao},@{beizhu},@{F22})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyBjMapping.Xuhao, abopenaccountMoneyBj.getXuhao());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Shengfen, abopenaccountMoneyBj.getShengfen());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Chengshi, abopenaccountMoneyBj.getChengshi());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Quyu, abopenaccountMoneyBj.getQuyu());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Shangquan, abopenaccountMoneyBj.getShangquan());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Xiaoshourenyuan, abopenaccountMoneyBj.getXiaoshourenyuan());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Dianming, abopenaccountMoneyBj.getDianming());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Dingdandanhao, abopenaccountMoneyBj.getDingdandanhao());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Xingming, abopenaccountMoneyBj.getXingming());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Danshu, abopenaccountMoneyBj.getDanshu());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Kaitonghaoma, abopenaccountMoneyBj.getKaitonghaoma());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Jine, abopenaccountMoneyBj.getJine());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Fukuanfangshi, abopenaccountMoneyBj.getFukuanfangshi());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Shifouliansuodian, abopenaccountMoneyBj.getShifouliansuodian());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Kaitongshijian, abopenaccountMoneyBj.getKaitongshijian());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Jiezhishijian, abopenaccountMoneyBj.getJiezhishijian());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Daozhangriqi, abopenaccountMoneyBj.getDaozhangriqi());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Daozhangjine, abopenaccountMoneyBj.getDaozhangjine());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Shouxufei, abopenaccountMoneyBj.getShouxufei());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Hetonghao, abopenaccountMoneyBj.getHetonghao());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Beizhu, abopenaccountMoneyBj.getBeizhu());
        sqlParameter.add(AbopenaccountMoneyBjMapping.F22, abopenaccountMoneyBj.getF22());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(AbopenaccountMoneyBj abopenaccountMoneyBj)
    {
        String sql="UPDATE "+getTableName()+" set shengfen=@{shengfen},chengshi=@{chengshi},quyu=@{quyu},shangquan=@{shangquan},xiaoshourenyuan=@{xiaoshourenyuan},dianming=@{dianming},dingdandanhao=@{dingdandanhao},xingming=@{xingming},danshu=@{danshu},kaitonghaoma=@{kaitonghaoma},jine=@{jine},fukuanfangshi=@{fukuanfangshi},shifouliansuodian=@{shifouliansuodian},kaitongshijian=@{kaitongshijian},jiezhishijian=@{jiezhishijian},daozhangriqi=@{daozhangriqi},daozhangjine=@{daozhangjine},shouxufei=@{shouxufei},hetonghao=@{hetonghao},beizhu=@{beizhu},F22=@{F22} WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyBjMapping.Xuhao, abopenaccountMoneyBj.getXuhao());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Shengfen, abopenaccountMoneyBj.getShengfen());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Chengshi, abopenaccountMoneyBj.getChengshi());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Quyu, abopenaccountMoneyBj.getQuyu());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Shangquan, abopenaccountMoneyBj.getShangquan());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Xiaoshourenyuan, abopenaccountMoneyBj.getXiaoshourenyuan());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Dianming, abopenaccountMoneyBj.getDianming());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Dingdandanhao, abopenaccountMoneyBj.getDingdandanhao());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Xingming, abopenaccountMoneyBj.getXingming());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Danshu, abopenaccountMoneyBj.getDanshu());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Kaitonghaoma, abopenaccountMoneyBj.getKaitonghaoma());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Jine, abopenaccountMoneyBj.getJine());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Fukuanfangshi, abopenaccountMoneyBj.getFukuanfangshi());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Shifouliansuodian, abopenaccountMoneyBj.getShifouliansuodian());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Kaitongshijian, abopenaccountMoneyBj.getKaitongshijian());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Jiezhishijian, abopenaccountMoneyBj.getJiezhishijian());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Daozhangriqi, abopenaccountMoneyBj.getDaozhangriqi());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Daozhangjine, abopenaccountMoneyBj.getDaozhangjine());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Shouxufei, abopenaccountMoneyBj.getShouxufei());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Hetonghao, abopenaccountMoneyBj.getHetonghao());
        sqlParameter.add(AbopenaccountMoneyBjMapping.Beizhu, abopenaccountMoneyBj.getBeizhu());
        sqlParameter.add(AbopenaccountMoneyBjMapping.F22, abopenaccountMoneyBj.getF22());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String xuhao)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyBjMapping.Xuhao,xuhao);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public AbopenaccountMoneyBj searchByXuhao(java.lang.String xuhao)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountMoneyBjMapping.Xuhao,xuhao);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, AbopenaccountMoneyBj.class);
    }
    public PagedList<AbopenaccountMoneyBj> searchByPage(QueryCondition queryCondition) {
        PagedList<AbopenaccountMoneyBj> pagedList=this.searchByPage(queryCondition, AbopenaccountMoneyBj.class);
        return pagedList;
    }
    public List<AbopenaccountMoneyBj> searchList(QueryParameter queryParameter) {
                List<AbopenaccountMoneyBj> list=this.searchList(queryParameter, AbopenaccountMoneyBj.class);
                    return list;
    }
}
