package com.controllers;

import com.beans.Book;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/add")
    public String addBook(Book book, MultipartFile bookImage, HttpServletRequest request) throws IOException {

        System.out.println(book);

        //截取上传图片路径名，生成新文件名
        String originalFilename = bookImage.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = System.currentTimeMillis()+ext;

        //获取imgs目录在服务器的路径
        String dir = request.getServletContext().getRealPath("imgs");
        String savePath = dir+"/"+fileName;

        //保存文件
        bookImage.transferTo(new File(savePath));

        //将图片访问路径设置到book对象
        book.setBookImg("imgs/"+fileName);

        //调用service保存book到数据库
        return "/tips.jsp";

    }

    @RequestMapping("/list")
    @ResponseBody
    public String[] listImgs(HttpServletRequest request){

        String dir = request.getServletContext().getRealPath("imgs");
        File imgDir = new File(dir);
        String[] fileNames = imgDir.list();
        return fileNames;

    }

    @RequestMapping("/download")
    public void downloadImg(String fname, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String dir = request.getServletContext().getRealPath("imgs");
        String filePath = dir+"/"+fname;
        FileInputStream fileInputStream = new FileInputStream(filePath);

        response.setContentType("application/exe");
        response.addHeader("Content-Disposition","attachment;filename="+fname);

        IOUtils.copy(fileInputStream,response.getOutputStream());
    }

    @RequestMapping("/query")
    public String query(String bookId){
        System.out.println(bookId.length());
        int bid = Integer.parseInt(bookId);
        return "/tips.jsp";
    }

}