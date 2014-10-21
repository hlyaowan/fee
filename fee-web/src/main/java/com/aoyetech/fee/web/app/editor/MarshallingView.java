/*
 * 
 */
// Created on 2013-4-16

package com.aoyetech.fee.web.app.editor;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.stream.StreamResult;

import org.springframework.oxm.Marshaller;
import org.springframework.util.FileCopyUtils;

/**
 * @author joe.chen
 */
public class MarshallingView extends org.springframework.web.servlet.view.xml.MarshallingView {

    private Marshaller marshaller;

    private byte[]     XML_HEADER_BYTES = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes();
    
    public MarshallingView(Marshaller marshaller){
        super(marshaller);
        this.marshaller = marshaller;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        Object toBeMarshalled = locateToBeMarshalled(model);
        if (toBeMarshalled == null) {
            throw new ServletException("Unable to locate object to be marshalled in model: " + model);
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
        bos.write(XML_HEADER_BYTES);

        marshaller.marshal(toBeMarshalled, new StreamResult(bos));

        response.setContentType(getContentType());
        response.setContentLength(bos.size());

        FileCopyUtils.copy(bos.toByteArray(), response.getOutputStream());
    }

}
