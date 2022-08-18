package com.api;

import com.JiFen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient("CloudJiFen")
public interface JiFenAPI {

    @RequestMapping("/jifen/save")
    public Map save(@RequestBody JiFen jifen);

    @RequestMapping("/jifen/update")
    public Map update(@RequestBody JiFen jifen);

    @RequestMapping("/jifen/delete")
    public Map deleteById(@RequestParam("jifenId") Integer jifenId);

    @RequestMapping("/jifen/{jifenId}")
    public JiFen findJiFenById(@PathVariable("jifenId") Integer jifenId);

    @RequestMapping("/jifen/search")
    public JiFen search(@RequestParam("uid") Integer uid,@RequestParam("type") String type);

    @RequestMapping("/jifen/searchByEntity")
    public List<JiFen> searchMap(@RequestBody JiFen jifen);

}
