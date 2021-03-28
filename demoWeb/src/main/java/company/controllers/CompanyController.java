package company.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import company.entities.Company;
import company.repositories.CompanyRepo;

@Controller
@RequestMapping("/")
public class CompanyController {
    private final CompanyRepo companyRepo;

    @Autowired
    public CompanyController(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @GetMapping("/")
    public String HomePage(Model model) {
        List<Company> listCompany = new ArrayList<>();
        companyRepo.findAll().forEach(listCompany::add);
        model.addAttribute("listCompany", listCompany);
        return "home";
    }

    @GetMapping("/add")
    public String AddPage(Model model) {
        model.addAttribute("company", new Company());
        return "form";
    }

    @GetMapping("/edit/{id}")
    public String EditPage(Model model, @PathVariable Long id) {
        Optional<Company> company = companyRepo.findById(id);
        if (company.isPresent()) {
            model.addAttribute("company", company);
            return "form";
        }
        return "error";
    }

    @PostMapping("/save")
    public String SavePage(RedirectAttributes redirectAttrs, @Valid Company company, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        companyRepo.save(company);
        redirectAttrs.addFlashAttribute("notice", "Cập nhật thông tin công ty thành công!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String DeletePage(RedirectAttributes redirectAttrs, @PathVariable Long id) {
        companyRepo.deleteById(id);
        redirectAttrs.addFlashAttribute("notice", "Xóa thông tin công ty thành công!");
        return "redirect:/";
    }

}
