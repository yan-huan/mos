package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class OpenaccountChannel extends EntityBase{

    @DataMapping(OpenaccountChannelMapping.Id)
    private long id;//主键id
    @DataMapping(OpenaccountChannelMapping.OpenAccountId)
    private long openAccountId;//账号id
    @DataMapping(OpenaccountChannelMapping.ChannelId)
    private long channelId;//渠道代理商
    @DataMapping(OpenaccountChannelMapping.Status)
    private int status;//


    public OpenaccountChannel() { }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    public long getOpenAccountId()
    {
        return openAccountId;
    }

    public void setOpenAccountId(long openAccountId)
    {
        this.openAccountId = openAccountId;
    }
    public long getChannelId()
    {
        return channelId;
    }

    public void setChannelId(long channelId)
    {
        this.channelId = channelId;
    }
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

}
