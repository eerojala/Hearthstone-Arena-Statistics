package Xml;

import java.io.File;
import junit.framework.Assert;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DocumentBuilderTest {

    Document doc;
    

    public DocumentBuilderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void buildDocument_returns_a_document_if_correct_filepath() {
        assertEquals(Document.class, DocumentBuilder.buildDocument("src/main/resources/DeckParseTest.xml").getClass());
    }

    @Test
    public void buildDocument_returns_null_if_invalid_filepath() {
        assertNull(DocumentBuilder.buildDocument("afsdfasfasf"));
    }
    
    @Test
    public void createDocument_returns_a_document() {
        assertEquals(Document.class, DocumentBuilder.createDocument("asfasf").getClass());
    }
    
    @Test
    public void createDocument_returns_a_document_with_correct_root_name() {
        Document doc = DocumentBuilder.createDocument("root");
        assertEquals("root", doc.getRootElement().getName());
    }
}
