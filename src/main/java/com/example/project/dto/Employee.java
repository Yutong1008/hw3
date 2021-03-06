package com.example.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

        private String employee_name;
        private String employee_salary;
        private int id;
        private int employee_age;
        private String profile_image;

        public String getEmployee_name() {
                return employee_name;
        }

        public void setEmployee_name(String employee_name) {
                this.employee_name = employee_name;
        }

        public String getEmployee_salary() {
                return employee_salary;
        }

        public void setEmployee_salary(String employee_salary) {
                this.employee_salary = employee_salary;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public int getEmployee_age() {
                return employee_age;
        }

        public void setEmployee_age(int employee_age) {
                this.employee_age = employee_age;
        }

        public String getProfile_image() {
                return profile_image;
        }

        public void setProfile_image(String profile_image) {
                this.profile_image = profile_image;
        }
}
