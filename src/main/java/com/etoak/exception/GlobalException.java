package com.etoak.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wfqing on 2020/4/22.
 */
@ControllerAdvice
@Slf4j
public class GlobalException {
    @ExceptionHandler(ParamException.class)
    public ModelAndView handleParamException(ParamException e) {
        log.error(e.getMessage(), e);
        ModelAndView view = new ModelAndView();
        view.addObject("error", e.getMessage());
        view.setViewName("error");
        return view;

    }

}
