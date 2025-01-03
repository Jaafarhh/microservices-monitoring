package com.alioui.microservices.product.service;

import com.alioui.microservices.product.dto.ProductRequest;
import com.alioui.microservices.product.dto.ProductResponse;
import com.alioui.microservices.product.model.Product;
import com.alioui.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
        private final ProductRepository productRepository;

        public ProductResponse createProduct(ProductRequest productRequest) {
                Product product = Product.builder()
                                .name(productRequest.name())
                                .description(productRequest.description())
                                .skuCode(productRequest.skuCode())
                                .price(productRequest.price())
                                .build();
                productRepository.save(product);
                log.info("Product created successfully");
                return new ProductResponse(product.getId(), product.getName(), product.getDescription(),
                                product.getSkuCode(),
                                product.getPrice());
        }

        public List<ProductResponse> getAllProducts() {
                return productRepository.findAll()
                                .stream()
                                .map(product -> new ProductResponse(product.getId(), product.getName(),
                                                product.getDescription(),
                                                product.getSkuCode(),
                                                product.getPrice()))
                                .toList();
        }

        public ProductResponse getProduct(String id) {
                Product product = productRepository.findById(id)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                "Product not found"));
                return mapToProductResponse(product);
        }

        public ProductResponse updateProduct(String id, ProductRequest productRequest) {
                Product existingProduct = productRepository.findById(id)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                "Product not found"));

                existingProduct.setName(productRequest.name());
                existingProduct.setDescription(productRequest.description());
                existingProduct.setPrice(productRequest.price());
                existingProduct.setSkuCode(productRequest.skuCode());

                Product updatedProduct = productRepository.save(existingProduct);
                log.info("Product updated successfully: {}", id);
                return mapToProductResponse(updatedProduct);
        }

        public void deleteProduct(String id) {
                if (!productRepository.existsById(id)) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
                }
                productRepository.deleteById(id);
                log.info("Product deleted successfully: {}", id);
        }

        private ProductResponse mapToProductResponse(Product product) {
                return new ProductResponse(
                                product.getId(),
                                product.getName(),
                                product.getDescription(),
                                product.getSkuCode(),
                                product.getPrice());
        }
}
