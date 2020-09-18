package com.jsjy.demo_01.service;

import com.jsjy.demo_01.mapper.AllPerson;
import com.jsjy.demo_01.mapper.yewuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.awt.SystemColor.info;

@Service
public class yewuService {
    @Autowired
    private yewuMapper mapper;

    /*
    1、先查出数据
    2、截取数据信息
    3、拼接到对应字段
     */
    public Map<String ,Object> getInfo(){
        List<Map<String, Object>> info = mapper.getInfo();
        System.out.println("从数据获取到的数据"+info);
        int i = hqgx(info);
        Map map = new HashMap();
        if (i>0){
            map.put("更新成功",i);
            return map;
        }else{
            map.put("更新失败",i);
            return map;
        }
    }


    public int hqgx(List lis){

        int count = 0;
        //遍历list数组内容
        for(int i=0;i<lis.size();i++){
            Map<String, Object> map = (Map<String, Object>) lis.get(i);
            //获取参数
            String  unit_place = (String) map.get("unit_place");
            String archive_no = (String) map.get("archive_no");
            int id = (int) map.get("id");
            String s = archive_no.substring(0, 2);
            String s1 = archive_no.substring(2, archive_no.length());
            //拼接成：10-高淳国土资源局-3-179-2466
            StringBuffer buffer1 = new StringBuffer();
            buffer1.append(s);
            buffer1.append("-"+unit_place);
            buffer1.append(s1);
            System.out.println( buffer1);
            mapper.updatearchive(buffer1.toString(),id);
            count++;
        }
        System.out.println("更新了"+count+"次");
        return count;
    }
}
