package com.trs.estimation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                List<String> notReq = new ArrayList<>() ;
                if(!Boolean.TRUE.equals(Boolean.valueOf(PhysicalSite)))
                    notReq.add("PhysicalSite");
                if(!Boolean.TRUE.equals(Boolean.valueOf(Demo)))
                    notReq.add("Demo");
                if(!Boolean.TRUE.equals(Boolean.valueOf(Mobile)))
                    notReq.add("Mobile");
                if(!Boolean.TRUE.equals(Boolean.valueOf(UI)))
                    notReq.add("UI");

                List<TaskEffort> allefforts =estimationDao.getEfforts(Size,Type);
                List<TaskEffort> modifiedEfforts=new ArrayList<>();
                modifiedEfforts.addAll(allefforts);
                if(!notReq.isEmpty())
                    modifiedEfforts= allefforts.stream().filter(taskEffort -> !notReq.stream().
                                                 anyMatch(taskName-> taskEffort.getName().startsWith(taskName)))
                                                .collect(Collectors.toList());
                File temp = File.createTempFile(name +" -Estimate ", Long.toString(System.nanoTime()));
                temp.deleteOnExit();

                PrintWriter writer = new PrintWriter(new FileWriter(temp));
                writer.println("TRS Backend Estimation:\n\n");
                writer.println();
                writer.println("Issue Name : "+name+"\t\tType: "+Type+"\t\tSize :"+Size);
                writer.println();
                writer.println();
                writer.println("Task\t\t\t\t Effort\n");
                writer.println("-------------------------------------------------");

                if(modifiedEfforts != null) {
                    modifiedEfforts.stream().filter(task-> task.getEffortInHours() > 0).forEach(task -> {
                        writer.println(task.getName() + "\t\t:" + task.getEffortInHours() + " Hrs. \n");
                    });
                    writer.println("-------------------------------------------------");
                    int totalEffort=modifiedEfforts.stream().filter(task-> task.getEffortInHours() > 0).mapToInt(TaskEffort::getEffortInHours).sum();
                    writer.println("Total Effort\t\t\t:" + totalEffort + " Hrs. \n");
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
                //.
            }
         }
        return respEntity;

    }


}
