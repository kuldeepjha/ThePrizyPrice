package com.prizy.testcase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prizy.dto.ProductLoaderInDto;
import com.prizy.dto.ProductLoaderOutDto;
import com.prizy.model.ProductLoaderModel;
import com.prizy.repository.PrizyPriceRepository;
import com.prizy.serviceImpl.PrizyPriceServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class PrizyPriceTestCase {

	@Autowired
	PrizyPriceRepository prizyPriceRepository;

	@Autowired
	ProductLoaderModel productLoaderModel;

	@Autowired
	ProductLoaderOutDto productLoaderOutDto;
	
	List<ProductLoaderModel> productLoaderModelList = null;

	@Before
	public void initProductLoaderInputs() {
		ProductLoaderInDto productLoaderInDto = new ProductLoaderInDto();
		productLoaderInDto.setId(1);
		productLoaderInDto.setNotes("notes");
		productLoaderInDto.setPrice(1000.20);
		productLoaderInDto.setProductBarCode("12584");
		productLoaderInDto.setStore("store");
		BeanUtils.copyProperties(productLoaderInDto, productLoaderModel);
		prizyPriceRepository.save(productLoaderModel);
	}

	@Before
	public void iniPrizyPriceInputs() {
		productLoaderModelList = prizyPriceRepository.findAll();
	}

	@Before
	public void initInputs() {
		int id = 1;
		productLoaderModel = prizyPriceRepository.findById(id);
		BeanUtils.copyProperties(productLoaderModel, productLoaderOutDto);
		productLoaderOutDto.setAvgPrice(prizyPriceRepository.findAvgPrice(productLoaderOutDto.getProductBarCode()));
		productLoaderOutDto.setHightPrice(prizyPriceRepository.findAvgPrice(productLoaderOutDto.getProductBarCode()));
		productLoaderOutDto.setLowestPrice(prizyPriceRepository.findMinprice(productLoaderOutDto.getProductBarCode()));
		productLoaderOutDto.setIdealPrice(new PrizyPriceServiceImpl().getIdelPrice(productLoaderOutDto));
		productLoaderOutDto.setPricesCollected(
				prizyPriceRepository.countByProductBarCode(productLoaderOutDto.getProductBarCode()));
	}

	@Test
	public void compareProductLoader() {
		
		ProductLoaderOutDto productLoaderOutDto1 = new ProductLoaderOutDto();
		assertEquals(productLoaderOutDto1, productLoaderOutDto);
	}
	
	@Test
	public void comparePrizyPrice() {
		
		List<ProductLoaderModel> productLoaderModel = new ArrayList<>();
		assertEquals(productLoaderModelList, productLoaderModel);
	}
	
}
