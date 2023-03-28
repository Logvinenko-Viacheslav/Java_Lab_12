package com.example.lab12.controller;

import com.example.lab12.logic.LbModule;
import com.example.lab12.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LbController {
        @PostMapping("/calculated")
        public String calculate(@RequestParam("leftBorder") double leftBorder, @RequestParam("rightBorder") double rightBorder, @RequestParam("step") double step, Model model){
            LbModule lbModule = new LbModule();
            lbModule.setLeftBorder(leftBorder);
            lbModule.setRightBorder(rightBorder);
            lbModule.setStep(step);
            lbModule.createArrays();
            int stepNumb = lbModule.iterateNumb();
            int indexOfMax = lbModule.findIndexOfMaxY();
            double maxValue = lbModule.getY(indexOfMax);
            double xForMax = lbModule.getX(indexOfMax);
            int indexOfMin = lbModule.findIndexOfMinY();
            double minValue = lbModule.getY(indexOfMin);
            double xForMin = lbModule.getX(indexOfMin);
            double summ = lbModule.summY();
            double average = lbModule.middleY();
            Result result = new Result(leftBorder, rightBorder, step, stepNumb, maxValue, xForMax, indexOfMax, minValue, xForMin, indexOfMin, summ, average);
            model.addAttribute("results", result);
            return "calculated";
        }
        @GetMapping("/input")
        public String callInput(){
            return "input";
        }
}
