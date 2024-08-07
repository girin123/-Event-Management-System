package com.excelr.controller;

import com.excelr.model.Address;
import com.excelr.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/addresses")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping("/{userId}")
    public List<Address> getAddresses(@PathVariable Long userId) {
        return addressBookService.getAddressesByUser(userId);
    }

    @PostMapping("/{userId}")
    public Address addAddress(@PathVariable Long userId, @RequestBody Address address) {
        return addressBookService.addAddress(userId, address);
    }

    @PutMapping("/{addressId}")
    public Address updateAddress(@PathVariable Long addressId, @RequestBody Address address) {
        return addressBookService.updateAddress(addressId, address);
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable Long addressId) {
        addressBookService.deleteAddress(addressId);
    }
}
