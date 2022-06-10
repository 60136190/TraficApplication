package com.example.traficapplication.activities.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question {


        @SerializedName("image")
        @Expose
        private QuestionImage image;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("question")
        @Expose
        private String question;
        @SerializedName("category")
        @Expose
        private QuestionCategory category;
        @SerializedName("answer")
        @Expose
        private List<Answer> answer = null;
        @SerializedName("__v")
        @Expose
        private Integer v;

        public QuestionImage getImage() {
            return image;
        }

        public void setImage(QuestionImage image) {
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

        public QuestionCategory getCategory() {
            return category;
        }

        public void setCategory(QuestionCategory category) {
            this.category = category;
        }

        public List<Answer> getAnswer() {
            return answer;
        }

        public void setAnswer(List<Answer> answer) {
            this.answer = answer;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }


}
