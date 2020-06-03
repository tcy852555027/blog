package com.tcy.controller.admin;

import com.tcy.pojo.Type;
import com.tcy.service.TypeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @作者:Tcy
 * @date:2020/5/26
 */
@Controller
@RequestMapping("/admin")
public class TypeController {
    @Resource
    private TypeService typeService;

    /**
     * @param pageable springboot 中默认的分页
     * @return
     */
    @GetMapping("/types")

    public String listType(@PageableDefault(size = 5, sort = {"id"},  //按照ID排序 每页10,倒叙
            direction = Sort.Direction.DESC)
                                   Pageable pageable, Model model) {
        model.addAttribute("page", typeService.listType(pageable));

        return "admin/types";
    }


    /**
     * 跳转到admin/types-input 页面
     *
     * @return
     */
    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    /**
     *
     * @return
     */

    /**
     * 新增 分类
     *
     * @param type
     * @return
     */
    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes) {
        if (typeService.getTypeByName(type.getName()) != null) {
            result.rejectValue("name", "nameError", "该分类已存在");  //验证结果
        }

        if (result.hasErrors()) {
            return "admin/types-input";
        }

        Type t = typeService.saveType(type);
        if (t == null) {
            //必须用RedirectAttributes   中的addFlashAttribute 这个方法
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/types";
    }

    // 编辑功能 表单回填
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    // 编辑功能
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult result,@PathVariable Long id, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/types-input";
        }
        Type t = typeService.updateType(id,type);
        if (t == null ) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/types";
    }

    //删除
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }


}
