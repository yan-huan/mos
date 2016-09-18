package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Abcaiwuall;
import com.myb.entity.pojo.mos.AbcaiwuallMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("abcaiwuallDao")
public class AbcaiwuallDao extends MySqlCommandBase
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
        return "abcaiwuall";
    }


    public int insert(Abcaiwuall abcaiwuall)
    {
        String sql="INSERT INTO "+getTableName()+" (F1,shengfen,chegnshi,quyu,shangquan,xsry,dianming,dddh,xingming,danshu,kthm,jine,fukuanfs,sfls,ktsj,jzsj,dzrq,dzje,sxf,hth,beizhu,updateEndTime,updateStartTime,F24)VALUES(@{F1},@{shengfen},@{chegnshi},@{quyu},@{shangquan},@{xsry},@{dianming},@{dddh},@{xingming},@{danshu},@{kthm},@{jine},@{fukuanfs},@{sfls},@{ktsj},@{jzsj},@{dzrq},@{dzje},@{sxf},@{hth},@{beizhu},@{updateEndTime},@{updateStartTime},@{F24})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbcaiwuallMapping.F1, abcaiwuall.getF1());
        sqlParameter.add(AbcaiwuallMapping.Shengfen, abcaiwuall.getShengfen());
        sqlParameter.add(AbcaiwuallMapping.Chegnshi, abcaiwuall.getChegnshi());
        sqlParameter.add(AbcaiwuallMapping.Quyu, abcaiwuall.getQuyu());
        sqlParameter.add(AbcaiwuallMapping.Shangquan, abcaiwuall.getShangquan());
        sqlParameter.add(AbcaiwuallMapping.Xsry, abcaiwuall.getXsry());
        sqlParameter.add(AbcaiwuallMapping.Dianming, abcaiwuall.getDianming());
        sqlParameter.add(AbcaiwuallMapping.Dddh, abcaiwuall.getDddh());
        sqlParameter.add(AbcaiwuallMapping.Xingming, abcaiwuall.getXingming());
        sqlParameter.add(AbcaiwuallMapping.Danshu, abcaiwuall.getDanshu());
        sqlParameter.add(AbcaiwuallMapping.Kthm, abcaiwuall.getKthm());
        sqlParameter.add(AbcaiwuallMapping.Jine, abcaiwuall.getJine());
        sqlParameter.add(AbcaiwuallMapping.Fukuanfs, abcaiwuall.getFukuanfs());
        sqlParameter.add(AbcaiwuallMapping.Sfls, abcaiwuall.getSfls());
        sqlParameter.add(AbcaiwuallMapping.Ktsj, abcaiwuall.getKtsj());
        sqlParameter.add(AbcaiwuallMapping.Jzsj, abcaiwuall.getJzsj());
        sqlParameter.add(AbcaiwuallMapping.Dzrq, abcaiwuall.getDzrq());
        sqlParameter.add(AbcaiwuallMapping.Dzje, abcaiwuall.getDzje());
        sqlParameter.add(AbcaiwuallMapping.Sxf, abcaiwuall.getSxf());
        sqlParameter.add(AbcaiwuallMapping.Hth, abcaiwuall.getHth());
        sqlParameter.add(AbcaiwuallMapping.Beizhu, abcaiwuall.getBeizhu());
        sqlParameter.add(AbcaiwuallMapping.UpdateEndTime, abcaiwuall.getUpdateEndTime());
        sqlParameter.add(AbcaiwuallMapping.UpdateStartTime, abcaiwuall.getUpdateStartTime());
        sqlParameter.add(AbcaiwuallMapping.F24, abcaiwuall.getF24());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Abcaiwuall abcaiwuall)
    {
        String sql="UPDATE "+getTableName()+" set shengfen=@{shengfen},chegnshi=@{chegnshi},quyu=@{quyu},shangquan=@{shangquan},xsry=@{xsry},dianming=@{dianming},dddh=@{dddh},xingming=@{xingming},danshu=@{danshu},kthm=@{kthm},jine=@{jine},fukuanfs=@{fukuanfs},sfls=@{sfls},ktsj=@{ktsj},jzsj=@{jzsj},dzrq=@{dzrq},dzje=@{dzje},sxf=@{sxf},hth=@{hth},beizhu=@{beizhu},updateEndTime=@{updateEndTime},updateStartTime=@{updateStartTime},F24=@{F24} WHERE F1=@{F1}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbcaiwuallMapping.F1, abcaiwuall.getF1());
        sqlParameter.add(AbcaiwuallMapping.Shengfen, abcaiwuall.getShengfen());
        sqlParameter.add(AbcaiwuallMapping.Chegnshi, abcaiwuall.getChegnshi());
        sqlParameter.add(AbcaiwuallMapping.Quyu, abcaiwuall.getQuyu());
        sqlParameter.add(AbcaiwuallMapping.Shangquan, abcaiwuall.getShangquan());
        sqlParameter.add(AbcaiwuallMapping.Xsry, abcaiwuall.getXsry());
        sqlParameter.add(AbcaiwuallMapping.Dianming, abcaiwuall.getDianming());
        sqlParameter.add(AbcaiwuallMapping.Dddh, abcaiwuall.getDddh());
        sqlParameter.add(AbcaiwuallMapping.Xingming, abcaiwuall.getXingming());
        sqlParameter.add(AbcaiwuallMapping.Danshu, abcaiwuall.getDanshu());
        sqlParameter.add(AbcaiwuallMapping.Kthm, abcaiwuall.getKthm());
        sqlParameter.add(AbcaiwuallMapping.Jine, abcaiwuall.getJine());
        sqlParameter.add(AbcaiwuallMapping.Fukuanfs, abcaiwuall.getFukuanfs());
        sqlParameter.add(AbcaiwuallMapping.Sfls, abcaiwuall.getSfls());
        sqlParameter.add(AbcaiwuallMapping.Ktsj, abcaiwuall.getKtsj());
        sqlParameter.add(AbcaiwuallMapping.Jzsj, abcaiwuall.getJzsj());
        sqlParameter.add(AbcaiwuallMapping.Dzrq, abcaiwuall.getDzrq());
        sqlParameter.add(AbcaiwuallMapping.Dzje, abcaiwuall.getDzje());
        sqlParameter.add(AbcaiwuallMapping.Sxf, abcaiwuall.getSxf());
        sqlParameter.add(AbcaiwuallMapping.Hth, abcaiwuall.getHth());
        sqlParameter.add(AbcaiwuallMapping.Beizhu, abcaiwuall.getBeizhu());
        sqlParameter.add(AbcaiwuallMapping.UpdateEndTime, abcaiwuall.getUpdateEndTime());
        sqlParameter.add(AbcaiwuallMapping.UpdateStartTime, abcaiwuall.getUpdateStartTime());
        sqlParameter.add(AbcaiwuallMapping.F24, abcaiwuall.getF24());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String f1)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE F1=@{F1}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbcaiwuallMapping.F1,f1);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Abcaiwuall searchByF1(java.lang.String f1)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE F1=@{F1}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbcaiwuallMapping.F1,f1);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Abcaiwuall.class);
    }
    public PagedList<Abcaiwuall> searchByPage(QueryCondition queryCondition) {
        PagedList<Abcaiwuall> pagedList=this.searchByPage(queryCondition, Abcaiwuall.class);
        return pagedList;
    }
    public List<Abcaiwuall> searchList(QueryParameter queryParameter) {
                List<Abcaiwuall> list=this.searchList(queryParameter, Abcaiwuall.class);
                    return list;
    }
}
