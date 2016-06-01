package org.agoncal.application.invoice.batch;

import org.agoncal.application.invoice.model.Invoice;
import org.agoncal.application.invoice.model.InvoiceLine;
import org.agoncal.application.invoice.util.ResourceProducer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RunWith(Arquillian.class)
public class InvoiceJobTest {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private InvoiceReader invoiceReader;

    @Inject
    private InvoiceProcessor invoiceProcessor;

    @Inject
    private InvoiceWriter invoiceWriter;

    // ======================================
    // =         Deployment methods         =
    // ======================================

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Invoice.class)
                .addClass(InvoiceLine.class)
                .addClass(InvoiceSummary.class)
                .addClass(InvoiceSummaries.class)
                .addClass(InvoiceReader.class)
                .addClass(InvoiceProcessor.class)
                .addClass(InvoiceWriter.class)
                .addPackage(ResourceProducer.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsResource("import_h2.sql", "import_h2.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void should_be_deployed() {
        Assert.assertNotNull(invoiceReader);
        Assert.assertNotNull(invoiceProcessor);
        Assert.assertNotNull(invoiceWriter);
    }

    @Test @Ignore
    public void should_process_summary() throws Exception {
        List<Invoice> invoices = (List<Invoice>) invoiceReader.readItem();
        Assert.assertEquals(12, invoices.size());
        List<InvoiceSummary> summaries = (List<InvoiceSummary>) invoiceProcessor.processItem(invoices);
        Assert.assertEquals(3, summaries.size());
        List<Object> objects = new ArrayList<>();
        objects.addAll(summaries);
        invoiceWriter.writeItems(objects);
    }
}
