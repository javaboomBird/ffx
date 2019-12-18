package org.interface21.provider.controller;

import org.interface21.common.base.BaseController;
import org.interface21.common.entity.Result;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.*;

/**
 * @author huangzh
 * @Date 2019/12/18
 * @Description
 */
@RestController
public class ProviderController extends BaseController {

    @GetMapping("/init")
    public void init(){
        System.out.println("初始化接口");
    }

    @RequestMapping(value = "/send/{flag}", method = {RequestMethod.GET, RequestMethod.POST})
    public Result send(@PathVariable String flag) {
        if ("map".equals(flag)) {
            Map<String, Object> map = new HashMap<>(3, 1);
            map.put("id", UUID.randomUUID().toString());
            map.put("age", 29);
            map.put("sex", true);
            messageSender.send(map);
        } else if ("list".equals(flag)) {
            List<? extends Serializable> list = Arrays.asList(89757, 19L, 6.66f, "Lion狮子", true);
            messageSender.send(list);
        } else {
            // flag = string
            messageSender.send("Hello, Lion / 你好，狮子");
        }
        return Result.success();
    }
}
