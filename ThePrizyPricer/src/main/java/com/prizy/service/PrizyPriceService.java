package com.prizy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prizy.dto.ProductLoaderInDto;
import com.prizy.dto.ProductLoaderOutDto;
import com.prizy.model.ProductLoaderModel;

@Service
public interface PrizyPriceService {
	
	public String productLoader(ProductLoaderInDto productLoaderInDto);
	
	public List<ProductLoaderModel> productList();
	
	public ProductLoaderOutDto productView(int id);

}
