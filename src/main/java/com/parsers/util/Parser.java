package com.parsers.util;

import com.parsers.dto.SectionsDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Parse html pages.
 */
public class Parser {

    /**
     * Parse html and return List of sections blocks.
     *
     * @param file html content as text.
     * @return ArrayList of com.parsers.dto.SectionsDTO.
     */
    public static ArrayList<SectionsDTO> parseHtml(String file) {
        ArrayList<SectionsDTO> pageDatas = new ArrayList<>();
        Document doc = Jsoup.parse(file);
        String name = null;

        //Get document name for current file
        Elements documentName = doc.getElementsByClass("ancestor");
        if (documentName != null) {
            name = documentName.text();
        }

        String chapterFromId = "";


        Elements chapters = doc.getElementsByClass("chunk");
        if (chapters != null) {
            System.out.printf("Found %d chapters\n", chapters.size());

            if (!chapters.isEmpty()) {
                Iterator<Element> it = chapters.iterator();
                Element element;

                //Go foreach chunk in chunks
                while (it.hasNext()) {
                    element = it.next();
                    SectionsDTO chapter = new SectionsDTO();

                    //get chunk type by dot counts 1 string after split = title, 2 = chapter, 4 = sections
                    String[] strings = element.id().split("\\.");
                    //if chapter
                    if (strings.length == 2) {
                        Elements chapterName = element.getElementsByClass("chunk-title");
                        if (chapterName != null) {
                            chapterFromId = chapterName.text();
                        }
                    } else if (strings.length == 4) {/*if sections*/

                        chapter.setDocumentName(name);
                        chapter.setChapter(chapterFromId);
                        //get section name
                        Elements chapterName = element.getElementsByClass("chunk-title");
                        if (chapterName != null) {
                            chapter.setSection(chapterName.text());
                        }
                        //get section content
                        Elements chapterContent = element.getElementsByClass("chunk-content");
                        if (chapterName != null) {
                            chapterContent.select("p.historynote0").forEach(Node::remove);
                            chapter.setContent(chapterContent.text());
                        }
                        pageDatas.add(chapter);
                    }
                }
            }
        }
        return pageDatas;
    }
}
