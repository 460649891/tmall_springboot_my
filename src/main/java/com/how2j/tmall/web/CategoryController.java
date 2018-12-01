package com.how2j.tmall.web;

import com.how2j.tmall.pojo.Category;
import com.how2j.tmall.service.CategoryService;
import com.how2j.tmall.util.ImageUtil;
import com.how2j.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author admin
 * @title title
 * @date 2018/11/30
 * @description: TODO(用一句话描述该文件做什么)
 */
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        Page4Navigator<Category> page = categoryService.list(start, size, 5);
        return page;
    }

    @PostMapping("/categories")
    public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws Exception {
        categoryService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }

    public void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, bean.getId() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }


    @DeleteMapping("categories/{id}")
    public Object delete(@PathVariable("id") int id, HttpServletRequest request) throws Exception {
        categoryService.delete(id);
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, id + ".jpg");
        file.delete();
        return null;
    }

    @GetMapping("categories/{id}")
    public Category get(@PathVariable("id") int id, HttpServletRequest request) {
        return categoryService.get(id);

    }

    /*var url = this.uri + "/" + this.bean.id;
    //axios.js 上传文件要用 formData 这种方式
    var formData = new FormData();
                    formData.append("image", this.file);
                    formData.append("name", this.bean.name);
                    axios.put(url, formData).then(function (response) {
        location.href = vue.listURL;
    });*/

    @PutMapping("categories/{id}")
    public Object update(Category bean, HttpServletRequest request, MultipartFile image) throws IOException {
        String name = request.getParameter("name");
        bean.setName(name);
        categoryService.update(bean);

        if (image != null) {
            saveOrUpdateImageFile(bean, image, request);
        }
        return bean;
    }

}
