package com.clown.design.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    @ResponseBody
    public Map<String, Object> upload(HttpServletResponse response, HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        Map<String, Object> res = new HashMap<>();
        response.setHeader("content-type", "application/octet-stream");
        res.put("isSuccessful", false);
        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            File saveFile = new File(request.getSession().getServletContext().getRealPath("/upload/") + saveFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                res.put("isSuccessful", true);
                res.put("message", "上传成功");
                res.put("fileName", saveFile.getName());
                res.put("fileUrl", saveFile.getPath());
//                return ResultUtils.buildResult(saveFile.getName() + " 上传成功");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                res.put("message", "上传失败," + e.getMessage());
//                return ResultUtils.buildResult("上传失败," + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                res.put("message", "上传失败," + e.getMessage());
//                return ResultUtils.buildResult("上传失败," + e.getMessage());
            }
        } else {
            res.put("message", "上传失败，因为文件为空！");
//            return ResultUtils.buildResult("上传失败，因为文件为空.");
        }
        return res;
    }
}
