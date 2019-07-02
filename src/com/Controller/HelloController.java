package com.Controller;

import com.bean.Product;
import com.upload.UploadedImageFile;
import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @Author: yslu
 * @Date: 2019/6/26 9:51
 * @description：
 */
//@RestController
@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("hello");
        return "hello spring";
    }

    @RequestMapping("/one")
    public String one() {
        System.out.println("hello");
        return "one";
    }

    @RequestMapping("/two")
    public String two() {
        System.out.println("hello");
        return "two.jsp";
    }
    @RequestMapping("/session")
    public ModelAndView session() {
        ModelAndView mav = new ModelAndView("model");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }

    /**
     * 提交表单
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/addProduct")
    public ModelAndView add(Product product) throws Exception {
/*        注： addProduct.jsp 提交的name和price会自动注入到参数 product里
        注： 参数product会默认被当做值加入到ModelAndView 中，相当于：
        mav.addObject("product",product);*/
        ModelAndView mav = new ModelAndView("showProduct");
        System.out.println("测试数据 ---------->");
        return mav;
    }

    /**
     * jump地址客户端重定向（再次发起请求）index
     * @return
     */
    @RequestMapping("/jump")
    public ModelAndView jump() {
        ModelAndView mav = new ModelAndView("redirect:/one");
        return mav;
    }

    /**
     * 统计session次数
     * @param session
     * @return
     */
    @RequestMapping("/check")
    public ModelAndView check(HttpSession session) {
        Integer i = (Integer) session.getAttribute("count");
        if (i == null) {
            i = 0;
        }
        i++;
        session.setAttribute("count", i);
        ModelAndView mav = new ModelAndView("check");
        return mav;
    }

    /**
     * 上传图片
     * @param request
     * @param file
     * @return
     * @throws IllegalStateException
     * @throws IOException
     *
     * 1. 方法的第二个参数UploadedImageFile 中已经注入好了 image
     * 2. 通过 RandomStringUtils.randomAlphanumeric(10);获取一个随机文件名。 因为用户可能上传相同文件名的文件，为了不覆盖原来的文件，通过随机文件名的办法来规避
     * 3. 根据request.getServletContext().getRealPath 获取到web目录下的image目录，用于存放上传后的文件。
     * 4. 调用file.getImage().transferTo(newFile); 复制文件
     * 5. 把生成的随机文件名提交给视图，用于后续的显示
     */
    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file)
            throws IllegalStateException, IOException {
        String name = RandomStringUtils.randomAlphanumeric(10);
        String newFileName = name + ".jpg";
        /**
         * 下载的图片保存位置，保存在输出的地方！
         * E:\workspace\mvcTest\out\artifacts\mvcTest_war_exploded\daowjnaowdaw
         * E:\workspace\mvcTest\out\artifacts\mvcTest_war_exploded\image
         */
        File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);
        newFile.getParentFile().mkdirs();
        file.getImage().transferTo(newFile);
        ModelAndView mav = new ModelAndView("showUploadedFile");
        mav.addObject("imageName", newFileName);
        return mav;
    }
}