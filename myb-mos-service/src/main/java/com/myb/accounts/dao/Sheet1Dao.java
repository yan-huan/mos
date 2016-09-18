package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Sheet1;
import com.myb.entity.pojo.mos.Sheet1Mapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("sheet1Dao")
public class Sheet1Dao extends MySqlCommandBase
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
        return "sheet1";
    }


    public int insert(Sheet1 sheet1)
    {
        String sql="INSERT INTO "+getTableName()+" (xuhao,zhanghu,xingming,nicheng,bangongdianhua,shouji,bumen,gangwei,QQhao,MSN,gongzuoyouxiang,xingbie,chuangjianshijian,miaoshu,id)VALUES(@{xuhao},@{zhanghu},@{xingming},@{nicheng},@{bangongdianhua},@{shouji},@{bumen},@{gangwei},@{QQhao},@{MSN},@{gongzuoyouxiang},@{xingbie},@{chuangjianshijian},@{miaoshu},@{id})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(Sheet1Mapping.Xuhao, sheet1.getXuhao());
        sqlParameter.add(Sheet1Mapping.Zhanghu, sheet1.getZhanghu());
        sqlParameter.add(Sheet1Mapping.Xingming, sheet1.getXingming());
        sqlParameter.add(Sheet1Mapping.Nicheng, sheet1.getNicheng());
        sqlParameter.add(Sheet1Mapping.Bangongdianhua, sheet1.getBangongdianhua());
        sqlParameter.add(Sheet1Mapping.Shouji, sheet1.getShouji());
        sqlParameter.add(Sheet1Mapping.Bumen, sheet1.getBumen());
        sqlParameter.add(Sheet1Mapping.Gangwei, sheet1.getGangwei());
        sqlParameter.add(Sheet1Mapping.QQhao, sheet1.getQQhao());
        sqlParameter.add(Sheet1Mapping.MSN, sheet1.getMSN());
        sqlParameter.add(Sheet1Mapping.Gongzuoyouxiang, sheet1.getGongzuoyouxiang());
        sqlParameter.add(Sheet1Mapping.Xingbie, sheet1.getXingbie());
        sqlParameter.add(Sheet1Mapping.Chuangjianshijian, sheet1.getChuangjianshijian());
        sqlParameter.add(Sheet1Mapping.Miaoshu, sheet1.getMiaoshu());
        sqlParameter.add(Sheet1Mapping.Id, sheet1.getId());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Sheet1 sheet1)
    {
        String sql="UPDATE "+getTableName()+" set zhanghu=@{zhanghu},xingming=@{xingming},nicheng=@{nicheng},bangongdianhua=@{bangongdianhua},shouji=@{shouji},bumen=@{bumen},gangwei=@{gangwei},QQhao=@{QQhao},MSN=@{MSN},gongzuoyouxiang=@{gongzuoyouxiang},xingbie=@{xingbie},chuangjianshijian=@{chuangjianshijian},miaoshu=@{miaoshu},id=@{id} WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(Sheet1Mapping.Xuhao, sheet1.getXuhao());
        sqlParameter.add(Sheet1Mapping.Zhanghu, sheet1.getZhanghu());
        sqlParameter.add(Sheet1Mapping.Xingming, sheet1.getXingming());
        sqlParameter.add(Sheet1Mapping.Nicheng, sheet1.getNicheng());
        sqlParameter.add(Sheet1Mapping.Bangongdianhua, sheet1.getBangongdianhua());
        sqlParameter.add(Sheet1Mapping.Shouji, sheet1.getShouji());
        sqlParameter.add(Sheet1Mapping.Bumen, sheet1.getBumen());
        sqlParameter.add(Sheet1Mapping.Gangwei, sheet1.getGangwei());
        sqlParameter.add(Sheet1Mapping.QQhao, sheet1.getQQhao());
        sqlParameter.add(Sheet1Mapping.MSN, sheet1.getMSN());
        sqlParameter.add(Sheet1Mapping.Gongzuoyouxiang, sheet1.getGongzuoyouxiang());
        sqlParameter.add(Sheet1Mapping.Xingbie, sheet1.getXingbie());
        sqlParameter.add(Sheet1Mapping.Chuangjianshijian, sheet1.getChuangjianshijian());
        sqlParameter.add(Sheet1Mapping.Miaoshu, sheet1.getMiaoshu());
        sqlParameter.add(Sheet1Mapping.Id, sheet1.getId());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String xuhao)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(Sheet1Mapping.Xuhao,xuhao);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Sheet1 searchByXuhao(java.lang.String xuhao)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE xuhao=@{xuhao}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(Sheet1Mapping.Xuhao,xuhao);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Sheet1.class);
    }
    public PagedList<Sheet1> searchByPage(QueryCondition queryCondition) {
        PagedList<Sheet1> pagedList=this.searchByPage(queryCondition, Sheet1.class);
        return pagedList;
    }
    public List<Sheet1> searchList(QueryParameter queryParameter) {
                List<Sheet1> list=this.searchList(queryParameter, Sheet1.class);
                    return list;
    }
}
