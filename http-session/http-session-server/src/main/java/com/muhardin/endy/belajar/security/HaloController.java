package com.muhardin.endy.belajar.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HaloController {
    
    @RequestMapping("/halo")
    public Map<String, String> halo(){
        Map<String, String> hasil = new HashMap<>();
        hasil.put("waktu", new Date().toString());
        return hasil;
    }
}
