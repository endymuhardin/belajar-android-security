package com.muhardin.endy.belajar.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    
    @RequestMapping("/user")
    public Map<String, Object> currentUser(Authentication user){
        Map<String, Object> hasil = new HashMap<>();
        hasil.put("waktu", new Date());
        hasil.put("user", user);
        return hasil;
    }
            
}
