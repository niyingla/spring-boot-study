package com.imooc.architect.showcase.web;

import com.imooc.architect.showcase.model.DemoModel;
import com.imooc.architect.showcase.service.DemoModelService;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/demo")
public class DemoModelController {

    private static final Logger LOG = LoggerFactory
            .getLogger(DemoModelController.class);

    @Autowired
    private DemoModelService demoModelService;

    public void setDemoModelService(DemoModelService demoModelService) {
        this.demoModelService = demoModelService;
    }


    @RequestMapping(value = "/", method = {RequestMethod.POST})
    @ResponseBody
    public DemoModel save(@ModelAttribute("demo") DemoModel model) {
        return demoModelService.save(model);
    }


    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public DemoModel get(@PathVariable(value = "id") Long id) {
        return demoModelService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
    @ResponseBody
    public DemoModel udate(@PathVariable(value = "id") Long id, @ModelAttribute("demo") DemoModel model) {
        LOG.info("pudate id = {}", id);
        model.setId(id);
        return demoModelService.update(model);
    }

    @RequestMapping(value = "/list",
            method = {RequestMethod.GET},
            consumes = {MediaType.ALL_VALUE},
            produces = {MediaType.TEXT_HTML_VALUE})
    @ModelAttribute("list")
    public List<DemoModel> listView(@RequestParam Map<String, String> map) {
        return demoModelService.findAll();
    }
}
