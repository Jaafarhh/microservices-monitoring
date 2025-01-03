package com.alioui.microservices.inventory.service;

import com.alioui.microservices.inventory.model.Inventory;
import com.alioui.microservices.inventory.repository.InventoryRepository;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final MeterRegistry meterRegistry;

    @PostConstruct
    public void initializeMetrics() {
        log.info("Initializing inventory metrics on startup...");
        inventoryRepository.findAll().forEach(inventory -> {
            createGaugeForSku(inventory.getSkuCode());
            log.info("Created gauge for skuCode: {} with quantity: {}", 
                    inventory.getSkuCode(), inventory.getQuantity());
        });
    }

    @Transactional
    public boolean isInStock(String skuCode, Integer quantity) {
        log.info("Checking stock for skuCode: {} and quantity: {}", skuCode, quantity);
        
        return inventoryRepository.findBySkuCode(skuCode)
                .map(inventory -> {
                    if (inventory.getQuantity() >= quantity) {
                        inventory.setQuantity(inventory.getQuantity() - quantity);
                        inventoryRepository.save(inventory);
                        log.info("Updated inventory for skuCode: {}, new quantity: {}", 
                                skuCode, inventory.getQuantity());
                        // Force metric update by recreating the gauge
                        refreshGaugeForSku(skuCode);
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }

    private void createGaugeForSku(String skuCode) {
        meterRegistry.gauge("inventory.quantity",
                Tags.of(
                    "skuCode", skuCode,
                    "application", "Inventory Service"
                ),
                inventoryRepository,
                repository -> repository.findBySkuCode(skuCode)
                        .map(inventory -> (double) inventory.getQuantity())
                        .orElse(0.0));
    }

    private void refreshGaugeForSku(String skuCode) {
        // Remove existing gauge
        meterRegistry.getMeters()
            .stream()
            .filter(meter -> meter.getId().getName().equals("inventory.quantity") 
                && meter.getId().getTag("skuCode").equals(skuCode))
            .forEach(meterRegistry::remove);

        // Create new gauge
        createGaugeForSku(skuCode);
        log.info("Refreshed gauge for skuCode: {}", skuCode);
    }
}