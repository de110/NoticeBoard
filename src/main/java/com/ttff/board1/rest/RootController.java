package com.ttff.board1.rest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// @Controller
@RestController
@AllArgsConstructor
@Slf4j
public class RootController implements ErrorController {

    @GetMapping({ "/", "/error" })
    public String webController() {
        return "/";
    }

    // @Override
    public String getErrorPath() {
        return "/error";
    }
    // @GetMapping("")
    // public String main(Model model) {
    // log.info("INFO");
    // log.debug("DEBUG");
    // log.warn("WARN");
    // log.error("ERROR");
    // return "main";
    // }
}