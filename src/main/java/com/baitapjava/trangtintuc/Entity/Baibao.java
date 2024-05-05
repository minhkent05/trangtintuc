package com.baitapjava.trangtintuc.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Baibao")
public class Baibao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "ten_bai_bao")
	private String tenbaibao;
	@Column(name = "ngay_dang")
	private String ngaydang;
	@Lob
	@Column(name = "anh")
	private byte[] anh;
	@Lob
	@Column(name = "noi_dung")
	private String noidung;
	@Column(name = "tac_gia")
	private String tacgia;
	@Column(name = "the_loai")
	private String theloai;
	@Column(name = "luot_xem")
	private int luotxem;
}
