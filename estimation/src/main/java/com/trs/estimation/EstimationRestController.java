package com.trs.estimation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@RestController
public class EstimationRestController {

    @Autowired
    EstimationDao estimationDao;

    @RequestMapping(value = "/estimate", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity getEstimate(@RequestParam String name,
                               @RequestParam String Type,
                               @RequestParam String Size,
                               @RequestParam(value = "PhysicalSite", required = false, defaultValue = "false") String PhysicalSite,
                               @RequestParam(value = "Demo", required = false, defaultValue = "false") String Demo,
                               @RequestParam(value = "UI", required = false, defaultValue = "false") String Mobile,
                               @RequestParam(value = "UI", required = false, defaultValue = "false") String UI) {

        ResponseEntity respEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        if(true){

            try
            {

                List<TaskEffort> allefforts =estimationDao.getEfforts(Size,Type);
                File temp = File.createTempFile(name +" -Estimate ", Long.toString(System.nanoTime()));
                temp.deleteOnExit();

                PrintWriter writer = new PrintWriter(new FileWriter(temp));
                writer.println("TRS ESTIMATION:\n\n");
                writer.println("Issue Name : "+name+"\t\tType: "+Type+"\t\tSize :"+Size);
                writer.println();
                writer.println();
                if(allefforts != null) {
                    allefforts.stream().forEach(task -> {
                        writer.println(task.getName() + "\t\t:" + task.getEffortInHours() + " Hrs. \n");
                    });
                    writer.println("-------------------------------------------------");
                    int totalEffort=allefforts.stream().mapToInt(TaskEffort::getEffortInHours).sum();
                    writer.println("Total Effort\t\t:" + totalEffort + " Hrs. \n");

                }
                //Close writer
                writer.close();
                InputStream inputStream = new FileInputStream(temp);
                String type="application/text";

                byte[]out=org.apache.commons.io.IOUtils.toByteArray(inputStream);

                HttpHeaders responseHeaders = new HttpHeaders();
                String fileName= name + "-Estimation.txt";
                responseHeaders.add("content-disposition", "attachment; filename="+fileName);
                responseHeaders.add("Content-Type",type);

                respEntity = new ResponseEntity(out, responseHeaders,HttpStatus.OK);

            }
            catch(IOException e)
            {
                //
            }
         }
        return respEntity;

    }


}
