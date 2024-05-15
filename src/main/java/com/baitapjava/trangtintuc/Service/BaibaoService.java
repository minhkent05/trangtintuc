package com.baitapjava.trangtintuc.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.baitapjava.trangtintuc.Entity.Baibao;

public interface BaibaoService {
	
	public Baibao thembaibaomoi (String tenbaibao, String ngaydang, MultipartFile anh,
	String noidung, String tacgia, String theloai, int luotxem,int user_id) throws IOException;
	
	public Baibao suabaibao (int id,String tenbaibao, MultipartFile anh,
			String noidung, String theloai) throws IOException;
	
	public Baibao suabaibao2 (int id,Baibao baibao);
	
	public void xoabaibao (int id);
	
	public List<Baibao> allbaibao();
	
	public Baibao onebaibao(int id);
	
	public List<Baibao> searchBaibao(String search);
	
	public Page<Baibao> listBaoPaging(String search, int pageNumber, int pageSize);
	
	public List<Baibao> listLienQuan(String theloai, int id);
	
	public List<Baibao> listNoiBat();
	
	public List<Baibao> listTheLoai(String theloai);
	
	public Page<Baibao> listBaibaoAuthor(String search,int id,int pageNumber,int pageSize);
}
