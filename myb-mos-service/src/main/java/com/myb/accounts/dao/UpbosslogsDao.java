package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Upbosslogs;
import com.myb.entity.pojo.mos.UpbosslogsMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("upbosslogsDao")
public class UpbosslogsDao extends MySqlCommandBase
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
        return "upbosslogs";
    }


    public int insert(Upbosslogs upbosslogs)
    {
        String sql="INSERT INTO "+getTableName()+" (upBossId,beautifulYard,openNumber,payDate,marker,provinceCode,cityCode,zongbuAddress,remark,status,createTime,companyCode,shopCount)VALUES(@{upBossId},@{beautifulYard},@{openNumber},@{payDate},@{marker},@{provinceCode},@{cityCode},@{zongbuAddress},@{remark},@{status},@{createTime},@{companyCode},@{shopCount})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UpbosslogsMapping.UpBossId, upbosslogs.getUpBossId());
        sqlParameter.add(UpbosslogsMapping.BeautifulYard, upbosslogs.getBeautifulYard());
        sqlParameter.add(UpbosslogsMapping.OpenNumber, upbosslogs.getOpenNumber());
        sqlParameter.add(UpbosslogsMapping.PayDate, upbosslogs.getPayDate());
        sqlParameter.add(UpbosslogsMapping.Marker, upbosslogs.getMarker());
        sqlParameter.add(UpbosslogsMapping.ProvinceCode, upbosslogs.getProvinceCode());
        sqlParameter.add(UpbosslogsMapping.CityCode, upbosslogs.getCityCode());
        sqlParameter.add(UpbosslogsMapping.ZongbuAddress, upbosslogs.getZongbuAddress());
        sqlParameter.add(UpbosslogsMapping.Remark, upbosslogs.getRemark());
        sqlParameter.add(UpbosslogsMapping.Status, upbosslogs.getStatus());
        sqlParameter.add(UpbosslogsMapping.CreateTime, upbosslogs.getCreateTime());
        sqlParameter.add(UpbosslogsMapping.CompanyCode, upbosslogs.getCompanyCode());
        sqlParameter.add(UpbosslogsMapping.ShopCount, upbosslogs.getShopCount());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Upbosslogs upbosslogs)
    {
        String sql="UPDATE "+getTableName()+" set beautifulYard=@{beautifulYard},openNumber=@{openNumber},payDate=@{payDate},marker=@{marker},provinceCode=@{provinceCode},cityCode=@{cityCode},zongbuAddress=@{zongbuAddress},remark=@{remark},status=@{status},createTime=@{createTime},companyCode=@{companyCode},shopCount=@{shopCount} WHERE upBossId=@{upBossId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UpbosslogsMapping.UpBossId, upbosslogs.getUpBossId());
        sqlParameter.add(UpbosslogsMapping.BeautifulYard, upbosslogs.getBeautifulYard());
        sqlParameter.add(UpbosslogsMapping.OpenNumber, upbosslogs.getOpenNumber());
        sqlParameter.add(UpbosslogsMapping.PayDate, upbosslogs.getPayDate());
        sqlParameter.add(UpbosslogsMapping.Marker, upbosslogs.getMarker());
        sqlParameter.add(UpbosslogsMapping.ProvinceCode, upbosslogs.getProvinceCode());
        sqlParameter.add(UpbosslogsMapping.CityCode, upbosslogs.getCityCode());
        sqlParameter.add(UpbosslogsMapping.ZongbuAddress, upbosslogs.getZongbuAddress());
        sqlParameter.add(UpbosslogsMapping.Remark, upbosslogs.getRemark());
        sqlParameter.add(UpbosslogsMapping.Status, upbosslogs.getStatus());
        sqlParameter.add(UpbosslogsMapping.CreateTime, upbosslogs.getCreateTime());
        sqlParameter.add(UpbosslogsMapping.CompanyCode, upbosslogs.getCompanyCode());
        sqlParameter.add(UpbosslogsMapping.ShopCount, upbosslogs.getShopCount());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int upBossId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE upBossId=@{upBossId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UpbosslogsMapping.UpBossId,upBossId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Upbosslogs searchByUpBossId(int upBossId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE upBossId=@{upBossId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UpbosslogsMapping.UpBossId,upBossId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Upbosslogs.class);
    }
    public PagedList<Upbosslogs> searchByPage(QueryCondition queryCondition) {
        PagedList<Upbosslogs> pagedList=this.searchByPage(queryCondition, Upbosslogs.class);
        return pagedList;
    }
    public List<Upbosslogs> searchList(QueryParameter queryParameter) {
                List<Upbosslogs> list=this.searchList(queryParameter, Upbosslogs.class);
                    return list;
    }
}
