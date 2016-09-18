package com.myb.feedback.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.feedback.DbProblem;
import com.myb.entity.pojo.feedback.DbProblemMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("dbProblemDao")
public class DbProblemDao extends MySqlCommandBase
{

    @Resource(name = "datacommand")
    private DataCommand dataCommand;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommand);
    }
    @Override
    public String getTableName()
    {
        return "db_problem";
    }


    public int insert(DbProblem dbProblem)
    {
        String sql="INSERT INTO "+getTableName()+" (id,addTime,modifyTime,account,answer,appVersion,before_shantui,bugType,create_by,create_by_uname,descripe,img_url,ios_auth,mobile_model,rate,role,shantui_time,status,title,update_by,update_by_uname,version,video_url)VALUES(@{id},@{addTime},@{modifyTime},@{account},@{answer},@{appVersion},@{before_shantui},@{bugType},@{create_by},@{create_by_uname},@{descripe},@{img_url},@{ios_auth},@{mobile_model},@{rate},@{role},@{shantui_time},@{status},@{title},@{update_by},@{update_by_uname},@{version},@{video_url})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbProblemMapping.Id, dbProblem.getId());
        sqlParameter.add(DbProblemMapping.AddTime, dbProblem.getAddTime());
        sqlParameter.add(DbProblemMapping.ModifyTime, dbProblem.getModifyTime());
        sqlParameter.add(DbProblemMapping.Account, dbProblem.getAccount());
        sqlParameter.add(DbProblemMapping.Answer, dbProblem.getAnswer());
        sqlParameter.add(DbProblemMapping.AppVersion, dbProblem.getAppVersion());
        sqlParameter.add(DbProblemMapping.BeforeShantui, dbProblem.getBeforeShantui());
        sqlParameter.add(DbProblemMapping.BugType, dbProblem.getBugType());
        sqlParameter.add(DbProblemMapping.CreateBy, dbProblem.getCreateBy());
        sqlParameter.add(DbProblemMapping.CreateByUname, dbProblem.getCreateByUname());
        sqlParameter.add(DbProblemMapping.Descripe, dbProblem.getDescripe());
        sqlParameter.add(DbProblemMapping.ImgUrl, dbProblem.getImgUrl());
        sqlParameter.add(DbProblemMapping.IosAuth, dbProblem.getIosAuth());
        sqlParameter.add(DbProblemMapping.MobileModel, dbProblem.getMobileModel());
        sqlParameter.add(DbProblemMapping.Rate, dbProblem.getRate());
        sqlParameter.add(DbProblemMapping.Role, dbProblem.getRole());
        sqlParameter.add(DbProblemMapping.ShantuiTime, dbProblem.getShantuiTime());
        sqlParameter.add(DbProblemMapping.Status, dbProblem.getStatus());
        sqlParameter.add(DbProblemMapping.Title, dbProblem.getTitle());
        sqlParameter.add(DbProblemMapping.UpdateBy, dbProblem.getUpdateBy());
        sqlParameter.add(DbProblemMapping.UpdateByUname, dbProblem.getUpdateByUname());
        sqlParameter.add(DbProblemMapping.Version, dbProblem.getVersion());
        sqlParameter.add(DbProblemMapping.VideoUrl, dbProblem.getVideoUrl());
        return this.getDataCommand().insertAndGetKey(sql, sqlParameter).intValue();
    }

    public int update(DbProblem dbProblem)
    {
        String sql="UPDATE "+getTableName()+" set addTime=@{addTime},modifyTime=@{modifyTime},account=@{account},answer=@{answer},appVersion=@{appVersion},before_shantui=@{before_shantui},bugType=@{bugType},create_by=@{create_by},create_by_uname=@{create_by_uname},descripe=@{descripe},img_url=@{img_url},ios_auth=@{ios_auth},mobile_model=@{mobile_model},rate=@{rate},role=@{role},shantui_time=@{shantui_time},status=@{status},title=@{title},update_by=@{update_by},update_by_uname=@{update_by_uname},version=@{version},video_url=@{video_url} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbProblemMapping.Id, dbProblem.getId());
        sqlParameter.add(DbProblemMapping.AddTime, dbProblem.getAddTime());
        sqlParameter.add(DbProblemMapping.ModifyTime, dbProblem.getModifyTime());
        sqlParameter.add(DbProblemMapping.Account, dbProblem.getAccount());
        sqlParameter.add(DbProblemMapping.Answer, dbProblem.getAnswer());
        sqlParameter.add(DbProblemMapping.AppVersion, dbProblem.getAppVersion());
        sqlParameter.add(DbProblemMapping.BeforeShantui, dbProblem.getBeforeShantui());
        sqlParameter.add(DbProblemMapping.BugType, dbProblem.getBugType());
        sqlParameter.add(DbProblemMapping.CreateBy, dbProblem.getCreateBy());
        sqlParameter.add(DbProblemMapping.CreateByUname, dbProblem.getCreateByUname());
        sqlParameter.add(DbProblemMapping.Descripe, dbProblem.getDescripe());
        sqlParameter.add(DbProblemMapping.ImgUrl, dbProblem.getImgUrl());
        sqlParameter.add(DbProblemMapping.IosAuth, dbProblem.getIosAuth());
        sqlParameter.add(DbProblemMapping.MobileModel, dbProblem.getMobileModel());
        sqlParameter.add(DbProblemMapping.Rate, dbProblem.getRate());
        sqlParameter.add(DbProblemMapping.Role, dbProblem.getRole());
        sqlParameter.add(DbProblemMapping.ShantuiTime, dbProblem.getShantuiTime());
        sqlParameter.add(DbProblemMapping.Status, dbProblem.getStatus());
        sqlParameter.add(DbProblemMapping.Title, dbProblem.getTitle());
        sqlParameter.add(DbProblemMapping.UpdateBy, dbProblem.getUpdateBy());
        sqlParameter.add(DbProblemMapping.UpdateByUname, dbProblem.getUpdateByUname());
        sqlParameter.add(DbProblemMapping.Version, dbProblem.getVersion());
        sqlParameter.add(DbProblemMapping.VideoUrl, dbProblem.getVideoUrl());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbProblemMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public DbProblem searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbProblemMapping.Id,id);
        return this.dataCommand.executeEntity(sql, sqlParameter, DbProblem.class);
    }
    public PagedList<DbProblem> searchByPage(QueryCondition queryCondition) {
        PagedList<DbProblem> pagedList=this.searchByPage(queryCondition, DbProblem.class);
        return pagedList;
    }
    public List<DbProblem> searchList(QueryParameter queryParameter) {
                List<DbProblem> list=this.searchList(queryParameter, DbProblem.class);
                    return list;
    }
}
