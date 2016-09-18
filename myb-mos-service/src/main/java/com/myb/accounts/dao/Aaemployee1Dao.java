package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Aaemployee1;
import com.myb.entity.pojo.mos.Aaemployee1Mapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("aaemployee1Dao")
public class Aaemployee1Dao extends MySqlCommandBase
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
        return "aaemployee1";
    }


    public int insert(Aaemployee1 aaemployee1)
    {
        String sql="INSERT INTO "+getTableName()+" (xu,a,quyu,gonghao,xingming,shenfenzheng,xingbie,bian,nianling,bumen,gangwei,ruzhishijian,zhuanzhenshijian,xingzhi,xueli,xuexiao,zhuanye,shebao,mobile,F20,F21)VALUES(@{xu},@{a},@{quyu},@{gonghao},@{xingming},@{shenfenzheng},@{xingbie},@{bian},@{nianling},@{bumen},@{gangwei},@{ruzhishijian},@{zhuanzhenshijian},@{xingzhi},@{xueli},@{xuexiao},@{zhuanye},@{shebao},@{mobile},@{F20},@{F21})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(Aaemployee1Mapping.Xu, aaemployee1.getXu());
        sqlParameter.add(Aaemployee1Mapping.A, aaemployee1.getA());
        sqlParameter.add(Aaemployee1Mapping.Quyu, aaemployee1.getQuyu());
        sqlParameter.add(Aaemployee1Mapping.Gonghao, aaemployee1.getGonghao());
        sqlParameter.add(Aaemployee1Mapping.Xingming, aaemployee1.getXingming());
        sqlParameter.add(Aaemployee1Mapping.Shenfenzheng, aaemployee1.getShenfenzheng());
        sqlParameter.add(Aaemployee1Mapping.Xingbie, aaemployee1.getXingbie());
        sqlParameter.add(Aaemployee1Mapping.Bian, aaemployee1.getBian());
        sqlParameter.add(Aaemployee1Mapping.Nianling, aaemployee1.getNianling());
        sqlParameter.add(Aaemployee1Mapping.Bumen, aaemployee1.getBumen());
        sqlParameter.add(Aaemployee1Mapping.Gangwei, aaemployee1.getGangwei());
        sqlParameter.add(Aaemployee1Mapping.Ruzhishijian, aaemployee1.getRuzhishijian());
        sqlParameter.add(Aaemployee1Mapping.Zhuanzhenshijian, aaemployee1.getZhuanzhenshijian());
        sqlParameter.add(Aaemployee1Mapping.Xingzhi, aaemployee1.getXingzhi());
        sqlParameter.add(Aaemployee1Mapping.Xueli, aaemployee1.getXueli());
        sqlParameter.add(Aaemployee1Mapping.Xuexiao, aaemployee1.getXuexiao());
        sqlParameter.add(Aaemployee1Mapping.Zhuanye, aaemployee1.getZhuanye());
        sqlParameter.add(Aaemployee1Mapping.Shebao, aaemployee1.getShebao());
        sqlParameter.add(Aaemployee1Mapping.Mobile, aaemployee1.getMobile());
        sqlParameter.add(Aaemployee1Mapping.F20, aaemployee1.getF20());
        sqlParameter.add(Aaemployee1Mapping.F21, aaemployee1.getF21());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Aaemployee1 aaemployee1)
    {
        String sql="UPDATE "+getTableName()+" set a=@{a},quyu=@{quyu},gonghao=@{gonghao},xingming=@{xingming},shenfenzheng=@{shenfenzheng},xingbie=@{xingbie},bian=@{bian},nianling=@{nianling},bumen=@{bumen},gangwei=@{gangwei},ruzhishijian=@{ruzhishijian},zhuanzhenshijian=@{zhuanzhenshijian},xingzhi=@{xingzhi},xueli=@{xueli},xuexiao=@{xuexiao},zhuanye=@{zhuanye},shebao=@{shebao},mobile=@{mobile},F20=@{F20},F21=@{F21} WHERE xu=@{xu}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(Aaemployee1Mapping.Xu, aaemployee1.getXu());
        sqlParameter.add(Aaemployee1Mapping.A, aaemployee1.getA());
        sqlParameter.add(Aaemployee1Mapping.Quyu, aaemployee1.getQuyu());
        sqlParameter.add(Aaemployee1Mapping.Gonghao, aaemployee1.getGonghao());
        sqlParameter.add(Aaemployee1Mapping.Xingming, aaemployee1.getXingming());
        sqlParameter.add(Aaemployee1Mapping.Shenfenzheng, aaemployee1.getShenfenzheng());
        sqlParameter.add(Aaemployee1Mapping.Xingbie, aaemployee1.getXingbie());
        sqlParameter.add(Aaemployee1Mapping.Bian, aaemployee1.getBian());
        sqlParameter.add(Aaemployee1Mapping.Nianling, aaemployee1.getNianling());
        sqlParameter.add(Aaemployee1Mapping.Bumen, aaemployee1.getBumen());
        sqlParameter.add(Aaemployee1Mapping.Gangwei, aaemployee1.getGangwei());
        sqlParameter.add(Aaemployee1Mapping.Ruzhishijian, aaemployee1.getRuzhishijian());
        sqlParameter.add(Aaemployee1Mapping.Zhuanzhenshijian, aaemployee1.getZhuanzhenshijian());
        sqlParameter.add(Aaemployee1Mapping.Xingzhi, aaemployee1.getXingzhi());
        sqlParameter.add(Aaemployee1Mapping.Xueli, aaemployee1.getXueli());
        sqlParameter.add(Aaemployee1Mapping.Xuexiao, aaemployee1.getXuexiao());
        sqlParameter.add(Aaemployee1Mapping.Zhuanye, aaemployee1.getZhuanye());
        sqlParameter.add(Aaemployee1Mapping.Shebao, aaemployee1.getShebao());
        sqlParameter.add(Aaemployee1Mapping.Mobile, aaemployee1.getMobile());
        sqlParameter.add(Aaemployee1Mapping.F20, aaemployee1.getF20());
        sqlParameter.add(Aaemployee1Mapping.F21, aaemployee1.getF21());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String xu)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE xu=@{xu}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(Aaemployee1Mapping.Xu,xu);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Aaemployee1 searchByXu(java.lang.String xu)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE xu=@{xu}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(Aaemployee1Mapping.Xu,xu);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Aaemployee1.class);
    }
    public PagedList<Aaemployee1> searchByPage(QueryCondition queryCondition) {
        PagedList<Aaemployee1> pagedList=this.searchByPage(queryCondition, Aaemployee1.class);
        return pagedList;
    }
    public List<Aaemployee1> searchList(QueryParameter queryParameter) {
                List<Aaemployee1> list=this.searchList(queryParameter, Aaemployee1.class);
                    return list;
    }
}
