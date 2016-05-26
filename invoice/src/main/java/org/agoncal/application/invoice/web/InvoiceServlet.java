package org.agoncal.application.invoice.web;

import org.agoncal.application.invoice.model.Invoice;
import org.agoncal.application.invoice.service.InvoiceService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@WebServlet(name = "InvoiceServlet", urlPatterns = "invoice")
public class InvoiceServlet extends HttpServlet {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private InvoiceService invoiceService;

    // ======================================
    // =          Business methods          =
    // ======================================

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Handle the request
        Long id = Long.valueOf(request.getParameter("id"));

        // Invoke the business logic
        Invoice invoice = invoiceService.findById(id);

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (invoice == null)
            out.print("No invoice with such id");
        else
            out.print(invoice);

    }
}
