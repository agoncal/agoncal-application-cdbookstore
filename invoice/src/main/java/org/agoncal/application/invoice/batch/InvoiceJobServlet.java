package org.agoncal.application.invoice.batch;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@WebServlet(name = "InvoiceJobServlet", urlPatterns = "startJob")
public class InvoiceJobServlet extends HttpServlet {

    // ======================================
    // =          Business methods          =
    // ======================================

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        jobOperator.start("InvoiceJob", null);
    }
}
