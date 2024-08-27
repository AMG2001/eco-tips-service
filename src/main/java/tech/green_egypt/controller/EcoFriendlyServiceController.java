package tech.green_egypt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tech.green_egypt.domain.model.Tip;
import tech.green_egypt.repo.TipRepo;

@RestController
@RequestMapping("tips")
public class EcoFriendlyServiceController {

    private TipRepo tipRepo;


    @Autowired
    public EcoFriendlyServiceController(TipRepo tipRepo){
        this.tipRepo=tipRepo;
    }
    
    @GetMapping
    public ResponseEntity<?> getAllTips(){
       try{return ResponseEntity.ok(tipRepo.findAll());}
       catch(Exception e) {return ResponseEntity.internalServerError().build();}
    }


    @PostMapping
    public ResponseEntity<?> addNewTip(@RequestParam String tipContent,
    @RequestParam MultipartFile tipIcon){
        try{
            Tip newTip = new Tip();
            newTip.setTipContent(tipContent);
            newTip.setTipIcon(tipIcon.getBytes());
            return ResponseEntity.ok(tipRepo.save(newTip));
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
