package com.example.traficapplication.activities.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionAll{
    @SerializedName("image")
@Expose
private QuestionAllImage image;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("question")
        @Expose
        private String question;
        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("answer")
        @Expose
        private List<AnswerAll> answer = null;
        @SerializedName("__v")
        @Expose
        private Integer v;

        public QuestionAllImage getImage() {
            return image;
        }

        public void setImage(QuestionAllImage image) {
            this.image = image;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public List<AnswerAll> getAnswer() {
            return answer;
        }

        public void setAnswer(List<AnswerAll> answer) {
            this.answer = answer;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }

}

