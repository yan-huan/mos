package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.OpenaccountChannel;
import com.myb.entity.pojo.mos.OpenaccountChannelMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("openaccountChannelDao")
public class OpenaccountChannelDao extends MySqlCommandBase
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
        return "openaccount_channel";
    }


    public int insert(OpenaccountChannel openaccountChannel)
    {
        String sql="INSERT INTO "+getTableName()+" (id,openAccountId,channelId,status)VALUES(@{id},@{openAccountId},@{channelId},@{status})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenaccountChannelMapping.Id, openaccountChannel.getId());
        sqlParameter.add(OpenaccountChannelMapping.OpenAccountId, openaccountChannel.getOpenAccountId());
        sqlParameter.add(OpenaccountChannelMapping.ChannelId, openaccountChannel.getChannelId());
        sqlParameter.add(OpenaccountChannelMapping.Status, openaccountChannel.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(OpenaccountChannel openaccountChannel)
    {
        String sql="UPDATE "+getTableName()+" set openAccountId=@{openAccountId},channelId=@{channelId},status=@{status} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenaccountChannelMapping.Id, openaccountChannel.getId());
        sqlParameter.add(OpenaccountChannelMapping.OpenAccountId, openaccountChannel.getOpenAccountId());
        sqlParameter.add(OpenaccountChannelMapping.ChannelId, openaccountChannel.getChannelId());
        sqlParameter.add(OpenaccountChannelMapping.Status, openaccountChannel.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(long id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenaccountChannelMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public OpenaccountChannel searchById(long id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenaccountChannelMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, OpenaccountChannel.class);
    }
    public PagedList<OpenaccountChannel> searchByPage(QueryCondition queryCondition) {
        PagedList<OpenaccountChannel> pagedList=this.searchByPage(queryCondition, OpenaccountChannel.class);
        return pagedList;
    }
    public List<OpenaccountChannel> searchList(QueryParameter queryParameter) {
                List<OpenaccountChannel> list=this.searchList(queryParameter, OpenaccountChannel.class);
                    return list;
    }
}
