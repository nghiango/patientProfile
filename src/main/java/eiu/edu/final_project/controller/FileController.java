package eiu.edu.final_project.controller;

import eiu.edu.final_project.domain.File;
import eiu.edu.final_project.domain.Medicine;
import eiu.edu.final_project.domain.Treatment;
import eiu.edu.final_project.repository.ITreatmentRepository;
import eiu.edu.final_project.service.FileServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@RestController
public class FileController {
    @Autowired
    FileServiceImpl fileService;
    @Autowired
    ITreatmentRepository iTreatmentRepository;
    public static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> createMedicine(@RequestBody File file, @RequestParam("file") MultipartFile image, UriComponentsBuilder ucBuilder){
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Medicine/{id}").buildAndExpand(file.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadMultipleFileHandler(@RequestParam(value = "files", required = false) MultipartFile mfile,
                                     @RequestParam("treatmentId") String treatmentId){
        Treatment treatment = getTreatmentById(Integer.parseInt(treatmentId));
        File file = new File();
        try {

            file.setTreatmentId(treatment);
            file.setImage(mfile.getBytes());
            fileService.saveFile(file);
            logger.info("You successfully uploaded file");
        } catch (IOException e) {
            logger.info("can not store file");
            e.printStackTrace();
        }
        return "";

    }

    public Treatment getTreatmentById(int id){
        return iTreatmentRepository.findById(id);
    }



    ////===================Delete file===================================
    @RequestMapping(value="/file/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMedicine(@PathVariable("id") int id){
        logger.info("Fetch & delete medicine with id {}", id);
        File file = fileService.findById(id);
        if(file==null){
            logger.info("unable to delete medicine with id {}, not found",id);
        }
        fileService.deleteFileById(id);
        return new ResponseEntity<Medicine>(HttpStatus.NO_CONTENT);
    }
}
