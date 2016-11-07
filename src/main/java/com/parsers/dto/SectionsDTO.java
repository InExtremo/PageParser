package com.parsers.dto;

/**
 * Created by Max on 07.11.2016.
 */
public class SectionsDTO {
    private String documentName;
    private String chapter;
    private String section;
    private String paragraph;
    private String content;

    public SectionsDTO() {
    }

    public SectionsDTO(String documentName, String chapter, String section, String paragraph, String content) {
        this.documentName = documentName;
        this.chapter = chapter;
        this.section = section;
        this.paragraph = paragraph;
        this.content = content;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionsDTO that = (SectionsDTO) o;

        if (documentName != null ? !documentName.equals(that.documentName) : that.documentName != null) return false;
        if (chapter != null ? !chapter.equals(that.chapter) : that.chapter != null) return false;
        if (section != null ? !section.equals(that.section) : that.section != null) return false;
        if (paragraph != null ? !paragraph.equals(that.paragraph) : that.paragraph != null) return false;
        return content != null ? content.equals(that.content) : that.content == null;

    }

    @Override
    public int hashCode() {
        int result = documentName != null ? documentName.hashCode() : 0;
        result = 31 * result + (chapter != null ? chapter.hashCode() : 0);
        result = 31 * result + (section != null ? section.hashCode() : 0);
        result = 31 * result + (paragraph != null ? paragraph.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "com.parsers.dto.SectionsDTO{" +
                "documentName='" + documentName + '\'' +
                ", chapter='" + chapter + '\'' +
                ", section='" + section + '\'' +
                ", paragraph='" + paragraph + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}