package com.example.ProjectDemoExample.Controller;

import com.example.ProjectDemoExample.Dao.LibRepo;
import com.example.ProjectDemoExample.Entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class libraryController
{
    @Autowired
    LibRepo libRepo;
    @GetMapping("/home/")
    public String home()
    {

        return "libpage";
    }
    @GetMapping("/admin/")
    public String getData()
    {

        return "libReg";
    }
    @GetMapping("/save/Data/")
    public String saveData(Model model)
    {
        List<Library> libList=libRepo.findAll();
        model.addAttribute("libList",libList);
        return "libList";
    }
    @PostMapping("/show/")
    public String show(Model model,Library library)
    {
        libRepo.save(library);
        List<Library> libList=libRepo.findAll();
        model.addAttribute("msg","Registration sucessfull");

        model.addAttribute("libList",libList);
        return "libList";
    }
    @GetMapping("/show/delete/{libraryid}/")
    public String delete(Model model, Library library,@PathVariable long libraryid)
    {
        libRepo.deleteById(libraryid);
        List<Library> libList=libRepo.findAll();
        model.addAttribute("libList",libList);
        return "libList";
    }




}
