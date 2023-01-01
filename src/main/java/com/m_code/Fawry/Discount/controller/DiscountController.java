package com.m_code.Fawry.Discount.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m_code.Fawry.Auth.security.jwt.JwtUtils;
import com.m_code.Fawry.Discount.models.Discount;
import com.m_code.Fawry.Discount.models.DiscountDto;
import com.m_code.Fawry.Discount.models.DiscountType;
import com.m_code.Fawry.RuntimeData.DataStoreRuntime;
import com.m_code.Fawry.Services.AbstractService.AbstractService;

@RestController
@RequestMapping("/api/discounts")
@PreAuthorize("hasRole('ADMIN')")
public class DiscountController {
    @Autowired
    DataStoreRuntime dts;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/getall")
    public ResponseEntity<?> getDiscounts() {
        ArrayList<Discount> discounts = new ArrayList<Discount>();
        for (AbstractService service : dts.getServices()) {
            for (Discount discount : service.getDiscounts()) {
                if (!discounts.contains(discount)) {
                    discounts.add(discount);
                }
            }
        }
        return ResponseEntity.ok(discounts);
    }

    @PostMapping("/add/specific")
    public ResponseEntity<?> specific(@RequestBody DiscountDto discountDto) {
        float discountAmount = discountDto.amount;
        String service = discountDto.service;
        if (!(discountAmount > 0 && discountAmount < 100)) {
            return ResponseEntity.badRequest().body("Discount must be between 0 and 100");
        }
        Discount discount = new Discount(dts.getDiscountId(), discountAmount, DiscountType.Specific);
        Boolean found = false;
        for (AbstractService s : dts.getServices()) {
            if (s.getServiceProviderName().equals(service)) {
                s.notifyAddDiscount(discount);
                found = true;
            }
        }
        if (found) {
            return ResponseEntity.ok("Discount Added Successfully for " + service);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Service found with this name");
        }

    }

    @PostMapping("/add/overall")
    public ResponseEntity<?> overall(@RequestBody Map<String, Float> value) {
        float discountAmount = value.get("amount");
        if (!(discountAmount > 0 && discountAmount < 100)) {
            return ResponseEntity.badRequest().body("Discount must be between 0 and 100");
        }
        Discount discount = new Discount(dts.getDiscountId(), discountAmount, DiscountType.Overall);
        for (AbstractService service : dts.getServices()) {
            // Notify all services with the new discount
            service.notifyAddDiscount(discount);
        }
        return ResponseEntity.ok("Discount Added Successfully");
    }

    @PostMapping("/remove")
    public ResponseEntity<?> RemoveDiscount(@RequestBody Map<String, Integer> value) {
        int id = value.get("id");
        ArrayList<Discount> discountsRemove = new ArrayList<Discount>();
        Boolean found = false;
        for (AbstractService service : dts.getServices()) {
            discountsRemove.clear();
            for (Discount discount : service.getDiscounts()) {
                if (discount.getId() == id) {
                    // Notify all services with the removed discount
                    discountsRemove.add(discount);
                    found = true;
                }
            }
            for (Discount discount : discountsRemove) {
                service.notifyRemoveDiscount(discount);
            }
        }
        if (found) {
            return ResponseEntity.ok("Discount removed Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Discount found with this id");
        }
    }

}
