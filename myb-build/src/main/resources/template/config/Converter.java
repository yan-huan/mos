package ${project_name}.common;

import com.myb.framework.data.PagedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/13.
 */
public class Converter {
    public static Map<String,Object> toMap(PagedList pagedList)
    {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",pagedList.getRecordCount());
        map.put("rows",pagedList.getContent());
        return map;
    }
}
