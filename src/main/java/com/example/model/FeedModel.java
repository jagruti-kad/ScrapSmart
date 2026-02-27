package com.example.model;

public class FeedModel {
      private String User;
      private String Rate;
      private String Comment;

      public FeedModel(String User,String Rate,String Comment){
        this.User=User;
        this.Rate=Rate;
        this.Comment=Comment;
      }
            public String getUser() {
          return User;
      }
      public String getRate() {
          return Rate;
      }
      public String getComment() {
          return Comment;
      }

}
