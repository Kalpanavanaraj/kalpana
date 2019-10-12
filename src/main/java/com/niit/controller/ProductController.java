package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.pojo.Product;

@Controller


public class ProductController {
	@Autowired
	ProductDao ps;
	@Autowired
	CategoryDao cs;
	
	@RequestMapping("/add")
   public String AddPage(Model model)
   {
	  model.addAttribute("product", new Product());
	  model.addAttribute("products", ps.getAllProduct());
	  model.addAttribute("categories", this.cs.getAllCategory());
	  return "Addproduct";
   }
	@RequestMapping("/getproduct")
	public String ProductPage(@ModelAttribute Product product,Model model,HttpServletRequest request)
	
	{
		ps.addProduct(product);
		MultipartFile file=product.getFile();
		String imagepath=request.getServletContext().getRealPath("/resources/images/");
		System.out.println(imagepath);
		Path path=Paths.get(imagepath + File.separator + product.getId() + ".jpg");
		File imagefile=new File(path.toString());
		System.out.println("path:" + path.toString());
		if(!imagefile.exists())
		{
			imagefile.mkdirs();
		}
		try
		{
			file.transferTo(imagefile);
		}
		catch(IllegalStateException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/add";
	}
	@RequestMapping(value="/editproduct/{id}")
	 public String edit(@PathVariable int id,Model model){  
	
     
      model.addAttribute("product", ps.getProductById(id));
      model.addAttribute("categories", this.cs.getAllCategory());
      return "Addproduct";
  }  
	@RequestMapping(value="/deleteproduct/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable int id){
		  
		ps.deleteProduct(id);
		
		 
		 return "redirect:/add";
		
	}
	@RequestMapping("/show/{id}")
	public String show(Model model,@PathVariable int id)
	{
		 model.addAttribute("products", ps.getProductById(id));
		return "show";
	}
}
