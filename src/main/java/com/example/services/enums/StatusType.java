package com.example.services.enums;

public enum StatusType {
        ALLOCATED(1,"Allocated"), LEFT(-1, "Left"), AVAILABLE(0, "Available");

        private final int value;
        private final String strValue;

        private StatusType(int value, String strValue) {
                this.value = value;
                this.strValue = strValue;
        }

        public int value() {
                return this.value;
        }

        public String strValue() {
                return this.strValue;
        }


        }
