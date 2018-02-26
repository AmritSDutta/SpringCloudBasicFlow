package com.trs.estimation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EstimationRestController {

    @RequestMapping(value = "/estimate", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity getEstimate(@RequestParam String name,
                               @RequestParam String Type,
                               @RequestParam String Size,
                               @RequestParam(value = "PhysicalSite", required = false, defaultValue = "false") String PhysicalSite,
                               @RequestParam(value = "Demo", required = false, defaultValue = "false") String Demo,
                               @RequestParam(value = "UI", required = false, defaultValue = "false") String UI) {

        ResponseEntity respEntity = null;
        if(true){
            InputStream inputStream = new FileInputStream("/home/arpit/Documents/PCAP/dummyPath/"+fileName);
            String type="application/text";

            byte[]out=org.apache.commons.io.IOUtils.toByteArray(inputStream);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("content-disposition", "attachment; filename=abc.txt");
            responseHeaders.add("Content-Type",type);

            respEntity = new ResponseEntity(out, responseHeaders,HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.OK);

    }


}
