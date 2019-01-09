package com.ycr.DTO;

import java.util.List;
import com.ycr.Model.*;


public class CreateDTO {

    Top Top;
    List<Question> QuestionList;

    public CreateDTO(Top Top, List<Question> QuestionList) {
        this.Top = Top;
        this.QuestionList = QuestionList;
    }

    public Top getTop() {
        return this.Top;
    }

    public void setTop(Top Top) {
        this.Top = Top;
    }

    public List<Question> getQuestionList() {
        return this.QuestionList;
    }

    public void setQuestionList(List<Question> QuestionList) {
        this.QuestionList = QuestionList;
    } 

}