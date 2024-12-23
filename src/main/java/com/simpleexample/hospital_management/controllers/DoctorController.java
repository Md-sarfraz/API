package com.simpleexample.hospital_management.controllers;

import com.simpleexample.hospital_management.model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {
    HashMap<Integer, Doctor> doctorDB = new HashMap<>();

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor inputDoctorRequest){
        doctorDB.put(inputDoctorRequest.getId(), inputDoctorRequest);
        return "doctor saved successfully";
    }
    @GetMapping("/findAll")
    public HashMap<Integer, Doctor> findAllDoctors(){
        return doctorDB;
    }
    @GetMapping("/findById/{id}")
    public Doctor findById(@PathVariable int id){
        Doctor doctor =doctorDB.get(id);
        return doctor;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteDoctorById(@PathVariable int id){
        doctorDB.remove(id);
        return "delete successfully";
    }
    @PutMapping("/update/{id}")
    public String updateDoctor(@PathVariable int id, @RequestBody Doctor updatedDoctorRequest){
        Doctor doctor = doctorDB.get(id);
        if(doctor!=null){
            doctorDB.put(updatedDoctorRequest.getId(), updatedDoctorRequest);
            return "update successfully";
        }
        else {
            return "doctor is not available";
        }
    }
}