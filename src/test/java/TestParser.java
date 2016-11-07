import com.parsers.dto.SectionsDTO;
import com.parsers.util.Parser;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Test for parser
 */
public class TestParser {

    private static String html;
    private static int sectionsInHtml = 85;

    private String getTextFromResource(String resPath) throws IOException {
        return IOUtils.toString(this.getClass().getResourceAsStream(resPath), "UTF-8");
    }

    @Before
    public void init() throws IOException {
        html = getTextFromResource("Page.html");
    }

    @Test
    public void shouldParseHTMLJsoup() {
        ArrayList<SectionsDTO> sectionsDTOs = Parser.parseHtml(html);
        sectionsDTOs.forEach(e -> {
            System.out.println(e);
            System.out.println();
        });
        assertTrue(sectionsInHtml == sectionsDTOs.size());
    }
}
