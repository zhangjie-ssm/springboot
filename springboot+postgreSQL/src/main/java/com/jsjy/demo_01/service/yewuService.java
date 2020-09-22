package com.jsjy.demo_01.service;

import com.jsjy.demo_01.controller.yewuController;
import com.jsjy.demo_01.mapper.AllPerson;
import com.jsjy.demo_01.mapper.yewuMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.awt.SystemColor.info;

@Service
public class yewuService {

    private static Logger log = Logger.getLogger(yewuService.class);

    @Autowired
    private yewuMapper mapper;

    /*
    1、先查出数据
    2、截取数据信息
    3、拼接到对应字段
     */
    public Map<String ,Object> getInfo(){
        log.info("进入service层");
        List<Map<String, Object>> info = mapper.getInfo();
        System.out.println("从数据获取到的数据"+info);
        int i = hqgx(info);
        Map map = new HashMap();
        if (i>=0){
            map.put("更新成功",i);
            return map;
        }else{
            map.put("更新失败",i);
            return map;
        }
    }

    //获取数据进行拼接
    public int hqgx(List lis){
        int count = 0;
        //先获取archive_no 数据判断是否已经拼接过
        Object ob = lis.get(1);
        String[] split = ob.toString().split("-");
        if(split.length < 5){
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
        }else {
            return 0;
        }
    }
}
