package cn.yueshutong.client.core.order;

import cn.yueshutong.client.core.cmd.ExecuteCmd;
import cn.yueshutong.client.core.util.PathUtil;

import java.io.File;

/**
 * Create by yster@foxmail.com 2018/11/14 0014 22:21
 */
public class Jmap {

    /**
     * 导出堆快照
     * @param id
     * @return
     */
    public static String dump(String id){
        String path = PathUtil.getRootPath("dump/"+id+"_heap.hprof");
        File file = new File(PathUtil.getRootPath("dump/"));
        if (!file.exists()){
            file.mkdirs();
        }
        File file1 = new File(path);
        if (file1.exists()){
            file1.delete();
        }
        ExecuteCmd.execute(new String[]{"jmap","-dump:format=b,file="+path, id});
        return path;
    }

}
