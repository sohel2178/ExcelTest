package com.baudiabatash.exceltest;

import java.util.List;

/**
 * Created by Sohel on 1/29/2017.
 */

public class MyPojo {


    private List<Sheet1Bean> Sheet1;

    public List<Sheet1Bean> getSheet1() {
        return Sheet1;
    }

    public void setSheet1(List<Sheet1Bean> Sheet1) {
        this.Sheet1 = Sheet1;
    }

    public static class Sheet1Bean {
        /**
         * First_Name : Sohel
         * Last_Name : Ahmed
         * Email : sohel.ahmed2178@gmail.com
         */

        private String First_Name;
        private String Last_Name;
        private String Email;

        public String getFirst_Name() {
            return First_Name;
        }

        public void setFirst_Name(String First_Name) {
            this.First_Name = First_Name;
        }

        public String getLast_Name() {
            return Last_Name;
        }

        public void setLast_Name(String Last_Name) {
            this.Last_Name = Last_Name;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }
    }
}
