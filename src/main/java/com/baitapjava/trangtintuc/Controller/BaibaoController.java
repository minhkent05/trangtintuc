package com.baitapjava.trangtintuc.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baitapjava.trangtintuc.Entity.Baibao;
import com.baitapjava.trangtintuc.Service.BaibaoServiceImpl;

@CrossOrigin("*")
@RestController
public class BaibaoController {
	@Autowired
	private BaibaoServiceImpl service;
	
	@GetMapping("/listbaibao")
	public List<Baibao> getListBaibao(){
		return service.allbaibao();
	}
	
	@GetMapping("/baibao/{id}")
	public Baibao getOneBaibao(@PathVariable int id) {
		return service.onebaibao(id);
	}
	
	@PostMapping("/thembaibao")
	public Baibao addbaibao(@RequestParam("tenbaibao") String tenbaibao,
			@RequestParam("ngaydang") String  ngaydang,
			@RequestParam("anh") MultipartFile anh,
			@RequestParam("noidung") String noidung,
			@RequestParam("tacgia") String tacgia,
			@RequestParam("theloai") String theloai,
			@RequestParam("luotxem") int luotxem,
			@RequestParam("user_id") int user_id
			) throws IOException {
		return service.thembaibaomoi(tenbaibao,ngaydang,anh,noidung,tacgia,theloai,luotxem,user_id);
	}
	
	@DeleteMapping("/xoabaibao/{id}")
	public  void deletebaibao(@PathVariable int id) {
		service.xoabaibao(id);
	}
	
	@PutMapping("/suabaibao/{id}")
	public Baibao suabaibao(@PathVariable int id, 
			@RequestParam("tenbaibao") String tenbaibao,
			@RequestParam("anh") MultipartFile anh,
			@RequestParam("noidung") String noidung,
			@RequestParam("theloai") String theloai
			) throws IOException {
		return service.suabaibao(id, tenbaibao,anh,noidung,theloai);
	}
	
	@PutMapping("/suabaibao2/{id}")
	public Baibao suabaibao(@PathVariable int id,@RequestBody Baibao baibao ){
		return service.suabaibao2(id, baibao);
	}
	
	
	@GetMapping("/search")
	public  List<Baibao> searchBaibao(@RequestParam String search){
		return service.searchBaibao(search);
	}
	
	@GetMapping("/listBaoPaging")
	public Page<Baibao> listBaoPaging(@RequestParam String search,@RequestParam int pageNumber, @RequestParam int pageSize){
		return service.listBaoPaging(search,pageNumber,pageSize);
	}
	
	@GetMapping("/listLienQuan")
	public List<Baibao> listLienQuan(@RequestParam String theloai,@RequestParam int id){
		return service.listLienQuan(theloai, id);
	}
	
	@GetMapping("/listNoiBat")
	public List<Baibao> listNoiBat(){
		return service.listNoiBat();
	}
	
	@GetMapping("/listTheLoai")
	public List<Baibao> listTheLoai(@RequestParam String theloai){
		return service.listTheLoai(theloai);
	}
	
	@GetMapping("/listBaibaoAuthor")
	public Page<Baibao> listBaibaoAuthor(@RequestParam String search,@RequestParam int id,@RequestParam int pageNumber,@RequestParam int pageSize) {
		return service.listBaibaoAuthor(search,id,pageNumber,pageSize);
	}
	
}
