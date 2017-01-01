package com.paulovitor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    void executar(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
